package io.github.unknowingtea.evedata.sourcing;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;
import io.swagger.client.api.MarketApi;
import io.swagger.client.model.GetMarketsRegionIdOrders200Ok;

import java.io.IOException;
import java.util.List;

public class MarketOrdersAssembler extends Assembler<List<GetMarketsRegionIdOrders200Ok>> implements ProgressResponseBody.ProgressListener, ProgressRequestBody.ProgressRequestListener {

    private MarketOrders marketOrders = new MarketOrders();

    public MarketOrdersAssembler(ApiClient apiClient) {

        super(apiClient);
        setCollector(marketOrders);
    }

    public MarketOrders getMarketOrders() {
        return marketOrders;
    }

    public void assemble(int regionId) throws ApiException, IOException {
        marketOrders.setCollectingRegion(regionId);

        MarketApi marketApi = new MarketApi(apiClient);

        Call firstCall = marketApi.getMarketsRegionIdOrdersCall("all", regionId, null, null, null, null, this, this);
        Response rsp = firstCall.execute();
        String numPagesString = rsp.header("X-Pages");
        rsp.body().close();

        System.err.println("orders pages: " + numPagesString);
        int numPages = Integer.parseInt(numPagesString);

        for(int i = 1; i <= numPages; i++) {
            addCall(marketApi.getMarketsRegionIdOrdersAsync("all", regionId, null, null, i, null, this));
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
