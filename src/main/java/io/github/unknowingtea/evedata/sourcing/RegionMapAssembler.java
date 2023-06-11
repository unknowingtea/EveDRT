package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;

import java.io.IOException;
import java.util.List;

public class RegionMapAssembler extends Assembler {

    private RegionMap regionMap = new RegionMap();

    public RegionMapAssembler(ApiClient apiClient) {
        super(apiClient);
        setCollector(regionMap);
    }

    public RegionMap getRegionMap() {
        return regionMap;
    }

    public void assemble() throws ApiException, IOException {
        regionMap.clear();

        UniverseApi uniApi = new UniverseApi(apiClient);
        List<Integer> regionIds = uniApi.getUniverseRegions(null, null);
        System.out.println("num regions: " + regionIds.size());

        for(int curId : regionIds) {
            addCall(uniApi.getUniverseRegionsRegionIdAsync(curId, null, null, null, null, this));
        }

        waitForCallsToComplete();

    }
}
