/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.12
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.BadRequest;
import io.swagger.client.model.ErrorLimited;
import io.swagger.client.model.Forbidden;
import io.swagger.client.model.GatewayTimeout;
import io.swagger.client.model.GetCharactersCharacterIdSearchOk;
import io.swagger.client.model.InternalServerError;
import io.swagger.client.model.ServiceUnavailable;
import io.swagger.client.model.Unauthorized;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchApi {
    private ApiClient apiClient;

    public SearchApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getCharactersCharacterIdSearch
     * @param categories Type of entities to search for (required)
     * @param characterId An EVE character ID (required)
     * @param search The string to search on (required)
     * @param acceptLanguage Language to use in the response (optional, default to en)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param language Language to use in the response, takes precedence over Accept-Language (optional, default to en)
     * @param strict Whether the search should be a strict match (optional, default to false)
     * @param token Access token to use if unable to set a header (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdSearchCall(List<String> categories, Integer characterId, String search, String acceptLanguage, String datasource, String ifNoneMatch, String language, Boolean strict, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/characters/{character_id}/search/"
            .replaceAll("\\{" + "character_id" + "\\}", apiClient.escapeString(characterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (categories != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "categories", categories));
        if (datasource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("datasource", datasource));
        if (language != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("language", language));
        if (search != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search", search));
        if (strict != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("strict", strict));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (acceptLanguage != null)
        localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "evesso" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCharactersCharacterIdSearchValidateBeforeCall(List<String> categories, Integer characterId, String search, String acceptLanguage, String datasource, String ifNoneMatch, String language, Boolean strict, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'categories' is set
        if (categories == null) {
            throw new ApiException("Missing the required parameter 'categories' when calling getCharactersCharacterIdSearch(Async)");
        }
        // verify the required parameter 'characterId' is set
        if (characterId == null) {
            throw new ApiException("Missing the required parameter 'characterId' when calling getCharactersCharacterIdSearch(Async)");
        }
        // verify the required parameter 'search' is set
        if (search == null) {
            throw new ApiException("Missing the required parameter 'search' when calling getCharactersCharacterIdSearch(Async)");
        }
        
        com.squareup.okhttp.Call call = getCharactersCharacterIdSearchCall(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Search on a string
     * Search for entities that match a given sub-string.  --- Alternate route: &#x60;/latest/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/v3/characters/{character_id}/search/&#x60;  --- This route is cached for up to 3600 seconds
     * @param categories Type of entities to search for (required)
     * @param characterId An EVE character ID (required)
     * @param search The string to search on (required)
     * @param acceptLanguage Language to use in the response (optional, default to en)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param language Language to use in the response, takes precedence over Accept-Language (optional, default to en)
     * @param strict Whether the search should be a strict match (optional, default to false)
     * @param token Access token to use if unable to set a header (optional)
     * @return GetCharactersCharacterIdSearchOk
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetCharactersCharacterIdSearchOk getCharactersCharacterIdSearch(List<String> categories, Integer characterId, String search, String acceptLanguage, String datasource, String ifNoneMatch, String language, Boolean strict, String token) throws ApiException {
        ApiResponse<GetCharactersCharacterIdSearchOk> resp = getCharactersCharacterIdSearchWithHttpInfo(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token);
        return resp.getData();
    }

    /**
     * Search on a string
     * Search for entities that match a given sub-string.  --- Alternate route: &#x60;/latest/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/v3/characters/{character_id}/search/&#x60;  --- This route is cached for up to 3600 seconds
     * @param categories Type of entities to search for (required)
     * @param characterId An EVE character ID (required)
     * @param search The string to search on (required)
     * @param acceptLanguage Language to use in the response (optional, default to en)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param language Language to use in the response, takes precedence over Accept-Language (optional, default to en)
     * @param strict Whether the search should be a strict match (optional, default to false)
     * @param token Access token to use if unable to set a header (optional)
     * @return ApiResponse&lt;GetCharactersCharacterIdSearchOk&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetCharactersCharacterIdSearchOk> getCharactersCharacterIdSearchWithHttpInfo(List<String> categories, Integer characterId, String search, String acceptLanguage, String datasource, String ifNoneMatch, String language, Boolean strict, String token) throws ApiException {
        com.squareup.okhttp.Call call = getCharactersCharacterIdSearchValidateBeforeCall(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token, null, null);
        Type localVarReturnType = new TypeToken<GetCharactersCharacterIdSearchOk>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search on a string (asynchronously)
     * Search for entities that match a given sub-string.  --- Alternate route: &#x60;/latest/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/search/&#x60;  Alternate route: &#x60;/v3/characters/{character_id}/search/&#x60;  --- This route is cached for up to 3600 seconds
     * @param categories Type of entities to search for (required)
     * @param characterId An EVE character ID (required)
     * @param search The string to search on (required)
     * @param acceptLanguage Language to use in the response (optional, default to en)
     * @param datasource The server name you would like data from (optional, default to tranquility)
     * @param ifNoneMatch ETag from a previous request. A 304 will be returned if this matches the current ETag (optional)
     * @param language Language to use in the response, takes precedence over Accept-Language (optional, default to en)
     * @param strict Whether the search should be a strict match (optional, default to false)
     * @param token Access token to use if unable to set a header (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCharactersCharacterIdSearchAsync(List<String> categories, Integer characterId, String search, String acceptLanguage, String datasource, String ifNoneMatch, String language, Boolean strict, String token, final ApiCallback<GetCharactersCharacterIdSearchOk> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCharactersCharacterIdSearchValidateBeforeCall(categories, characterId, search, acceptLanguage, datasource, ifNoneMatch, language, strict, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetCharactersCharacterIdSearchOk>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
