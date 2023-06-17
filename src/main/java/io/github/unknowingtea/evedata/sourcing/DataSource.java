package io.github.unknowingtea.evedata.sourcing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Cache;
import io.github.unknowingtea.evedata.Util;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;
import io.swagger.client.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataSource {

    private static final String AUTH_FILENAME = "auth.json";
    private static final String API_CACHE_DIRNAME = "apiCache";
    private Optional<String> accessToken = Optional.empty();
    private static final String TYPES_FILENAME = "types.json";
    private static final String HISTORY_DIRNAME = "marketHistory";
    private static final String LOCAL_CACHE_DIRNAME = "dataCache";
    
    private static final String ALL_CACHE_DIRNAME = "cache";
    private Set<String> regionNames = null;

    private RegionMap regionMap = null;
    private MarketOrders marketOrders = null;
    private LocationMap locationMap = new LocationMap();
    private TypeMap typeMap;

    private Optional<MarketGroupMap> marketGroupMap = Optional.empty();

    public DataSource() throws IOException {

        File authFile = new File(getAuthFilePath());
        if (authFile.exists()) {
            String authJson = new String(Files.readAllBytes(Paths.get(getAuthFilePath())));
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> authMap = mapper.readValue(authJson, Map.class);
            this.accessToken = Optional.of(authMap.get("access_token"));
        }

        File cacheDir = new File(getApiCachePath());
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }

        typeMap = readTypeCache();

    }

    private static void mkDirs() {
        File allCacheDir = new File(ALL_CACHE_DIRNAME);
        if (!allCacheDir.exists()) {
            allCacheDir.mkdir();
        }
    }

    public static void doAuth() throws Exception {

        mkDirs();

        EveAuth auth = new EveAuth();
        auth.authorize();
        String authResponse = auth.getResponse();
        PrintWriter out = new PrintWriter(new FileWriter(getAuthFilePath()));
        out.println(authResponse);
        out.close();
    }

    private static String getApiCachePath() {
        return ALL_CACHE_DIRNAME + File.separator + API_CACHE_DIRNAME;
    }

    public RegionMap getRegionMap() {
        return regionMap;
    }

    public Collection<Integer> getAllTypeIds() {
        return typeMap.allTypeIds();
    }
    private TypeMap readTypeCache() throws IOException {
        String path = getTypesCachePath();
        if (new File(path).exists()) {
            return Util.readJson(path, TypeMap.class);
        } else {
            return new TypeMap();
        }
    }

    private static final String getLocalCachePath() {
        return ALL_CACHE_DIRNAME + File.separator + LOCAL_CACHE_DIRNAME;
    }
    private static final String getTypesCachePath() {
        return getLocalCachePath() + File.separator + TYPES_FILENAME;
    }

    private static final String getAuthFilePath() {
        return ALL_CACHE_DIRNAME + File.separator + AUTH_FILENAME;
    }

    private static final String getHistoryCachePath() {
        return getLocalCachePath() + File.separator + HISTORY_DIRNAME;
    }

    private void writeTypeCache() throws IOException {
        String path = getTypesCachePath();
        Util.writeJson(path, typeMap);
    }

    public void loadMarketHistory(int regionId, Collection<Integer> typeIds) throws ApiException, IOException {
        String path = getHistoryCachePath();
        ApiClient client = newApiClient();
        MarketHistoryAssembler historyAssembler = new MarketHistoryAssembler(path, client);
        historyAssembler.assemble(regionId, typeIds);
    }

    public HistoricalOrderStats getTradeHistory(int historyPeriodDays, int regionId, int typeId) throws IOException {
        String path = getHistoryCachePath();
        ApiClient client = newApiClient();
        MarketHistoryAssembler historyAssembler = new MarketHistoryAssembler(path, client);
        return historyAssembler.getTradeHistory(historyPeriodDays, regionId, typeId);
    }

    public OrderStats getOrderStats(long locationId, int typeId) {
        return marketOrders.getItemOrderStats(locationId, typeId);
    }
    public Collection<GetMarketsRegionIdOrders200Ok> getAllMarketOrders() {
        return marketOrders.getAllOrders();
    }

    public GetUniverseStationsStationIdOk getStationByName(String name) {
        return locationMap.getStationByName(name);
    }

    public Long getStructureIdByName(String name) {
        return locationMap.getStructureIdByName(name);
    }

    public GetUniverseStationsStationIdOk getStationById(int id) {
        return locationMap.getStationById(id);
    }

    public GetUniverseTypesTypeIdOk getTypeById(int id) {
        return typeMap.getById(id);
    }

    public void loadMarketGroups() throws ApiException, IOException {
        if (!marketGroupMap.isPresent()) {
            MarketGroupMap newMap = new MarketGroupMap();
            marketGroupMap = Optional.of(newMap);
            ApiClient client = newApiClient();
            MarketGroupMapAssembler marketGroupMapAssembler = new MarketGroupMapAssembler(newMap, client);
            marketGroupMapAssembler.assemble();
        }
    }

    public MarketGroupMap getMarketGroupMap() throws ApiException, IOException {
        loadMarketGroups();
        return marketGroupMap.get();
    }

    public void loadMarketOrders(Set<String> regionNames) throws ApiException, IOException {

        if (!regionNamesEqual(this.regionNames, regionNames)) {
            reloadMarketOrders(regionNames);
        }
    }

    public StructureOrders loadStructureOrders(long structureId) throws ApiException, IOException {
        ApiClient client = newApiClient();
        StructureOrdersAssembler assembler = new StructureOrdersAssembler(client, structureId, accessToken.get());
        assembler.assemble();
        return assembler.getStructureOrders();
    }

    private static boolean regionNamesEqual(Set<String> set1, Set<String> set2) {
        if (set1 == null || set2 == null) {
            return false;
        }

        return set1.containsAll(set2) && set2.containsAll(set1);
    }

    private void addRawEntry(MarketHistory history, Map<String, String> entry) {

        int regionId = Integer.parseInt(entry.get("region_id"));
        int itemId = Integer.parseInt(entry.get("type_id"));
        long amount = Long.parseLong(entry.get("amount"));
        int isBuyOrderInt = Integer.parseInt(entry.get("is_buy_order"));
        boolean isBuyOrder = isBuyOrderInt != 0;
        int hasGoneInt = Integer.parseInt(entry.get("has_gone"));
        boolean hasGone = hasGoneInt != 0;

        HistoricalOrder order = new HistoricalOrder(regionId, itemId, amount, isBuyOrder, hasGone);
        history.add(order);
    }

    public int getRegionBySystemId(int systemId) throws ApiException {
        ApiClient client = newApiClient();
        UniverseApi universe = new UniverseApi(client);
        GetUniverseSystemsSystemIdOk system = universe.getUniverseSystemsSystemId(systemId, null, null, null, null);
        GetUniverseConstellationsConstellationIdOk constellation = universe.getUniverseConstellationsConstellationId(system.getConstellationId(), null, null, null, null);
        return constellation.getRegionId();
    }

    private ApiClient newApiClient() {
        ApiClient client = new ApiClient();
        File cacheDir = new File(getApiCachePath());
        long cacheSize = 50L * 1024L * 1024L;
        client.getHttpClient().setCache(new Cache(cacheDir, cacheSize));
        if (accessToken.isPresent()) {
            client.addDefaultHeader("token", accessToken.get());
        }
        return client;
    }
    public void reloadMarketOrders(Set<String> regionNames) throws ApiException, IOException {

        /*
        if (marketHistory == null) {
            loadMarketHistory();
        }
         */

        this.regionNames = regionNames;

        ApiClient client = newApiClient();

        // load the region map only once
        if (regionMap == null) {
            System.err.println("Fetching regions");
            RegionMapAssembler regionsAssembler = new RegionMapAssembler(client);
            regionsAssembler.assemble();
            regionMap = regionsAssembler.getRegionMap();
        }

        // load market orders---clear out the old data each time
        MarketOrdersAssembler ordersAssembler = new MarketOrdersAssembler(client);
        for(String curRegionName : regionNames) {
            System.err.println("Fetching orders for " + curRegionName);
            ordersAssembler.assemble(regionMap.getByName(curRegionName).getRegionId());
        }
        marketOrders = ordersAssembler.getMarketOrders();

        // Load locations that we don't already have in the location map
        System.err.println("Fetching stations");
        LocationMapStationsAssembler locationMapStationsAssembler = new LocationMapStationsAssembler(locationMap, client);
        locationMapStationsAssembler.assemble(marketOrders.getAllLocationIds());

        System.err.println("Fetching structures");
        LocationMapStructuresAssembler locationMapStructuresAssembler = new LocationMapStructuresAssembler(locationMap, client, accessToken.get());
        locationMapStructuresAssembler.assemble(marketOrders.getAllLocationIds());

        // load relevant types
        System.err.println("Fetching item types");
        TypeMapAssembler typeMapAssembler = new TypeMapAssembler(typeMap, client);
        // split type ID fetch into multiple parts so we can periodically save to cache
        int completedTypes = 0;
        List<Integer> idList = new ArrayList<>();
        int typesCount = marketOrders.getAllTypeIds().size();
        for (int curId : marketOrders.getAllTypeIds()) {
            idList.add(curId);
            completedTypes++;
            if (completedTypes % 500 == 0) {
                typeMapAssembler.assemble(idList);
                writeTypeCache();
                idList.clear();
                System.err.println("types remaining: " + (typesCount - completedTypes));
            }
        }
        typeMapAssembler.assemble(idList);

        writeTypeCache();

    }

}
