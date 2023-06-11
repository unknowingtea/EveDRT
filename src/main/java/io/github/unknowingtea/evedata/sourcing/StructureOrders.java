package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetMarketsStructuresStructureId200Ok;

import java.util.*;

public class StructureOrders implements Collector<List<GetMarketsStructuresStructureId200Ok>> {

    private Map<Long, GetMarketsStructuresStructureId200Ok> allOrders = new HashMap<>();
    private Map<Integer, List<GetMarketsStructuresStructureId200Ok>> ordersByTypeId = new HashMap<>();

    public Collection<GetMarketsStructuresStructureId200Ok> getAllOrders() {
        return allOrders.values();
    }

    public List<GetMarketsStructuresStructureId200Ok> getByTypeId(int id) {
        return ordersByTypeId.get(id);
    }

    @Override
    public void add(List<GetMarketsStructuresStructureId200Ok> orders) {

        for(GetMarketsStructuresStructureId200Ok curOrder : orders) {
            allOrders.put(curOrder.getOrderId(), curOrder);

            List<GetMarketsStructuresStructureId200Ok> ordersForType = ordersByTypeId.get(curOrder.getTypeId());
            if (ordersForType == null) {
                ordersForType = new ArrayList<>();
                ordersByTypeId.put(curOrder.getTypeId(), ordersForType);
            }
            ordersForType.add(curOrder);
        }
    }

    public Collection<Integer> getAllTypeIds() {
        return ordersByTypeId.keySet();
    }

}
