package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;

import java.util.*;

public class MarketOrders implements Collector<List<GetMarketsRegionIdOrders200Ok>> {

    private static class GlobalOrderId {

        private int regionId;
        private long orderId;

        public GlobalOrderId(int regionId, long orderId) {
            this.regionId = regionId;
            this.orderId = orderId;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof GlobalOrderId)) {
                return false;
            }

            GlobalOrderId rhs = (GlobalOrderId)obj;
            return rhs.regionId == regionId && rhs.orderId==orderId;
        }

        @Override
        public int hashCode() {
            return (int)(regionId * 31 + orderId);
        }
    }

    private int collectingRegionId = 0;
    private Map<GlobalOrderId, GetMarketsRegionIdOrders200Ok> allOrders = new HashMap<>();
    private Set<Integer> allTypeIds = new HashSet<>();
    private Set<Long> allLocationIds = new HashSet<>();

    private Map<Long, Map<Integer, OrderStats>> stationItemOrderStats = new HashMap<>();

    public Collection<GetMarketsRegionIdOrders200Ok> getAllOrders() {
        return allOrders.values();
    }

    @Override
    public void add(List<GetMarketsRegionIdOrders200Ok> orders) {

        for(GetMarketsRegionIdOrders200Ok curOrder : orders) {
            GlobalOrderId orderId = new GlobalOrderId(collectingRegionId, curOrder.getOrderId());
            allOrders.put(orderId, curOrder);

            allTypeIds.add(curOrder.getTypeId());

            allLocationIds.add(curOrder.getLocationId());

            updateStats(curOrder);
        }
    }

    private void updateStats(GetMarketsRegionIdOrders200Ok order) {
        Map<Integer, OrderStats> stationStatsMap = stationItemOrderStats.get(order.getLocationId());
        if (stationStatsMap == null) {
            stationStatsMap = new HashMap<>();
            stationItemOrderStats.put(order.getLocationId(), stationStatsMap);
        }

        OrderStats itemStats = stationStatsMap.get(order.getTypeId());
        if (itemStats == null) {
            itemStats = new OrderStats();
            stationStatsMap.put(order.getTypeId(), itemStats);
        }

        double price = order.getPrice();
        long volumeRemain = order.getVolumeRemain();
        if (order.isIsBuyOrder()) {
            if ((!itemStats.highBuyPrice.isPresent()) || itemStats.highBuyPrice.get() < price) {
                itemStats.highBuyPrice = Optional.of(price);
            }
            itemStats.numBuyItems += volumeRemain;
        } else {
            if ((!itemStats.lowSellPrice.isPresent()) || itemStats.lowSellPrice.get() > price) {
                itemStats.lowSellPrice = Optional.of(price);
            }
            itemStats.numSellItems += volumeRemain;
        }

    }

    public void setCollectingRegion(int regionId) {
        this.collectingRegionId = regionId;
    }

    public Collection<Integer> getAllTypeIds() {
        return allTypeIds;
    }

    public Collection<Long> getAllLocationIds() {
        return allLocationIds;
    }

    OrderStats getItemOrderStats(long locationId, int typeId) {
        return stationItemOrderStats.get(locationId).get(typeId);
    }
}
