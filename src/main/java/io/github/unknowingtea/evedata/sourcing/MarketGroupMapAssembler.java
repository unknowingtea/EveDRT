package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.MarketApi;

import java.io.IOException;
import java.util.List;

public class MarketGroupMapAssembler extends Assembler {

    private MarketGroupMap marketGroupMap;

    public MarketGroupMapAssembler(MarketGroupMap marketGroupMap, ApiClient apiClient) {

        super(apiClient);
        this.marketGroupMap = marketGroupMap;
        setCollector(marketGroupMap);
    }

    public MarketGroupMap getMarketGroupMap() {
        return marketGroupMap;
    }

    public void assemble() throws ApiException, IOException {

        MarketApi marketApi = new MarketApi(apiClient);
        List<Integer> groupIds = marketApi.getMarketsGroups(null, null);
        for(int curId : groupIds) {
            if (!marketGroupMap.contains(curId)) {
                addCall(marketApi.getMarketsGroupsMarketGroupIdAsync(curId, null, null, null, null, this));
            }
        }
        waitForCallsToComplete();

    }
}
