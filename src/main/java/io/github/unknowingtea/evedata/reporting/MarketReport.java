package io.github.unknowingtea.evedata.reporting;

import io.github.unknowingtea.evedata.MarketQuery;
import io.github.unknowingtea.evedata.processing.ProcessingUtil;
import io.github.unknowingtea.evedata.sourcing.DataSource;
import io.github.unknowingtea.evedata.sourcing.HistoricalOrderStats;
import io.github.unknowingtea.evedata.sourcing.MarketGroupMap;
import io.github.unknowingtea.evedata.sourcing.StructureOrders;
import io.swagger.client.ApiException;
import io.swagger.client.model.GetMarketsGroupsMarketGroupIdOk;
import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;
import io.swagger.client.model.GetMarketsStructuresStructureId200Ok;
import io.swagger.client.model.GetUniverseTypesTypeIdOk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class MarketReport {

    public static List<MarketReportType> queryAndReport(DataSource data, MarketQuery marketQuery,
        Optional<Map<Integer, List<GetMarketsRegionIdOrders200Ok>>> sellOrdersByTypeOpt,
                                                        Optional<Map<Integer, Double>> jita5pPriceByTypeOpt,
                                                        Optional<PricePredicate> pricePredicateOpt) throws IOException, ApiException {
        List<MarketReportType> report = query(data, marketQuery, sellOrdersByTypeOpt, jita5pPriceByTypeOpt, pricePredicateOpt);

        String pattern = "ddMMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String region = marketQuery.regionName.toLowerCase().replace(' ', '_');
        String filePrefix = "market_" + region + "_";
        if (marketQuery.filePrefix != null) {
            filePrefix = marketQuery.filePrefix + "_";
        }
        String filename = filePrefix + date + ".csv";
        write(data, marketQuery, report, filename);
        return report;
    }

    public static List<MarketReportType> query(DataSource data, MarketQuery marketQuery,
                                               Optional<Map<Integer, List<GetMarketsRegionIdOrders200Ok>>> sellOrdersByTypeOpt,
                                               Optional<Map<Integer, Double>> jita5pPriceByTypeOpt,
                                               Optional<PricePredicate> pricePredicateOpt) throws IOException, ApiException {

        PricePredicate pricePredicate = pricePredicateOpt.orElse(new ScamPricePredicate(marketQuery.scamPriceMultiple));

        Set<String> regionNames = new HashSet<>();
        regionNames.add("The Forge");
        regionNames.add(marketQuery.regionName);
        data.loadMarketOrders(regionNames);
        Collection<GetMarketsRegionIdOrders200Ok> allOrders = data.getAllMarketOrders();
        Map<Integer, List<GetMarketsRegionIdOrders200Ok>> buyOrdersByType = new HashMap<>();
        Map<Integer, List<GetMarketsRegionIdOrders200Ok>> sellOrdersByType = sellOrdersByTypeOpt.orElse(new HashMap<>());
        long jitaId = data.getStationByName("Jita IV - Moon 4 - Caldari Navy Assembly Plant").getStationId();
        Set<Long> jitaIdSet = new HashSet<>();
        jitaIdSet.add(jitaId);
        Optional<Set<Long>> jitaIdOpt = Optional.of(jitaIdSet);
        ProcessingUtil.sortFilterOrders(System.out, jitaIdOpt, jitaIdOpt, allOrders, sellOrdersByType, buyOrdersByType);

        Collection<Integer> allTypeIds = new HashSet<>();
        allTypeIds.addAll(data.getAllTypeIds());

        Map<Long, StructureOrders> localOrders = new HashMap<>();
        for (String curStationName : marketQuery.stationNames) {
            Long structureId = data.getStructureIdByName(curStationName);
            if (structureId == null) {
                throw new RuntimeException("No structure named: \"" + curStationName + "\" in " + marketQuery.regionName);
            }
            StructureOrders orders = data.loadStructureOrders(structureId);
            allTypeIds.addAll(orders.getAllTypeIds());
            localOrders.put(structureId, orders);
        }

        System.err.println("Loading market groups");
        MarketGroupMap marketGroupMap = data.getMarketGroupMap();

        int regionId = data.getRegionMap().getByName(marketQuery.regionName).getRegionId();
        System.err.println("Loading market history for region: " + marketQuery.regionName);
        if (marketQuery.maxItemTypes != null) {
            List<Integer> smallerTypeIds = new ArrayList<>();
            int numToAdd = marketQuery.maxItemTypes;
            int numAdded = 0;
            for(int curId : allTypeIds) {
                if (numAdded < numToAdd) {
                    smallerTypeIds.add(curId);
                    numAdded++;
                }
            }
            allTypeIds = smallerTypeIds;
        }
        int numTypes = allTypeIds.size();
        System.err.println("number of type ids: " + numTypes);
        data.loadMarketHistory(regionId, allTypeIds);

        Map<Integer, Double> jita5pPriceByType = jita5pPriceByTypeOpt.orElse(new HashMap<>());
        List<MarketReportType> report = new ArrayList<>();
        for(int curId: allTypeIds) {
            GetUniverseTypesTypeIdOk curType = data.getTypeById(curId);

            HistoricalOrderStats history = data.getTradeHistory(marketQuery.historyPeriodDays, regionId, curId);
            List<GetMarketsRegionIdOrders200Ok> jitaSellOrders = sellOrdersByType.get(curId);

            MarketReportType reportItem = new MarketReportType();
            reportItem.typeId = curId;

            if (jitaSellOrders != null && !jitaSellOrders.isEmpty()) {
                double jitaSellPrice = ProcessingUtil.calc5P_SellPrice(jitaSellOrders);
                jita5pPriceByType.put(curId, jitaSellPrice);
                reportItem.jita5P_Price  = Optional.of(jitaSellPrice);
                reportItem.lowestJitaPrice = Optional.of(jitaSellOrders.get(0).getPrice());
            }

            long totalVolumeRemaining = 0;
            for (long curStructureId : localOrders.keySet()) {

                StructureOrders orders = localOrders.get(curStructureId);
                long numForSale = 0;
                List<GetMarketsStructuresStructureId200Ok> ordersForType = orders.getByTypeId(curId);
                if (ordersForType == null) {
                    ordersForType = new ArrayList<>();
                }

                double lowestLocalSellPrice = Double.POSITIVE_INFINITY;
                for (GetMarketsStructuresStructureId200Ok curOrder : ordersForType) {

                    if (!curOrder.isIsBuyOrder()) {
                        lowestLocalSellPrice = Math.min(lowestLocalSellPrice, curOrder.getPrice());
                        if (pricePredicate.accept(curOrder.getPrice(), history.getAveragePrice(), reportItem.jita5P_Price, curType)
                        ) {
                            numForSale += curOrder.getVolumeRemain();
                        }
                    }
                }

                reportItem.setLowestLocalSellPrice(curStructureId, lowestLocalSellPrice);
                reportItem.setVolumeRemaining(curStructureId, numForSale);
                totalVolumeRemaining += numForSale;
            }

            reportItem.soldPerDay = history.getVolumePerDay();
            reportItem.averagePrice = history.getAveragePrice();
            // round down really infrequent purchases
            if (reportItem.soldPerDay <= marketQuery.minSalesPerDay) {
                reportItem.soldPerDay = 0.0;
            }

            double daysRemaining = totalVolumeRemaining / reportItem.soldPerDay;

            if (!ProcessingUtil.belongsToMarketGroup(curType.getMarketGroupId(), marketQuery.filteredMarketGroups, marketGroupMap) &&
                    !marketQuery.filteredItemTypes.contains(curType.getTypeId()) &&
                    Double.isFinite(daysRemaining) &&
                    daysRemaining < marketQuery.maxDaysRemaining &&
                    (!reportItem.jita5P_Price.isPresent() || reportItem.jita5P_Price.get() <= marketQuery.maxJitaPrice)) {
                report.add(reportItem);
            }
        }

        report.sort(new MarketReportType.Compare());

        return report;
    }

    public static void write(DataSource data, MarketQuery marketQuery, List<MarketReportType> report, String filename) throws IOException, ApiException {

        MarketGroupMap marketGroupMap = data.getMarketGroupMap();

        PrintWriter out = new PrintWriter(new FileWriter(filename));

        out.print("Name, ");
        for (String curStationName : marketQuery.stationNames) {
            out.print("Left in " + curStationName.substring(0, 6) + ",");
        }
        out.print("Sold Per Day, Days Remaining, ");
        for (String curStationName : marketQuery.stationNames) {
            out.print("Lowest Price in " + curStationName.substring(0, 6) + ",");
        }
        out.println("Historical Average Price, Lowest Price in Jita, 5% Price in Jita, Type ID, Packaged Volume, Market Group");


        Map<Integer, Double> supplyDaysPerUnit = new HashMap<>();
        for(MarketReportType curItem : report) {

            supplyDaysPerUnit.put(curItem.typeId, 1 / curItem.soldPerDay);

            GetUniverseTypesTypeIdOk curType = data.getTypeById(curItem.typeId);

            String escapedName = curType.getName().replace("\"", "\"\"");
            String lowestJitaPriceStr = "None";
            if (curItem.lowestJitaPrice.isPresent()) {
                lowestJitaPriceStr = String.format("%1.2f", curItem.lowestJitaPrice.get());
            }
            String jita5P_PriceStr = "None";
            if (curItem.jita5P_Price.isPresent()) {
                jita5P_PriceStr = String.format("%1.2f", curItem.jita5P_Price.get());
            }

            GetMarketsGroupsMarketGroupIdOk lastMarketGroup = marketGroupMap.get(curType.getMarketGroupId());
            String marketGroupIdStr = "" + lastMarketGroup.getName() + "(" + lastMarketGroup.getMarketGroupId() + ")";
            while (lastMarketGroup.getParentGroupId() != null) {
                lastMarketGroup = marketGroupMap.get(lastMarketGroup.getParentGroupId());
                marketGroupIdStr = lastMarketGroup.getName() + "(" + lastMarketGroup.getMarketGroupId() + ")" + ":" + marketGroupIdStr;
            }

            out.print("\"" + escapedName + "\"" + ",");
            for (String curStationName : marketQuery.stationNames) {
                out.print(curItem.getVolumeRemaining(data.getStructureIdByName(curStationName)) + ",");
            }
            out.print(curItem.soldPerDay + "," + curItem.calcDaysRemaining() + ",");
            for (String curStationName : marketQuery.stationNames) {
                String lowestPriceStr = "None";
                Double lowestPrice = curItem.getLowestLocalSellPrice(data.getStructureIdByName(curStationName));
                if (lowestPrice != null && Double.isFinite(lowestPrice)) {
                    lowestPriceStr = String.format("%1.2f", lowestPrice);
                }
                out.print(lowestPriceStr + ",");
            }

            out.print(String.format("%1.2f", curItem.averagePrice) + "," + lowestJitaPriceStr + "," + jita5P_PriceStr + ",");
            out.println(curType.getTypeId() + "," + curType.getPackagedVolume() + "," + marketGroupIdStr);

        }
        out.close();
    }


}
