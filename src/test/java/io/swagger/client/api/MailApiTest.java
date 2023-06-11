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
import io.swagger.client.model.DeleteCharactersCharacterIdMailLabelsLabelIdUnprocessableEntity;
import io.swagger.client.model.ErrorLimited;
import io.swagger.client.model.Forbidden;
import io.swagger.client.model.GatewayTimeout;
import io.swagger.client.model.GetCharactersCharacterIdMail200Ok;
import io.swagger.client.model.GetCharactersCharacterIdMailLabelsOk;
import io.swagger.client.model.GetCharactersCharacterIdMailLists200Ok;
import io.swagger.client.model.GetCharactersCharacterIdMailMailIdNotFound;
import io.swagger.client.model.GetCharactersCharacterIdMailMailIdOk;
import io.swagger.client.model.InternalServerError;
import io.swagger.client.model.PostCharactersCharacterIdMailError520;
import io.swagger.client.model.PostCharactersCharacterIdMailLabelsLabel;
import io.swagger.client.model.PostCharactersCharacterIdMailMail;
import io.swagger.client.model.PutCharactersCharacterIdMailMailIdContents;
import io.swagger.client.model.ServiceUnavailable;
import io.swagger.client.model.Unauthorized;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for MailApi
 */
@Ignore
public class MailApiTest {

    private final MailApi api = new MailApi();

    /**
     * Delete a mail label
     *
     * Delete a mail label  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/labels/{label_id}/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/labels/{label_id}/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/labels/{label_id}/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteCharactersCharacterIdMailLabelsLabelIdTest() throws Exception {
        Integer characterId = null;
        Integer labelId = null;
        String datasource = null;
        String token = null;
        api.deleteCharactersCharacterIdMailLabelsLabelId(characterId, labelId, datasource, token);

        // TODO: test validations
    }
    /**
     * Delete a mail
     *
     * Delete a mail  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteCharactersCharacterIdMailMailIdTest() throws Exception {
        Integer characterId = null;
        Integer mailId = null;
        String datasource = null;
        String token = null;
        api.deleteCharactersCharacterIdMailMailId(characterId, mailId, datasource, token);

        // TODO: test validations
    }
    /**
     * Return mail headers
     *
     * Return the 50 most recent mail headers belonging to the character that match the query criteria. Queries can be filtered by label, and last_mail_id can be used to paginate backwards  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/&#x60;  --- This route is cached for up to 30 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        List<Integer> labels = null;
        Integer lastMailId = null;
        String token = null;
        List<GetCharactersCharacterIdMail200Ok> response = api.getCharactersCharacterIdMail(characterId, datasource, ifNoneMatch, labels, lastMailId, token);

        // TODO: test validations
    }
    /**
     * Get mail labels and unread counts
     *
     * Return a list of the users mail labels, unread counts for each label and a total unread count.  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/labels/&#x60;  Alternate route: &#x60;/v3/characters/{character_id}/mail/labels/&#x60;  --- This route is cached for up to 30 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailLabelsTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        GetCharactersCharacterIdMailLabelsOk response = api.getCharactersCharacterIdMailLabels(characterId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    /**
     * Return mailing list subscriptions
     *
     * Return all mailing lists that the character is subscribed to  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/lists/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/lists/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/lists/&#x60;  --- This route is cached for up to 120 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailListsTest() throws Exception {
        Integer characterId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        List<GetCharactersCharacterIdMailLists200Ok> response = api.getCharactersCharacterIdMailLists(characterId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    /**
     * Return a mail
     *
     * Return the contents of an EVE mail  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60;  --- This route is cached for up to 30 seconds
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailMailIdTest() throws Exception {
        Integer characterId = null;
        Integer mailId = null;
        String datasource = null;
        String ifNoneMatch = null;
        String token = null;
        GetCharactersCharacterIdMailMailIdOk response = api.getCharactersCharacterIdMailMailId(characterId, mailId, datasource, ifNoneMatch, token);

        // TODO: test validations
    }
    /**
     * Send a new mail
     *
     * Create and send a new mail  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void postCharactersCharacterIdMailTest() throws Exception {
        PostCharactersCharacterIdMailMail body = null;
        Integer characterId = null;
        String datasource = null;
        String token = null;
        Integer response = api.postCharactersCharacterIdMail(body, characterId, datasource, token);

        // TODO: test validations
    }
    /**
     * Create a mail label
     *
     * Create a mail label  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/labels/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/labels/&#x60;  Alternate route: &#x60;/v2/characters/{character_id}/mail/labels/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void postCharactersCharacterIdMailLabelsTest() throws Exception {
        PostCharactersCharacterIdMailLabelsLabel body = null;
        Integer characterId = null;
        String datasource = null;
        String token = null;
        Integer response = api.postCharactersCharacterIdMailLabels(body, characterId, datasource, token);

        // TODO: test validations
    }
    /**
     * Update metadata about a mail
     *
     * Update metadata about a mail  --- Alternate route: &#x60;/latest/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/mail/{mail_id}/&#x60;  Alternate route: &#x60;/v1/characters/{character_id}/mail/{mail_id}/&#x60; 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void putCharactersCharacterIdMailMailIdTest() throws Exception {
        PutCharactersCharacterIdMailMailIdContents body = null;
        Integer characterId = null;
        Integer mailId = null;
        String datasource = null;
        String token = null;
        api.putCharactersCharacterIdMailMailId(body, characterId, mailId, datasource, token);

        // TODO: test validations
    }
}