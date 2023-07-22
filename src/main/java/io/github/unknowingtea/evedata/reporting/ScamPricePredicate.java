package io.github.unknowingtea.evedata.reporting;

import io.swagger.client.model.GetUniverseTypesTypeIdOk;

import java.util.Optional;

public class ScamPricePredicate implements PricePredicate {
    private double priceMultiple;

    public ScamPricePredicate(double priceMultiple) {
        this.priceMultiple = priceMultiple;
    }
    @Override
    public boolean accept(double orderSellPrice, double averageSellPrice, Optional<Double> jita5pPriceOpt, GetUniverseTypesTypeIdOk type) {
        double jita5pPrice = jita5pPriceOpt.orElse(new Double(0));
        return orderSellPrice < priceMultiple * Math.max(averageSellPrice, jita5pPrice);
    }
}
