package io.github.unknowingtea.evedata.sourcing;

import java.util.*;

public class MarketHistory {

    private Map<Integer, Map<Integer, ItemTradeHistory>> historyByRegion = new HashMap<>();
    private int numDays;

    public MarketHistory() {
        this.numDays = 7;
    }
    public MarketHistory(int numDays) {
        this.numDays = numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }
    public int getNumDays() {
        return numDays;
    }

    public double getSellVolumePerDay(int region, int typeId) {
        ItemTradeHistory history = historyByRegion.get(region).get(typeId);
        if (history == null) {
            return 0;
        }

        return history.getSellVolume() / numDays;
    }

    public void setHistoryByRegion(Map<Integer, Map<Integer, ItemTradeHistory>> historyByRegion) {
        this.historyByRegion = historyByRegion;
    }
    public Map<Integer, Map<Integer, ItemTradeHistory>> getHistoryByRegion() {
        return historyByRegion;
    }

    public void add(HistoricalOrder order) {

        Map<Integer, ItemTradeHistory> historyByItemId = historyByRegion.get(order.getRegionId());
        if (historyByItemId == null) {
            historyByItemId = new HashMap<>();
            historyByRegion.put(order.getRegionId(), historyByItemId);
        }

        ItemTradeHistory itemHistory = historyByItemId.get(order.getItemId());
        if (itemHistory == null) {
            itemHistory = new ItemTradeHistory();
            historyByItemId.put(order.getItemId(), itemHistory);
        }
        itemHistory.add(order);
    }

}
