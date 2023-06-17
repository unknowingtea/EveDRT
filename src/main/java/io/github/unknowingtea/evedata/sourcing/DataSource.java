package io.github.unknowingtea.evedata.sourcing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Cache;
import io.github.unknowingtea.evedata.Util;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;
import io.swagger.client.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataSource {

    private final String AUTH_FILENAME = "auth.json";
    private Optional<String> accessToken = Optional.empty();
    private final String TYPES_FILENAME = "types.json";
    private final String HISTORY_FILENAME = "marketHistory";
    private final String cachePath = "dataCache";
    private Set<String> regionNames = null;

    private RegionMap regionMap = null;
    private MarketOrders marketOrders = null;
    private LocationMap locationMap = new LocationMap();
    private TypeMap typeMap;

    private Optional<MarketGroupMap> marketGroupMap = Optional.empty();

    public DataSource() throws IOException {

        File authFile = new File(AUTH_FILENAME);
        if (authFile.exists()) {
            String authJson = new String(Files.readAllBytes(Paths.get(AUTH_FILENAME)));
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> authMap = mapper.readValue(authJson, Map.class);
            this.accessToken = Optional.of(authMap.get("access_token"));
        }

        File cacheDir = new File(cachePath);
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }

        typeMap = readTypeCache();

    }

    public RegionMap getRegionMap() {
        return regionMap;
    }

    public Collection<Integer> getAllTypeIds() {
        return typeMap.allTypeIds();
    }
    private TypeMap readTypeCache() throws IOException {
        String path = cachePath + File.separator + TYPES_FILENAME;
        if (new File(path).exists()) {
            return Util.readJson(path, TypeMap.class);
        } else {
            return new TypeMap();
        }
    }

    private void writeTypeCache() throws IOException {
        String path = cachePath + File.separator + TYPES_FILENAME;
        Util.writeJson(path, typeMap);
    }

    /*
    public double getSellVolumePerDay(int region, int typeId) {
        return marketHistory.getSellVolumePerDay(region, typeId);
    }
     */

    public void loadMarketHistory(int regionId, Collection<Integer> typeIds) throws ApiException, IOException {
        String path = cachePath + File.separator + HISTORY_FILENAME;
        ApiClient client = newApiClient();
        MarketHistoryAssembler historyAssembler = new MarketHistoryAssembler(path, client);
        historyAssembler.assemble(regionId, typeIds);
    }

    public HistoricalOrderStats getTradeHistory(int historyPeriodDays, int regionId, int typeId) throws IOException {
        String path = cachePath + File.separator + HISTORY_FILENAME;
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

    /*
    private MarketHistory computeMarketHistory(String path) throws IOException {
        MarketHistory result = new MarketHistory(7);
        BufferedReader in = new BufferedReader(new FileReader(path));

        String line = in.readLine();
        StringTokenizer tok = new StringTokenizer(line, ";");
        List<String> columns = new ArrayList<String>();
        while(tok.hasMoreTokens()) {
            columns.add(tok.nextToken());
        }
        line = in.readLine();
        while (line != null) {

            tok = new StringTokenizer(line, ";");
            Map<String, String> rawEntry = new HashMap<>();
            int columnIndex = 0;
            while(tok.hasMoreTokens()) {
                rawEntry.put(columns.get(columnIndex), tok.nextToken());
                columnIndex++;
            }
            addRawEntry(result, rawEntry);

            line = in.readLine();
        }

        return result;
    }
    private void loadMarketHistory() throws IOException {
        String bulkDataPath = "bulkData";
        String weeklyTradesFilename = "marketOrderTrades_weekly.csv";
        String tradeStatsFilename = "tradeStats.json";

        String tradeStatsPath = bulkDataPath + File.separator + tradeStatsFilename;
        File tradeStatsFile = new File(tradeStatsPath);
        if(tradeStatsFile.exists()) {
            marketHistory = Util.readJson(tradeStatsPath, MarketHistory.class);
        } else {
            marketHistory = computeMarketHistory(bulkDataPath + File.separator + weeklyTradesFilename);
            Util.writeJson(tradeStatsPath, marketHistory);
        }

    }
    */

    public int getRegionBySystemId(int systemId) throws ApiException {
        ApiClient client = newApiClient();
        UniverseApi universe = new UniverseApi(client);
        GetUniverseSystemsSystemIdOk system = universe.getUniverseSystemsSystemId(systemId, null, null, null, null);
        GetUniverseConstellationsConstellationIdOk constellation = universe.getUniverseConstellationsConstellationId(system.getConstellationId(), null, null, null, null);
        return constellation.getRegionId();
    }

    private ApiClient newApiClient() {
        ApiClient client = new ApiClient();
        File cacheDir = new File("apiCache");
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
