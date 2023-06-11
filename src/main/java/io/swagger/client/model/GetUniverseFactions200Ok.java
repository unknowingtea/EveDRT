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
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetUniverseFactions200Ok {
  @SerializedName("corporation_id")
  private Integer corporationId = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  @SerializedName("is_unique")
  private Boolean isUnique = null;

  @SerializedName("militia_corporation_id")
  private Integer militiaCorporationId = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("size_factor")
  private Float sizeFactor = null;

  @SerializedName("solar_system_id")
  private Integer solarSystemId = null;

  @SerializedName("station_count")
  private Integer stationCount = null;

  @SerializedName("station_system_count")
  private Integer stationSystemCount = null;

  public GetUniverseFactions200Ok corporationId(Integer corporationId) {
    this.corporationId = corporationId;
    return this;
  }

   /**
   * corporation_id integer
   * @return corporationId
  **/
  @Schema(description = "corporation_id integer")
  public Integer getCorporationId() {
    return corporationId;
  }

  public void setCorporationId(Integer corporationId) {
    this.corporationId = corporationId;
  }

  public GetUniverseFactions200Ok description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description string
   * @return description
  **/
  @Schema(required = true, description = "description string")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetUniverseFactions200Ok factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * faction_id integer
   * @return factionId
  **/
  @Schema(required = true, description = "faction_id integer")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }

  public GetUniverseFactions200Ok isUnique(Boolean isUnique) {
    this.isUnique = isUnique;
    return this;
  }

   /**
   * is_unique boolean
   * @return isUnique
  **/
  @Schema(required = true, description = "is_unique boolean")
  public Boolean isIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Boolean isUnique) {
    this.isUnique = isUnique;
  }

  public GetUniverseFactions200Ok militiaCorporationId(Integer militiaCorporationId) {
    this.militiaCorporationId = militiaCorporationId;
    return this;
  }

   /**
   * militia_corporation_id integer
   * @return militiaCorporationId
  **/
  @Schema(description = "militia_corporation_id integer")
  public Integer getMilitiaCorporationId() {
    return militiaCorporationId;
  }

  public void setMilitiaCorporationId(Integer militiaCorporationId) {
    this.militiaCorporationId = militiaCorporationId;
  }

  public GetUniverseFactions200Ok name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name string
   * @return name
  **/
  @Schema(required = true, description = "name string")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetUniverseFactions200Ok sizeFactor(Float sizeFactor) {
    this.sizeFactor = sizeFactor;
    return this;
  }

   /**
   * size_factor number
   * @return sizeFactor
  **/
  @Schema(required = true, description = "size_factor number")
  public Float getSizeFactor() {
    return sizeFactor;
  }

  public void setSizeFactor(Float sizeFactor) {
    this.sizeFactor = sizeFactor;
  }

  public GetUniverseFactions200Ok solarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
    return this;
  }

   /**
   * solar_system_id integer
   * @return solarSystemId
  **/
  @Schema(description = "solar_system_id integer")
  public Integer getSolarSystemId() {
    return solarSystemId;
  }

  public void setSolarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
  }

  public GetUniverseFactions200Ok stationCount(Integer stationCount) {
    this.stationCount = stationCount;
    return this;
  }

   /**
   * station_count integer
   * @return stationCount
  **/
  @Schema(required = true, description = "station_count integer")
  public Integer getStationCount() {
    return stationCount;
  }

  public void setStationCount(Integer stationCount) {
    this.stationCount = stationCount;
  }

  public GetUniverseFactions200Ok stationSystemCount(Integer stationSystemCount) {
    this.stationSystemCount = stationSystemCount;
    return this;
  }

   /**
   * station_system_count integer
   * @return stationSystemCount
  **/
  @Schema(required = true, description = "station_system_count integer")
  public Integer getStationSystemCount() {
    return stationSystemCount;
  }

  public void setStationSystemCount(Integer stationSystemCount) {
    this.stationSystemCount = stationSystemCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseFactions200Ok getUniverseFactions200Ok = (GetUniverseFactions200Ok) o;
    return Objects.equals(this.corporationId, getUniverseFactions200Ok.corporationId) &&
        Objects.equals(this.description, getUniverseFactions200Ok.description) &&
        Objects.equals(this.factionId, getUniverseFactions200Ok.factionId) &&
        Objects.equals(this.isUnique, getUniverseFactions200Ok.isUnique) &&
        Objects.equals(this.militiaCorporationId, getUniverseFactions200Ok.militiaCorporationId) &&
        Objects.equals(this.name, getUniverseFactions200Ok.name) &&
        Objects.equals(this.sizeFactor, getUniverseFactions200Ok.sizeFactor) &&
        Objects.equals(this.solarSystemId, getUniverseFactions200Ok.solarSystemId) &&
        Objects.equals(this.stationCount, getUniverseFactions200Ok.stationCount) &&
        Objects.equals(this.stationSystemCount, getUniverseFactions200Ok.stationSystemCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(corporationId, description, factionId, isUnique, militiaCorporationId, name, sizeFactor, solarSystemId, stationCount, stationSystemCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseFactions200Ok {\n");
    
    sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
    sb.append("    militiaCorporationId: ").append(toIndentedString(militiaCorporationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sizeFactor: ").append(toIndentedString(sizeFactor)).append("\n");
    sb.append("    solarSystemId: ").append(toIndentedString(solarSystemId)).append("\n");
    sb.append("    stationCount: ").append(toIndentedString(stationCount)).append("\n");
    sb.append("    stationSystemCount: ").append(toIndentedString(stationSystemCount)).append("\n");
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
