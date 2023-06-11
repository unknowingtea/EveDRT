package io.github.unknowingtea.evedata.sourcing;

public class HistoricalOrder {

    private final int regionId;
    private final int itemId;

    private final long amount;
    private final boolean isBuyOrder;
    private final boolean hasGone;

    public HistoricalOrder(int regionId, int itemId, long amount, boolean isBuyOrder, boolean hasGone) {
        this.regionId = regionId;
        this.itemId = itemId;
        this.amount = amount;
        this.isBuyOrder = isBuyOrder;
        this.hasGone = hasGone;
    }

    public int getRegionId() {
        return regionId;
    }
    public int getItemId() {
        return itemId;
    }
    public long getAmount() {
        return amount;
    }
    public boolean isBuyOrder() {
        return isBuyOrder;
    }
    public boolean hasGone() {
        return hasGone;
    }
}
