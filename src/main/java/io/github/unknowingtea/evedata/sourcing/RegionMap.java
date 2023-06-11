package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetUniverseRegionsRegionIdOk;

import java.util.HashMap;
import java.util.Map;

public class RegionMap implements Collector<GetUniverseRegionsRegionIdOk> {

    private Map<Integer, GetUniverseRegionsRegionIdOk> regionsById = new HashMap<>();
    private Map<String, GetUniverseRegionsRegionIdOk> regionsByName = new HashMap<>();

    @Override
    public void add(GetUniverseRegionsRegionIdOk region) {
        regionsById.put(region.getRegionId(), region);
        regionsByName.put(region.getName(), region);
    }

    public void clear() {
        regionsById.clear();
        regionsByName.clear();
    }

    public GetUniverseRegionsRegionIdOk getByName(String name) {
        return regionsByName.get(name);
    }
}
