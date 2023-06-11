package io.github.unknowingtea.evedata.sourcing;

import io.github.unknowingtea.evedata.Util;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.MarketApi;
import io.swagger.client.model.GetMarketsRegionIdHistory200Ok;
import org.threeten.bp.LocalDate;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class MarketHistoryAssembler {

    private static final int FRESH_THRESHOLD_DAYS = 3;

    private String dataPath;
    private ApiClient apiClient;

    private static final double TOKENS_PER_SECOND = 5;
    private double numTokens = TOKENS_PER_SECOND;

    public MarketHistoryAssembler(String dataPath, ApiClient apiClient) {

        this.apiClient = apiClient;
        this.dataPath = dataPath;
    }

    public void assemble(int regionId, Collection<Integer> typeIds) throws ApiException, IOException {

        MarketApi marketApi = new MarketApi(apiClient);
        long lastTokenAddTime = System.currentTimeMillis();
        for(int curId : typeIds) {
            if (!isFresh(regionId, curId)) {
                numTokens -= 1;
                System.err.println("Requesting history for type id: " + curId);
                try {
                    List<GetMarketsRegionIdHistory200Ok> history = marketApi.getMarketsRegionIdHistory(regionId, curId, null, null);
                    add(regionId, curId, history);
                } catch (ApiException ex) {
                    // may be requesting an old ID that no longer exists, etc.

                }
            }
            long currentTime = System.currentTimeMillis();
            long timeDiffMillis = currentTime = lastTokenAddTime;
            double tokenDiff = (((double)timeDiffMillis) / 1000) * TOKENS_PER_SECOND;
            numTokens += tokenDiff;
            numTokens = Math.min(numTokens, TOKENS_PER_SECOND);
            lastTokenAddTime = currentTime;

            if(numTokens < 1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private void add(int regionId, int typeId, List<GetMarketsRegionIdHistory200Ok> history) throws IOException {

        File dataFile = new File(dataPath);
        if(!dataFile.exists()) {
            dataFile.mkdir();
        }
        File regionFile = getRegionFile(regionId);
        if(!regionFile.exists()) {
            regionFile.mkdir();
        }
        File typeFile = getTypeFile(regionId, typeId);

        LocalDate now = LocalDate.now();
        SavedMarketHistory savedHistory = new SavedMarketHistory();
        savedHistory.year = now.getYear();
        savedHistory.month = now.getMonthValue();
        savedHistory.dayOfMonth = now.getDayOfMonth();

        for(GetMarketsRegionIdHistory200Ok curHistory : history) {
            SavedMarketHistory.SavedMarketHistoryDay savedDay = new SavedMarketHistory.SavedMarketHistoryDay(curHistory);
            savedHistory.add(savedDay);
        }
        Util.writeJson(typeFile.getAbsolutePath(), savedHistory);
    }
    public HistoricalOrderStats getTradeHistory(int historyPeriodDays, int regionId, int typeId) throws IOException {

        HistoricalOrderStats result = new HistoricalOrderStats(historyPeriodDays);
        File typeFile = getTypeFile(regionId, typeId);
        LocalDate now = LocalDate.now();
        LocalDate endDate = now.minusDays(5);
        LocalDate startDate = endDate.minusDays(historyPeriodDays);
        if (typeFile.exists()) {
            SavedMarketHistory history = Util.readJson(typeFile.getAbsolutePath(), SavedMarketHistory.class);
            for(SavedMarketHistory.SavedMarketHistoryDay curDay : history.days) {
                LocalDate historyDate = LocalDate.of(curDay.year, curDay.month, curDay.dayOfMonth);
                if (historyDate.isAfter(startDate) && historyDate.isBefore(endDate)) {
                    result.addVolume(curDay.volume, curDay.average);
                }
            }
        }
        return result;
    }

    private File getRegionFile(int regionId) {
        File dataFile = new File(dataPath);
        File regionFile = new File(dataFile, "region"+regionId);
        return regionFile;
    }
    private File getTypeFile(int regionId, int typeId) {
        File regionFile = getRegionFile(regionId);
        File typeFile = new File(regionFile, "type"+typeId);

        return typeFile;
    }

    private boolean isFresh(int regionId, int typeId) throws IOException {

        File typeFile = getTypeFile(regionId, typeId);
        if (!typeFile.exists()) {
            return false;
        }

        SavedMarketHistory history = Util.readJson(typeFile.getAbsolutePath(), SavedMarketHistory.class);
        LocalDate savedDate = LocalDate.of(history.year, history.month, history.dayOfMonth);
        LocalDate freshDate = LocalDate.now().minusDays(3);
        return savedDate.isAfter(freshDate);

    }
}
