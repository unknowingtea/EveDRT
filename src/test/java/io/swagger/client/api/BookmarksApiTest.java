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
import io.swagger.client.model.GetCharactersCharacterIdBookmarks200Ok;
import io.swagger.client.model.GetCharactersCharacterIdBookmarksFolders200Ok;
import io.swagger.client.model.GetCorporationsCorporationIdBookmarks200Ok;
import io.swagger.client.model.GetCorporationsCorporationIdBookmarksFolders200Ok;
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
 * API tests for BookmarksApi
 */
@Ignore
public class BookmarksApiTest {

    private final BookmarksApi api = new BookmarksApi();

    /**
     * List bookmarks
     *
     * A list of your character&#x27;s personal bookmarks  --- Alternate route: &#x60;/latest/characters/{character_id}/bookmarks/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/bookmarks/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdBookmarksTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCharactersCharacterIdBookmarks200Ok> response = api.getCharactersCharacterIdBookmarks(characterId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    /**
     * List bookmark folders
     *
     * A list of your character&#x27;s personal bookmark folders  --- Alternate route: &#x60;/latest/characters/{character_id}/bookmarks/folders/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/bookmarks/folders/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdBookmarksFoldersTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCharactersCharacterIdBookmarksFolders200Ok> response = api.getCharactersCharacterIdBookmarksFolders(characterId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    /**
     * List corporation bookmarks
     *
     * A list of your corporation&#x27;s bookmarks  --- Alternate route: &#x60;/latest/corporations/{corporation_id}/bookmarks/&#x60;  Alternate route: &#x60;/legacy/corporations/{corporation_id}/bookmarks/&#x60;  Alternate route: &#x60;/v1/corporations/{corporation_id}/bookmarks/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdBookmarksTest() throws Exception {
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCorporationsCorporationIdBookmarks200Ok> response = api.getCorporationsCorporationIdBookmarks(corporationId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
    /**
     * List corporation bookmark folders
     *
     * A list of your corporation&#x27;s bookmark folders  --- Alternate route: &#x60;/latest/corporations/{corporation_id}/bookmarks/folders/&#x60;  Alternate route: &#x60;/legacy/corporations/{corporation_id}/bookmarks/folders/&#x60;  Alternate route: &#x60;/v1/corporations/{corporation_id}/bookmarks/folders/&#x60;  --- This route is cached for up to 3600 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCorporationsCorporationIdBookmarksFoldersTest() throws Exception {
        Integer corporationId = null;
        String datasource = null;
        String ifNoneMatch = null;
        Integer page = null;
        String token = null;
        List<GetCorporationsCorporationIdBookmarksFolders200Ok> response = api.getCorporationsCorporationIdBookmarksFolders(corporationId, datasource, ifNoneMatch, page, token);

        // TODO: test validations
    }
}