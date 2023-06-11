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
import io.swagger.client.model.GetUniversePlanetsPlanetIdPosition;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetUniversePlanetsPlanetIdOk {
  @SerializedName("name")
  private String name = null;

  @SerializedName("planet_id")
  private Integer planetId = null;

  @SerializedName("position")
  private GetUniversePlanetsPlanetIdPosition position = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetUniversePlanetsPlanetIdOk name(String name) {
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

  public GetUniversePlanetsPlanetIdOk planetId(Integer planetId) {
    this.planetId = planetId;
    return this;
  }

   /**
   * planet_id integer
   * @return planetId
  **/
  @Schema(required = true, description = "planet_id integer")
  public Integer getPlanetId() {
    return planetId;
  }

  public void setPlanetId(Integer planetId) {
    this.planetId = planetId;
  }

  public GetUniversePlanetsPlanetIdOk position(GetUniversePlanetsPlanetIdPosition position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @Schema(required = true, description = "")
  public GetUniversePlanetsPlanetIdPosition getPosition() {
    return position;
  }

  public void setPosition(GetUniversePlanetsPlanetIdPosition position) {
    this.position = position;
  }

  public GetUniversePlanetsPlanetIdOk systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system this planet is in
   * @return systemId
  **/
  @Schema(required = true, description = "The solar system this planet is in")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  public GetUniversePlanetsPlanetIdOk typeId(Integer typeId) {
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
    GetUniversePlanetsPlanetIdOk getUniversePlanetsPlanetIdOk = (GetUniversePlanetsPlanetIdOk) o;
    return Objects.equals(this.name, getUniversePlanetsPlanetIdOk.name) &&
        Objects.equals(this.planetId, getUniversePlanetsPlanetIdOk.planetId) &&
        Objects.equals(this.position, getUniversePlanetsPlanetIdOk.position) &&
        Objects.equals(this.systemId, getUniversePlanetsPlanetIdOk.systemId) &&
        Objects.equals(this.typeId, getUniversePlanetsPlanetIdOk.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, planetId, position, systemId, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniversePlanetsPlanetIdOk {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    planetId: ").append(toIndentedString(planetId)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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
