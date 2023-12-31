package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetUniverseTypesTypeIdOk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TypeMap implements Collector<GetUniverseTypesTypeIdOk> {

    private Map<Integer, GetUniverseTypesTypeIdOk> mapById = new HashMap<>();
    private Map<String, Integer> mapByName = new HashMap<>();

    public Map<Integer, GetUniverseTypesTypeIdOk> getMapById() {
        return mapById;
    }
    public void setMapById(Map<Integer, GetUniverseTypesTypeIdOk> mapById) {
        this.mapById = mapById;
    }

    public Map<String, Integer> getMapByName() {
        return mapByName;
    }
    public void setMapByName(Map<String, Integer> mapByName) {
        this.mapByName = mapByName;
    }


    @Override
    public void add(GetUniverseTypesTypeIdOk type) {
        mapById.put(type.getTypeId(), type);
        mapByName.put(type.getName(), type.getTypeId());
    }
    
    public GetUniverseTypesTypeIdOk getById(int id) {
        return mapById.get(id);
    }
    public GetUniverseTypesTypeIdOk getByName(String name) {
        return mapById.get(mapByName.get(name));
    }

    public boolean contains(int id) {
        return mapById.containsKey(id);
    }

    public Set<Integer> allTypeIds() {
        return mapById.keySet();
    }
}
