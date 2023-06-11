package io.github.unknowingtea.evedata;

import java.util.HashSet;
import java.util.Set;

public class MarketQuery {

    public String regionName;

    public Set<String> stationNames = new HashSet<>();

    public int historyPeriodDays;

    public Set<Integer> filteredMarketGroups = new HashSet<>();
    public Set<Integer> filteredItemTypes = new HashSet<>();
    public double maxDaysRemaining;
    public double minSalesPerDay;
    public double maxJitaPrice;

    public double scamPriceMultiple;
}