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

import io.swagger.client.model.BadRequest;
import io.swagger.client.model.ErrorLimited;
import io.swagger.client.model.Forbidden;
import io.swagger.client.model.GatewayTimeout;
import io.swagger.client.model.GetCharactersCharacterIdFittings200Ok;
import io.swagger.client.model.InternalServerError;
import io.swagger.client.model.PostCharactersCharacterIdFittingsCreated;
import io.swagger.client.model.PostCharactersCharacterIdFittingsFitting;
import io.swagger.client.model.ServiceUnavailable;
import io.swagger.client.model.Unauthorized;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for FittingsApi
 */
@Ignore
public class FittingsApiTest {

    private final FittingsApi api = new FittingsApi();

    /**
     * Delete fitting
     *
     * Delete a fitting from a character  --- Alternate route: &#x60;/latest/characters/{character_id}/fittings/{fitting_id}/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/fittings/{fitting_id}/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/fittings/{fitting_id}/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteCharactersCharacterIdFittingsFittingIdTest() throws Exception {
        Integer characterId = null;
        Integer fittingId = null;
        String datasource = null;
        String token = null;
        api.deleteCharactersCharacterIdFittingsFittingId(characterId, fittingId, datasource, token);

        // TODO: test validations
    }
    /**
     * Get fittings
     *
     * Return fittings of a character  --- Alternate route: &#x60;/latest/characters/{character_id}/fittings/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/fittings/&#x60;  --- This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdFittingsTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdFittings200Ok> response = api.getCharactersCharacterIdFittings(characterId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    /**
     * Create fitting
     *
     * Save a new fitting for a character  --- Alternate route: &#x60;/latest/characters/{character_id}/fittings/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/fittings/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void postCharactersCharacterIdFittingsTest() throws Exception {
        PostCharactersCharacterIdFittingsFitting body = null;
        Integer characterId = null;
        String datasource = null;
        String token = null;
        PostCharactersCharacterIdFittingsCreated response = api.postCharactersCharacterIdFittings(body, characterId, datasource, token);

        // TODO: test validations
    }
}