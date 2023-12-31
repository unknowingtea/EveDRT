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

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * response object
 */
@Schema(description = "response object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class PutCharactersCharacterIdCalendarEventIdResponse {
  /**
   * response string
   */
  @JsonAdapter(ResponseEnum.Adapter.class)
  public enum ResponseEnum {
    ACCEPTED("accepted"),
    DECLINED("declined"),
    TENTATIVE("tentative");

    private String value;

    ResponseEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ResponseEnum fromValue(String input) {
      for (ResponseEnum b : ResponseEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ResponseEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ResponseEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public ResponseEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return ResponseEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("response")
  private ResponseEnum response = null;

  public PutCharactersCharacterIdCalendarEventIdResponse response(ResponseEnum response) {
    this.response = response;
    return this;
  }

   /**
   * response string
   * @return response
  **/
  @Schema(required = true, description = "response string")
  public ResponseEnum getResponse() {
    return response;
  }

  public void setResponse(ResponseEnum response) {
    this.response = response;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutCharactersCharacterIdCalendarEventIdResponse putCharactersCharacterIdCalendarEventIdResponse = (PutCharactersCharacterIdCalendarEventIdResponse) o;
    return Objects.equals(this.response, putCharactersCharacterIdCalendarEventIdResponse.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutCharactersCharacterIdCalendarEventIdResponse {\n");
    
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
