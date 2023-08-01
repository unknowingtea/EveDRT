package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetCharactersCharacterIdAssets200Ok;
import io.swagger.client.model.GetCharactersCharacterIdContracts200Ok;
import io.swagger.client.model.GetCharactersCharacterIdContractsContractIdItems200Ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerContracts implements Collector<List<GetCharactersCharacterIdContracts200Ok>> {

    private Map<Integer, List<GetCharactersCharacterIdContracts200Ok>> contractsByCharacter = new HashMap<>();
    private Map<Integer, Map<Integer, List<ContractItem>>> contractItems = new HashMap<>();

    private Integer collectingCharId = null;

    public List<GetCharactersCharacterIdContracts200Ok> getByCharacterId(int charId) {
        return contractsByCharacter.get(charId);
    }

    public void setContractItems(int characterId, int contractId, List<ContractItem> items) {
        Map<Integer, List<ContractItem>> charItemsMap = contractItems.get(characterId);
        if (charItemsMap == null) {
            charItemsMap = new HashMap<>();
            contractItems.put(characterId, charItemsMap);
        }

        charItemsMap.put(contractId, items);
    }

    public List<ContractItem> getContractItems(int charId, int contractId) {
        Map<Integer, List<ContractItem>> charItemsMap = contractItems.get(charId);
        if (charItemsMap == null) {
            return null;
        } else {
            return charItemsMap.get(contractId);
        }
    }
    @Override
    public void add(List<GetCharactersCharacterIdContracts200Ok> assets) {
        List<GetCharactersCharacterIdContracts200Ok> destList = contractsByCharacter.get(collectingCharId);
        if (destList == null) {
            destList = new ArrayList<>();
            contractsByCharacter.put(collectingCharId, destList);
        }

        for (GetCharactersCharacterIdContracts200Ok curAsset : assets) {
            destList.add(curAsset);
        }
    }

    public void setCollectingCharacterId(int charId) {
        this.collectingCharId = charId;
    }
}
