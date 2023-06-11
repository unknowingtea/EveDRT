package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;
import io.swagger.client.model.GetUniverseStructuresStructureIdOk;

import java.io.IOException;
import java.util.Collection;

public class LocationMapStructuresAssembler {

    private UniverseApi uniApi;
    private LocationMap locationMap;

    private String token;

    public LocationMapStructuresAssembler(LocationMap locationMap, ApiClient apiClient, String token) {

        this.uniApi = new UniverseApi(apiClient);
        this.locationMap = locationMap;
        this.token = token;
    }

    public LocationMap getLocationMap() {
        return locationMap;
    }

    public void assemble(Collection<Long> ids) throws ApiException, IOException {


        for(long curId : ids) {
            if (!locationMap.contains(curId)) {
                try {
                    GetUniverseStructuresStructureIdOk ok = uniApi.getUniverseStructuresStructureId(curId, null, null, token);
                    locationMap.add(curId, ok);
                } catch (ApiException ex) {
                    // expected: unauthorized
                    ex.printStackTrace();
                }
            }
        }


    }

}
