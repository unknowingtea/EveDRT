package io.github.unknowingtea.evedata.reporting;

import io.swagger.client.model.GetUniverseTypesTypeIdOk;

import java.util.Optional;

public interface PricePredicate {

    public boolean accept(double orderSellPrice, double averageSellPrice, Optional<Double>  jita5pPrice, GetUniverseTypesTypeIdOk type);
}
