package io.github.unknowingtea.evedata.processing;

import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<GetMarketsRegionIdOrders200Ok> {

    private final boolean lt;

    public OrderPriceComparator(boolean lt) {
        this.lt = lt;
    }
    @Override
    public int compare(GetMarketsRegionIdOrders200Ok o1, GetMarketsRegionIdOrders200Ok o2) {

        int ltCompare = o1.getPrice().compareTo(o2.getPrice());
        if (lt) {
            return ltCompare;
        } else {
            return -1*ltCompare;
        }
    }
}
