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
import io.swagger.client.model.GetUniverseStructuresStructureIdPosition;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetUniverseStructuresStructureIdOk {
  @SerializedName("name")
  private String name = null;

  @SerializedName("owner_id")
  private Integer ownerId = null;

  @SerializedName("position")
  private GetUniverseStructuresStructureIdPosition position = null;

  @SerializedName("solar_system_id")
  private Integer solarSystemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetUniverseStructuresStructureIdOk name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The full name of the structure
   * @return name
  **/
  @Schema(required = true, description = "The full name of the structure")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetUniverseStructuresStructureIdOk ownerId(Integer ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * The ID of the corporation who owns this particular structure
   * @return ownerId
  **/
  @Schema(required = true, description = "The ID of the corporation who owns this particular structure")
  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public GetUniverseStructuresStructureIdOk position(GetUniverseStructuresStructureIdPosition position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @Schema(description = "")
  public GetUniverseStructuresStructureIdPosition getPosition() {
    return position;
  }

  public void setPosition(GetUniverseStructuresStructureIdPosition position) {
    this.position = position;
  }

  public GetUniverseStructuresStructureIdOk solarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
    return this;
  }

   /**
   * solar_system_id integer
   * @return solarSystemId
  **/
  @Schema(required = true, description = "solar_system_id integer")
  public Integer getSolarSystemId() {
    return solarSystemId;
  }

  public void setSolarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
  }

  public GetUniverseStructuresStructureIdOk typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * type_id integer
   * @return typeId
  **/
  @Schema(description = "type_id integer")
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
    GetUniverseStructuresStructureIdOk getUniverseStructuresStructureIdOk = (GetUniverseStructuresStructureIdOk) o;
    return Objects.equals(this.name, getUniverseStructuresStructureIdOk.name) &&
        Objects.equals(this.ownerId, getUniverseStructuresStructureIdOk.ownerId) &&
        Objects.equals(this.position, getUniverseStructuresStructureIdOk.position) &&
        Objects.equals(this.solarSystemId, getUniverseStructuresStructureIdOk.solarSystemId) &&
        Objects.equals(this.typeId, getUniverseStructuresStructureIdOk.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ownerId, position, solarSystemId, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseStructuresStructureIdOk {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    solarSystemId: ").append(toIndentedString(solarSystemId)).append("\n");
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
