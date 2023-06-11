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
 * 201 created object
 */
@Schema(description = "201 created object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class PostFleetsFleetIdWingsCreated {
  @SerializedName("wing_id")
  private Long wingId = null;

  public PostFleetsFleetIdWingsCreated wingId(Long wingId) {
    this.wingId = wingId;
    return this;
  }

   /**
   * The wing_id of the newly created wing
   * @return wingId
  **/
  @Schema(required = true, description = "The wing_id of the newly created wing")
  public Long getWingId() {
    return wingId;
  }

  public void setWingId(Long wingId) {
    this.wingId = wingId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostFleetsFleetIdWingsCreated postFleetsFleetIdWingsCreated = (PostFleetsFleetIdWingsCreated) o;
    return Objects.equals(this.wingId, postFleetsFleetIdWingsCreated.wingId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wingId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostFleetsFleetIdWingsCreated {\n");
    
    sb.append("    wingId: ").append(toIndentedString(wingId)).append("\n");
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
