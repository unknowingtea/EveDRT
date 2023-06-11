package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetMarketsGroupsMarketGroupIdOk;

import java.util.HashMap;
import java.util.Map;

public class MarketGroupMap implements Collector<GetMarketsGroupsMarketGroupIdOk> {

    private Map<Integer, GetMarketsGroupsMarketGroupIdOk> groupsById = new HashMap<>();

    public boolean contains(int groupId) {
        return groupsById.containsKey(groupId);
    }

    @Override
    public void add(GetMarketsGroupsMarketGroupIdOk v) {
        groupsById.put(v.getMarketGroupId(), v);
    }

    public GetMarketsGroupsMarketGroupIdOk get(int id) {
        return groupsById.get(id);
    }
}
