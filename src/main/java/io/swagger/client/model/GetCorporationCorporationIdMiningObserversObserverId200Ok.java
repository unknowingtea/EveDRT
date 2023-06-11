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
import org.threeten.bp.LocalDate;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetCorporationCorporationIdMiningObserversObserverId200Ok {
  @SerializedName("character_id")
  private Integer characterId = null;

  @SerializedName("last_updated")
  private LocalDate lastUpdated = null;

  @SerializedName("quantity")
  private Long quantity = null;

  @SerializedName("recorded_corporation_id")
  private Integer recordedCorporationId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCorporationCorporationIdMiningObserversObserverId200Ok characterId(Integer characterId) {
    this.characterId = characterId;
    return this;
  }

   /**
   * The character that did the mining 
   * @return characterId
  **/
  @Schema(required = true, description = "The character that did the mining ")
  public Integer getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
  }

  public GetCorporationCorporationIdMiningObserversObserverId200Ok lastUpdated(LocalDate lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * last_updated string
   * @return lastUpdated
  **/
  @Schema(required = true, description = "last_updated string")
  public LocalDate getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDate lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public GetCorporationCorporationIdMiningObserversObserverId200Ok quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * quantity integer
   * @return quantity
  **/
  @Schema(required = true, description = "quantity integer")
  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public GetCorporationCorporationIdMiningObserversObserverId200Ok recordedCorporationId(Integer recordedCorporationId) {
    this.recordedCorporationId = recordedCorporationId;
    return this;
  }

   /**
   * The corporation id of the character at the time data was recorded. 
   * @return recordedCorporationId
  **/
  @Schema(required = true, description = "The corporation id of the character at the time data was recorded. ")
  public Integer getRecordedCorporationId() {
    return recordedCorporationId;
  }

  public void setRecordedCorporationId(Integer recordedCorporationId) {
    this.recordedCorporationId = recordedCorporationId;
  }

  public GetCorporationCorporationIdMiningObserversObserverId200Ok typeId(Integer typeId) {
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
    GetCorporationCorporationIdMiningObserversObserverId200Ok getCorporationCorporationIdMiningObserversObserverId200Ok = (GetCorporationCorporationIdMiningObserversObserverId200Ok) o;
    return Objects.equals(this.characterId, getCorporationCorporationIdMiningObserversObserverId200Ok.characterId) &&
        Objects.equals(this.lastUpdated, getCorporationCorporationIdMiningObserversObserverId200Ok.lastUpdated) &&
        Objects.equals(this.quantity, getCorporationCorporationIdMiningObserversObserverId200Ok.quantity) &&
        Objects.equals(this.recordedCorporationId, getCorporationCorporationIdMiningObserversObserverId200Ok.recordedCorporationId) &&
        Objects.equals(this.typeId, getCorporationCorporationIdMiningObserversObserverId200Ok.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterId, lastUpdated, quantity, recordedCorporationId, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationCorporationIdMiningObserversObserverId200Ok {\n");
    
    sb.append("    characterId: ").append(toIndentedString(characterId)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    recordedCorporationId: ").append(toIndentedString(recordedCorporationId)).append("\n");
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
