package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetMarketsRegionIdHistory200Ok;

import java.util.ArrayList;
import java.util.List;

public class SavedMarketHistory {

    public static class SavedMarketHistoryDay {
        public int year;
        public int month;
        public int dayOfMonth;
        public long volume;
        public long orderCount;
        public double highest;
        public double lowest;
        public double average;

        public SavedMarketHistoryDay(GetMarketsRegionIdHistory200Ok history) {
            year = history.getDate().getYear();
            month = history.getDate().getMonthValue();
            dayOfMonth = history.getDate().getDayOfMonth();

            volume = history.getVolume();
            orderCount = history.getOrderCount();
            highest = history.getHighest();
            lowest = history.getLowest();
            average = history.getAverage();
        }

        public SavedMarketHistoryDay() {

        }
    }

    public int year;
    public int month;
    public int dayOfMonth;
    public List<SavedMarketHistoryDay> days = new ArrayList<>();

    public void add(SavedMarketHistoryDay day) {
        days.add(day);
    }

}
