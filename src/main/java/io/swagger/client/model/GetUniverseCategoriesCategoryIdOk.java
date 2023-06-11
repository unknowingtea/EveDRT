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
public class GetUniverseCategoriesCategoryIdOk {
  @SerializedName("category_id")
  private Integer categoryId = null;

  @SerializedName("groups")
  private List<Integer> groups = new ArrayList<Integer>();

  @SerializedName("name")
  private String name = null;

  @SerializedName("published")
  private Boolean published = null;

  public GetUniverseCategoriesCategoryIdOk categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

   /**
   * category_id integer
   * @return categoryId
  **/
  @Schema(required = true, description = "category_id integer")
  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public GetUniverseCategoriesCategoryIdOk groups(List<Integer> groups) {
    this.groups = groups;
    return this;
  }

  public GetUniverseCategoriesCategoryIdOk addGroupsItem(Integer groupsItem) {
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * groups array
   * @return groups
  **/
  @Schema(required = true, description = "groups array")
  public List<Integer> getGroups() {
    return groups;
  }

  public void setGroups(List<Integer> groups) {
    this.groups = groups;
  }

  public GetUniverseCategoriesCategoryIdOk name(String name) {
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

  public GetUniverseCategoriesCategoryIdOk published(Boolean published) {
    this.published = published;
    return this;
  }

   /**
   * published boolean
   * @return published
  **/
  @Schema(required = true, description = "published boolean")
  public Boolean isPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseCategoriesCategoryIdOk getUniverseCategoriesCategoryIdOk = (GetUniverseCategoriesCategoryIdOk) o;
    return Objects.equals(this.categoryId, getUniverseCategoriesCategoryIdOk.categoryId) &&
        Objects.equals(this.groups, getUniverseCategoriesCategoryIdOk.groups) &&
        Objects.equals(this.name, getUniverseCategoriesCategoryIdOk.name) &&
        Objects.equals(this.published, getUniverseCategoriesCategoryIdOk.published);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, groups, name, published);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseCategoriesCategoryIdOk {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
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
