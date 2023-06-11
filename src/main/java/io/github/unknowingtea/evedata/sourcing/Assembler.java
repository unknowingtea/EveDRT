package io.github.unknowingtea.evedata.sourcing;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;

import java.util.List;
import java.util.Map;

public class Assembler <T> implements ApiCallback<T> {

    protected final ApiClient apiClient;
    private Collector<T> collector = null;

    protected Assembler(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected void setCollector(Collector<T> collector) {
        this.collector = collector;
    }

    private long numCalls = 0;

    private static void tryDelay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            // do nothing
        }
    }
    protected void addCall(Call c) {
        numCalls++;
    }

    protected void addCall(Call c, Callback callback) {
        c.enqueue(callback);
        numCalls++;
    }

    protected void waitForCallsToComplete() {
        while (numCalls > 0) {
            System.err.println("calls remaining: " + numCalls);
            tryDelay(1000);
        }
        // Workaround to Swagger/OkHttp bug that causes stack overflows
        apiClient.getHttpClient().networkInterceptors().clear();
    }

    protected void decrCalls() {
        numCalls--;
    }
    @Override
    public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
        synchronized(this) {
            numCalls--;
        }
        throw new RuntimeException(e);
    }

    @Override
    public void onSuccess(T result, int statusCode, Map<String, List<String>> responseHeaders) {
        synchronized(this) {
            if (collector != null) {
                collector.add(result);
            }
            numCalls--;
        }
    }

    @Override
    public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

    }

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

    }
}
