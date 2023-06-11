package io.github.unknowingtea.evedata.sourcing;

public class HistoricalOrderStats {

    private long totalVolume = 0;
    private double averagePrice = 0;
    private final int numDays;
    public HistoricalOrderStats(int numDays) {
        this.numDays = numDays;
    }
    public void addVolume(long volume, double average) {
        if (totalVolume > 0) {
            averagePrice = averagePrice * (totalVolume / (Double.valueOf(totalVolume) + volume));
            averagePrice += average * (volume / (Double.valueOf(totalVolume) + volume));
        } else {
            averagePrice = average;
        }

        totalVolume += volume;
    }

    public double getVolumePerDay() {
        return ((double)totalVolume) / numDays;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

}
