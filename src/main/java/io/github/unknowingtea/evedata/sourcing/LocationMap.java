package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetUniverseStationsStationIdOk;
import io.swagger.client.model.GetUniverseStructuresStructureIdOk;

import java.util.HashMap;
import java.util.Map;

public class LocationMap implements Collector<GetUniverseStationsStationIdOk> {

    Map<Integer, GetUniverseStationsStationIdOk> stationsById = new HashMap<>();
    Map<String, GetUniverseStationsStationIdOk> stationsByName = new HashMap<>();

    Map<Long,GetUniverseStructuresStructureIdOk > structuresById = new HashMap<>();
    Map<String, Long> structureIdsByName = new HashMap<>();

    @Override
    public void add(GetUniverseStationsStationIdOk station) {
        stationsById.put(station.getStationId(), station);
        stationsByName.put(station.getName(), station);
    }

    public void add(long structureId, GetUniverseStructuresStructureIdOk structure) {
        structuresById.put(structureId, structure);
        structureIdsByName.put(structure.getName(), structureId);
    }

    public void clear() {
        stationsById.clear();
        stationsByName.clear();

        structuresById.clear();
        structureIdsByName.clear();
    }

    public GetUniverseStationsStationIdOk getStationByName(String name) {
        return stationsByName.get(name);
    }
    public GetUniverseStationsStationIdOk getStationById(int id) {
        return stationsById.get(id);
    }

    public Long getStructureIdByName(String name) {
        return structureIdsByName.get(name);
    }

    public boolean contains(long id) {
        return (stationsById.containsKey((int) id) || structuresById.containsKey(id));
    }

}
