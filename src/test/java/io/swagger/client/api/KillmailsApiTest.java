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
import io.swagger.client.model.GetCharactersCharacterIdKillmailsRecent200Ok;
import io.swagger.client.model.GetCorporationsCorporationIdKillmailsRecent200Ok;
import io.swagger.client.model.GetKillmailsKillmailIdKillmailHashOk;
import io.swagger.client.model.GetKillmailsKillmailIdKillmailHashUnprocessableEntity;
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
 * API tests for KillmailsApi
 */
@Ignore
public class KillmailsApiTest {

    private final KillmailsApi api = new KillmailsApi();

    /**
     * Get a character&#x27;s recent kills and losses
     *
     * Return a list of a character&#x27;s kills and losses going back 90 days  --- Alternate route: &#x60;/latest/characters/{character_id}/killmails/recent/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/killmails/recent/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/killmails/recent/&#x60;  --- This route is cached for up to 300 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdKillmailsRecentTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCharactersCharacterIdKillmailsRecent200Ok> response = api.getCharactersCharacterIdKillmailsRecent(characterId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    /**
     * Get a corporation&#x27;s recent kills and losses
     *
     * Get a list of a corporation&#x27;s kills and losses going back 90 days  --- Alternate route: &#x60;/latest/corporations/{corporation_id}/killmails/recent/&#x60;  Alternate route: &#x60;/legacy/corporations/{corporation_id}/killmails/recent/&#x60;  Alternate route: &#x60;/v1/corporations/{corporation_id}/killmails/recent/&#x60;  --- This route is cached for up to 300 seconds  --- Requires one of the following EVE corporation role(s): Director 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdKillmailsRecentTest() throws Exception {
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCorporationsCorporationIdKillmailsRecent200Ok> response = api.getCorporationsCorporationIdKillmailsRecent(corporationId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    /**
     * Get a single killmail
     *
     * Return a single killmail from its ID and hash  --- Alternate route: &#x60;/latest/killmails/{killmail_id}/{killmail_hash}/&#x60;  Alternate route: &#x60;/legacy/killmails/{killmail_id}/{killmail_hash}/&#x60;  Alternate route: &#x60;/v1/killmails/{killmail_id}/{killmail_hash}/&#x60;  --- This route is cached for up to 30758400 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getKillmailsKillmailIdKillmailHashTest() throws Exception {
        String killmailHash = null;
        Integer killmailId = null;
        String datasource = null;
        String ifNoneMatch = null;
        GetKillmailsKillmailIdKillmailHashOk response = api.getKillmailsKillmailIdKillmailHash(killmailHash, killmailId, datasource, ifNoneMatch);

        // TODO: test validations
    }
}
