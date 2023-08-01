package io.github.unknowingtea.evedata.sourcing;


import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;
import io.swagger.client.api.AssetsApi;
import io.swagger.client.api.ContractsApi;
import io.swagger.client.api.MarketApi;
import io.swagger.client.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerContractsAssembler extends Assembler<List<GetCharactersCharacterIdContracts200Ok>> implements ProgressResponseBody.ProgressListener, ProgressRequestBody.ProgressRequestListener {

    private PlayerContracts playerContracts = new PlayerContracts();
    private final String accessToken;

    public PlayerContractsAssembler(ApiClient apiClient, String accessToken) {

        super(apiClient);
        this.accessToken = accessToken;
        setCollector(playerContracts);
    }

    public PlayerContracts getPlayerContracts() {
        return playerContracts;
    }

    public void assemble(int characterId) throws ApiException, IOException {
        playerContracts.setCollectingCharacterId(characterId);

        ContractsApi contractsApi = new ContractsApi(apiClient);
        Call firstCall = contractsApi.getCharactersCharacterIdContractsCall(characterId, null, null, null, accessToken, this, this);
        Response rsp = firstCall.execute();
        String numPagesString = rsp.header("X-Pages");
        rsp.body().close();

        System.err.println("contracts pages: " + numPagesString);
        int numPages = Integer.parseInt(numPagesString);

        for(int i = 1; i <= numPages; i++) {
            addCall(contractsApi.getCharactersCharacterIdContractsAsync(characterId, null, null, i, accessToken, this));
        }

        waitForCallsToComplete();

        // load items for each contract
        for (GetCharactersCharacterIdContracts200Ok curContract : playerContracts.getByCharacterId(characterId)) {
            List<ContractItem> items = new ArrayList<>();
            List<GetCharactersCharacterIdContractsContractIdItems200Ok> contractItems = contractsApi.getCharactersCharacterIdContractsContractIdItems(characterId, curContract.getContractId(), null, null, accessToken);
            for (GetCharactersCharacterIdContractsContractIdItems200Ok curItem : contractItems) {
                items.add(new ContractItem(curItem.getTypeId(), curItem.getQuantity()));
            }
            playerContracts.setContractItems(characterId, curContract.getContractId(), items);
        }
    }

    @Override
    public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {

    }

    @Override
    public void update(long bytesRead, long contentLength, boolean done) {

    }
}
