package io.github.unknowingtea.evedata.sourcing;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;
import io.swagger.client.api.AssetsApi;
import io.swagger.client.api.MarketApi;
import io.swagger.client.model.GetCharactersCharacterIdAssets200Ok;
import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;

import java.io.IOException;
import java.util.List;

public class PlayerAssetsAssembler extends Assembler<List<GetCharactersCharacterIdAssets200Ok>> implements ProgressResponseBody.ProgressListener, ProgressRequestBody.ProgressRequestListener {

    private PlayerAssets playerAssets = new PlayerAssets();
    private final String accessToken;

    public PlayerAssetsAssembler(ApiClient apiClient, String accessToken) {

        super(apiClient);
        this.accessToken = accessToken;
        setCollector(playerAssets);
    }

    public PlayerAssets getPlayerAssets() {
        return playerAssets;
    }

    public void assemble(int characterId) throws ApiException, IOException {
        playerAssets.setCollectingCharacterId(characterId);

        AssetsApi assetsApi = new AssetsApi(apiClient);
        Call firstCall = assetsApi.getCharactersCharacterIdAssetsCall(characterId, null, null, null, accessToken, this, this);
        Response rsp = firstCall.execute();
        String numPagesString = rsp.header("X-Pages");
        rsp.body().close();

        System.err.println("assets pages: " + numPagesString);
        int numPages = Integer.parseInt(numPagesString);

        for(int i = 1; i <= numPages; i++) {
            addCall(assetsApi.getCharactersCharacterIdAssetsAsync(characterId, null, null, i, accessToken, this));
        }

        waitForCallsToComplete();

    }

    @Override
    public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {

    }

    @Override
    public void update(long bytesRead, long contentLength, boolean done) {

    }
}
