package io.github.unknowingtea.evedata;

import java.util.HashSet;
import java.util.Set;

public class MarketQuery {

    public String regionName;

    public Set<String> stationNames = new HashSet<>();

    public int historyPeriodDays = 30;

    public Set<Integer> filteredMarketGroups = new HashSet<>();
    public Set<Integer> filteredItemTypes = new HashSet<>();
    public double maxDaysRemaining = 7;
    public double minSalesPerDay = 0.05;
    public double maxJitaPrice = Double.POSITIVE_INFINITY;

    public double scamPriceMultiple = 3.0;
}
