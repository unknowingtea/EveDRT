package io.github.unknowingtea.evedata.sourcing;

public class ItemTradeHistory {

    private double sellVolume = 0;
    private double buyVolume = 0;

    public void setSellVolume(double sellVolume) {
        this.sellVolume = sellVolume;
    }
    public double getSellVolume() {
        return sellVolume;
    }

    public void setBuyVolume(double buyVolume) {
        this.buyVolume = buyVolume;
    }
    public double getBuyVolume() {
        return buyVolume;
    }

    public void add(HistoricalOrder order) {
        if (order.hasGone()) {
            if (order.isBuyOrder()) {
                buyVolume += order.getAmount();
            } else {
                sellVolume += order.getAmount();
            }
        }
    }
}
