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
 * content object
 */
@Schema(description = "content object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetCharactersCharacterIdPlanetsPlanetIdContent {
  @SerializedName("amount")
  private Long amount = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCharactersCharacterIdPlanetsPlanetIdContent amount(Long amount) {
    this.amount = amount;
    return this;
  }

   /**
   * amount integer
   * @return amount
  **/
  @Schema(required = true, description = "amount integer")
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdContent typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * type_id integer
   * @return typeId
  **/
  @Schema(required = true, description = "type_id integer")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdPlanetsPlanetIdContent getCharactersCharacterIdPlanetsPlanetIdContent = (GetCharactersCharacterIdPlanetsPlanetIdContent) o;
    return Objects.equals(this.amount, getCharactersCharacterIdPlanetsPlanetIdContent.amount) &&
        Objects.equals(this.typeId, getCharactersCharacterIdPlanetsPlanetIdContent.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdPlanetsPlanetIdContent {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
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
