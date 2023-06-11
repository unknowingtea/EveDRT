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
 * position object
 */
@Schema(description = "position object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetUniverseStationsStationIdPosition {
  @SerializedName("x")
  private Double x = null;

  @SerializedName("y")
  private Double y = null;

  @SerializedName("z")
  private Double z = null;

  public GetUniverseStationsStationIdPosition x(Double x) {
    this.x = x;
    return this;
  }

   /**
   * x number
   * @return x
  **/
  @Schema(required = true, description = "x number")
  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public GetUniverseStationsStationIdPosition y(Double y) {
    this.y = y;
    return this;
  }

   /**
   * y number
   * @return y
  **/
  @Schema(required = true, description = "y number")
  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public GetUniverseStationsStationIdPosition z(Double z) {
    this.z = z;
    return this;
  }

   /**
   * z number
   * @return z
  **/
  @Schema(required = true, description = "z number")
  public Double getZ() {
    return z;
  }

  public void setZ(Double z) {
    this.z = z;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseStationsStationIdPosition getUniverseStationsStationIdPosition = (GetUniverseStationsStationIdPosition) o;
    return Objects.equals(this.x, getUniverseStationsStationIdPosition.x) &&
        Objects.equals(this.y, getUniverseStationsStationIdPosition.y) &&
        Objects.equals(this.z, getUniverseStationsStationIdPosition.z);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseStationsStationIdPosition {\n");
    
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    z: ").append(toIndentedString(z)).append("\n");
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
