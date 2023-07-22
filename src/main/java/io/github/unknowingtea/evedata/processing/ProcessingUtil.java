package io.github.unknowingtea.evedata.processing;

import io.github.unknowingtea.evedata.sourcing.MarketGroupMap;
import io.swagger.client.model.GetMarketsGroupsMarketGroupIdOk;
import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;

import java.io.PrintStream;
import java.util.*;

public class ProcessingUtil {

    private static <T> void addSorted(List<T> ls, T elm, Comparator<T> cmp) {
        int index = Collections.binarySearch(ls, elm, cmp);
        if (index < 0) {
            index = -index - 1;
        }
        ls.add(index, elm);
    }
    public static void sortFilterOrders(PrintStream out, Optional<Set<Long>> buyStationIdsOpt, Optional<Set<Long>> sellStationIdsOpt, Collection<GetMarketsRegionIdOrders200Ok> allOrders, Map<Integer, List<GetMarketsRegionIdOrders200Ok>> sellOrdersByType, Map<Integer, List<GetMarketsRegionIdOrders200Ok>> buyOrdersByType) {
        Comparator<GetMarketsRegionIdOrders200Ok> sellPriceComparator = new OrderPriceComparator(true);
        Comparator<GetMarketsRegionIdOrders200Ok> buyPriceComparator = new OrderPriceComparator(false);

        out.println("sorting " + allOrders.size() + " orders");
        for(GetMarketsRegionIdOrders200Ok curOrder : allOrders) {
            Map<Integer, List<GetMarketsRegionIdOrders200Ok>> destMap = sellOrdersByType;
            Comparator<GetMarketsRegionIdOrders200Ok> priceComparator = sellPriceComparator;
            Optional<Set<Long>> stationIds = buyStationIdsOpt;

            if(curOrder.isIsBuyOrder()) {
                destMap = buyOrdersByType;
                priceComparator = buyPriceComparator;
                stationIds = sellStationIdsOpt;
            }

            if ((!stationIds.isPresent()) || stationIds.get().contains(curOrder.getLocationId().longValue())) {
                List<GetMarketsRegionIdOrders200Ok> idList = destMap.get(curOrder.getTypeId());
                if (idList == null) {
                    idList = new ArrayList<>();
                    destMap.put(curOrder.getTypeId(), idList);
                }
                addSorted(idList, curOrder, priceComparator);
            }
        }
    }

    public static double calc5P_SellPrice(List<GetMarketsRegionIdOrders200Ok> orders) {

        long totalVolume = 0;
        for (GetMarketsRegionIdOrders200Ok curOrder : orders) {
            if (!curOrder.isIsBuyOrder()) {
                totalVolume += curOrder.getVolumeRemain();
            }
        }

        long numToSkip = (long)(totalVolume * 0.05);
        for (GetMarketsRegionIdOrders200Ok curOrder : orders) {
            if (!curOrder.isIsBuyOrder()) {
                numToSkip -= curOrder.getVolumeRemain();
                if (numToSkip <= 0) {
                    return curOrder.getPrice();
                }
            }
        }

        throw new RuntimeException("error when calculating 5% Jita price");

    }

    public static boolean isScamPrice(double scamPriceMultiple, double price, Optional<Double> jita5PSellPrice, double averageHistoricalPrice) {
        if (jita5PSellPrice.isPresent() && price < scamPriceMultiple * jita5PSellPrice.get()) {
            return false;
        }

        if (averageHistoricalPrice > 0 && price < scamPriceMultiple * averageHistoricalPrice) {
            return false;
        }

        return true;

    }

    public static boolean belongsToMarketGroup(Integer marketGroupId, Set<Integer> marketGroups, MarketGroupMap marketGroupMap) {

        if (marketGroupId == null) {
            // some types have no market group?
            return false;
        }
        GetMarketsGroupsMarketGroupIdOk curGroup = marketGroupMap.get(marketGroupId);
        if (curGroup == null) {
            System.err.println("market group " + marketGroupId + " not found");
            return false;
        }
        if (marketGroups.contains(curGroup.getMarketGroupId())) {
            return true;
        }

        while(curGroup.getParentGroupId() != null) {
            curGroup = marketGroupMap.get(curGroup.getParentGroupId());
            if (curGroup == null) {
                // parent group not in map?
                return false;
            }
            if (marketGroups.contains(curGroup.getMarketGroupId())) {
                return true;
            }
        }

        return false;

    }

}
