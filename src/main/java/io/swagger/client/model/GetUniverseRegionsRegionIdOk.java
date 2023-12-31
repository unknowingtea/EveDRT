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
import java.util.ArrayList;
import java.util.List;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetUniverseRegionsRegionIdOk {
  @SerializedName("constellations")
  private List<Integer> constellations = new ArrayList<Integer>();

  @SerializedName("description")
  private String description = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("region_id")
  private Integer regionId = null;

  public GetUniverseRegionsRegionIdOk constellations(List<Integer> constellations) {
    this.constellations = constellations;
    return this;
  }

  public GetUniverseRegionsRegionIdOk addConstellationsItem(Integer constellationsItem) {
    this.constellations.add(constellationsItem);
    return this;
  }

   /**
   * constellations array
   * @return constellations
  **/
  @Schema(required = true, description = "constellations array")
  public List<Integer> getConstellations() {
    return constellations;
  }

  public void setConstellations(List<Integer> constellations) {
    this.constellations = constellations;
  }

  public GetUniverseRegionsRegionIdOk description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description string
   * @return description
  **/
  @Schema(description = "description string")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetUniverseRegionsRegionIdOk name(String name) {
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

  public GetUniverseRegionsRegionIdOk regionId(Integer regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * region_id integer
   * @return regionId
  **/
  @Schema(required = true, description = "region_id integer")
  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseRegionsRegionIdOk getUniverseRegionsRegionIdOk = (GetUniverseRegionsRegionIdOk) o;
    return Objects.equals(this.constellations, getUniverseRegionsRegionIdOk.constellations) &&
        Objects.equals(this.description, getUniverseRegionsRegionIdOk.description) &&
        Objects.equals(this.name, getUniverseRegionsRegionIdOk.name) &&
        Objects.equals(this.regionId, getUniverseRegionsRegionIdOk.regionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(constellations, description, name, regionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseRegionsRegionIdOk {\n");
    
    sb.append("    constellations: ").append(toIndentedString(constellations)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
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
