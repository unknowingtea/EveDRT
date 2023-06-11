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
public class GetCorporationsCorporationIdBookmarksFolders200Ok {
  @SerializedName("creator_id")
  private Integer creatorId = null;

  @SerializedName("folder_id")
  private Integer folderId = null;

  @SerializedName("name")
  private String name = null;

  public GetCorporationsCorporationIdBookmarksFolders200Ok creatorId(Integer creatorId) {
    this.creatorId = creatorId;
    return this;
  }

   /**
   * creator_id integer
   * @return creatorId
  **/
  @Schema(description = "creator_id integer")
  public Integer getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Integer creatorId) {
    this.creatorId = creatorId;
  }

  public GetCorporationsCorporationIdBookmarksFolders200Ok folderId(Integer folderId) {
    this.folderId = folderId;
    return this;
  }

   /**
   * folder_id integer
   * @return folderId
  **/
  @Schema(required = true, description = "folder_id integer")
  public Integer getFolderId() {
    return folderId;
  }

  public void setFolderId(Integer folderId) {
    this.folderId = folderId;
  }

  public GetCorporationsCorporationIdBookmarksFolders200Ok name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdBookmarksFolders200Ok getCorporationsCorporationIdBookmarksFolders200Ok = (GetCorporationsCorporationIdBookmarksFolders200Ok) o;
    return Objects.equals(this.creatorId, getCorporationsCorporationIdBookmarksFolders200Ok.creatorId) &&
        Objects.equals(this.folderId, getCorporationsCorporationIdBookmarksFolders200Ok.folderId) &&
        Objects.equals(this.name, getCorporationsCorporationIdBookmarksFolders200Ok.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creatorId, folderId, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdBookmarksFolders200Ok {\n");
    
    sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
