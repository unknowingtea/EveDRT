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
import io.swagger.client.model.GetCharactersCharacterIdClonesOk;
import io.swagger.client.model.InternalServerError;
import io.swagger.client.model.ServiceUnavailable;
import io.swagger.client.model.Unauthorized;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for ClonesApi
 */
@Ignore
public class ClonesApiTest {

    private final ClonesApi api = new ClonesApi();

    /**
     * Get clones
     *
     * A list of the character&#x27;s clones  --- Alternate route: &#x60;/latest/characters/{character_id}/clones/&#x60;  Alternate route: &#x60;/v3/characters/{character_id}/clones/&#x60;  Alternate route: &#x60;/v4/characters/{character_id}/clones/&#x60;  --- This route is cached for up to 120 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdClonesTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        GetCharactersCharacterIdClonesOk response = api.getCharactersCharacterIdClones(characterId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    /**
     * Get active implants
     *
     * Return implants on the active clone of a character  --- Alternate route: &#x60;/latest/characters/{character_id}/implants/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/implants/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/implants/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/implants/&#x60;  --- This route is cached for up to 120 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdImplantsTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<Integer> response = api.getCharactersCharacterIdImplants(characterId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
}
