package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UniverseApi;

import java.io.IOException;
import java.util.Collection;

public class TypeMapAssembler extends Assembler {

    private TypeMap typeMap;

    public TypeMapAssembler(TypeMap typeMap, ApiClient apiClient) {

        super(apiClient);
        this.typeMap = typeMap;
        setCollector(typeMap);
    }

    public TypeMap getTypeMap() {
        return typeMap;
    }

    public void assemble(Collection<Integer> typeIds) throws ApiException, IOException {

        UniverseApi universeApi = new UniverseApi(apiClient);
        System.err.println("types: " + typeIds.size());
        int newTypes = 0;
        for(int curId : typeIds) {
            if (!typeMap.contains(curId)) {
                newTypes++;
                addCall(universeApi.getUniverseTypesTypeIdAsync(curId, null, null, null, null, this));
            }
        }
        System.err.println("Sent " + newTypes + " new type requests");
        waitForCallsToComplete();

    }
}
