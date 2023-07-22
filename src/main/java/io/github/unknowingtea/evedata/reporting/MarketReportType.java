package io.github.unknowingtea.evedata.reporting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class MarketReportType {
    public int typeId;
    private Map<Long, Long> volumeRemaining = new HashMap<>();
    public double soldPerDay;

    public Optional<Double> jita5P_Price = Optional.empty();
    public Optional<Double> lowestJitaPrice = Optional.empty();
    private Map<Long, Double> lowestLocalSellPrice = new HashMap();

    public double averagePrice;

    public void setVolumeRemaining(long structureId, long amount) {
        volumeRemaining.put(structureId, amount);
    }
    public long getVolumeRemaining(long structureId) {
        return volumeRemaining.get(structureId);
    }

    public long getTotalVolumeRemaining() {
        long result = 0;
        for (long curAmount : volumeRemaining.values()) {
            result += curAmount;
        }
        return result;
    }

    public void setLowestLocalSellPrice(long structureId, double price) {
        lowestLocalSellPrice.put(structureId, price);
    }
    public double getLowestLocalSellPrice(long structureId) {
        return lowestLocalSellPrice.get(structureId);
    }

    public double calcDaysRemaining() {
        long totalVolume = 0;
        for (long curVolume : volumeRemaining.values()) {
            totalVolume += curVolume;
        }
        return totalVolume / soldPerDay;
    }

    public static class Compare implements Comparator<MarketReportType> {

        @Override
        public int compare(MarketReportType o1, MarketReportType o2) {
            int remainingComp = Double.compare(o1.calcDaysRemaining(), o2.calcDaysRemaining());
            return remainingComp;
        }
    }
}