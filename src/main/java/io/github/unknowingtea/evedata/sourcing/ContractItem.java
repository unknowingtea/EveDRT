package io.github.unknowingtea.evedata.sourcing;

public class ContractItem {
    private final int typeId;
    private final int quantity;

    public ContractItem(int typeId, int quantity) {
        this.typeId = typeId;
        this.quantity = quantity;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getQuantity() {
        return quantity;
    }
}