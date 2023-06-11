package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;
import io.swagger.client.model.GetUniverseStationsStationIdOk;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class LocationMapStationsAssembler extends Assembler<GetUniverseStationsStationIdOk> {

    private UniverseApi uniApi;
    private LocationMap locationMap;

    public LocationMapStationsAssembler(LocationMap locationMap, ApiClient apiClient) {

        super(apiClient);
        this.uniApi = new UniverseApi(apiClient);
        this.locationMap = locationMap;
        setCollector(locationMap);
    }

    public LocationMap getLocationMap() {
        return locationMap;
    }

    public void assemble(Collection<Long> ids) throws ApiException, IOException {


        for(long curId : ids) {
            if (!locationMap.contains(curId)) {
                addCall(uniApi.getUniverseStationsStationIdAsync((int) curId, null, null, this));
             }
        }

        waitForCallsToComplete();

    }

    @Override
    public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
        synchronized(this) {
            // not a station
            decrCalls();
        }
    }
}
