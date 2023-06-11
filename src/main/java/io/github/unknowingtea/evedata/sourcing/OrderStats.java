package io.github.unknowingtea.evedata.sourcing;

import java.util.Optional;

public class OrderStats {

    public Optional<Double> lowSellPrice = Optional.empty();
    public Optional<Double> highBuyPrice = Optional.empty();

    public long numBuyItems = 0;
    public long numSellItems = 0;
}
