package io.github.unknowingtea.evedata.sourcing;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;
import io.swagger.client.api.MarketApi;
import io.swagger.client.model.GetMarketsStructuresStructureId200Ok;

import java.io.IOException;
import java.util.List;

public class StructureOrdersAssembler extends Assembler<List<GetMarketsStructuresStructureId200Ok>> implements ProgressResponseBody.ProgressListener, ProgressRequestBody.ProgressRequestListener {

    private StructureOrders structureOrders = new StructureOrders();
    private final long structureId;
    private final String accessToken;

    public StructureOrdersAssembler(ApiClient apiClient, long structureId, String accessToken) {

        super(apiClient);
        setCollector(structureOrders);
        this.structureId = structureId;
        this.accessToken = accessToken;
    }

    public StructureOrders getStructureOrders() {
        return structureOrders;
    }

    public void assemble() throws ApiException, IOException {

        MarketApi marketApi = new MarketApi(apiClient);

        Call firstCall = marketApi.getMarketsStructuresStructureIdCall(structureId, null, null, null, accessToken, this, this);

        Response rsp = firstCall.execute();
        String numPagesString = rsp.header("X-Pages");
        rsp.body().close();

        System.err.println("orders pages: " + numPagesString);
        int numPages = Integer.parseInt(numPagesString);

        for(int i = 1; i <= numPages; i++) {
            addCall(marketApi.getMarketsStructuresStructureIdAsync(structureId, null, null, i, accessToken, this));
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
