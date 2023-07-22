package io.github.unknowingtea.evedata.sourcing;

import io.swagger.client.model.GetCharactersCharacterIdAssets200Ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerAssets implements Collector<List<GetCharactersCharacterIdAssets200Ok>> {

    private Map<Integer, List<GetCharactersCharacterIdAssets200Ok>> assetsByCharacter = new HashMap<>();

    private Integer collectingCharId = null;

    public List<GetCharactersCharacterIdAssets200Ok> getByCharacterId(int charId) {
        return assetsByCharacter.get(charId);
    }
    @Override
    public void add(List<GetCharactersCharacterIdAssets200Ok> assets) {
        List<GetCharactersCharacterIdAssets200Ok> destList = assetsByCharacter.get(collectingCharId);
        if (destList == null) {
            destList = new ArrayList<>();
            assetsByCharacter.put(collectingCharId, destList);
        }

        for (GetCharactersCharacterIdAssets200Ok curAsset : assets) {
            destList.add(curAsset);
        }
    }

    public void setCollectingCharacterId(int charId) {
        this.collectingCharId = charId;
    }
}
