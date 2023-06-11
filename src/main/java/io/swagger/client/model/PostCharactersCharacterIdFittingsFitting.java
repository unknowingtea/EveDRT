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
import io.swagger.client.model.PostCharactersCharacterIdFittingsItem;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * fitting object
 */
@Schema(description = "fitting object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class PostCharactersCharacterIdFittingsFitting {
  @SerializedName("description")
  private String description = null;

  @SerializedName("items")
  private List<PostCharactersCharacterIdFittingsItem> items = new ArrayList<PostCharactersCharacterIdFittingsItem>();

  @SerializedName("name")
  private String name = null;

  @SerializedName("ship_type_id")
  private Integer shipTypeId = null;

  public PostCharactersCharacterIdFittingsFitting description(String description) {
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

  public PostCharactersCharacterIdFittingsFitting items(List<PostCharactersCharacterIdFittingsItem> items) {
    this.items = items;
    return this;
  }

  public PostCharactersCharacterIdFittingsFitting addItemsItem(PostCharactersCharacterIdFittingsItem itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * items array
   * @return items
  **/
  @Schema(required = true, description = "items array")
  public List<PostCharactersCharacterIdFittingsItem> getItems() {
    return items;
  }

  public void setItems(List<PostCharactersCharacterIdFittingsItem> items) {
    this.items = items;
  }

  public PostCharactersCharacterIdFittingsFitting name(String name) {
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

  public PostCharactersCharacterIdFittingsFitting shipTypeId(Integer shipTypeId) {
    this.shipTypeId = shipTypeId;
    return this;
  }

   /**
   * ship_type_id integer
   * @return shipTypeId
  **/
  @Schema(required = true, description = "ship_type_id integer")
  public Integer getShipTypeId() {
    return shipTypeId;
  }

  public void setShipTypeId(Integer shipTypeId) {
    this.shipTypeId = shipTypeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostCharactersCharacterIdFittingsFitting postCharactersCharacterIdFittingsFitting = (PostCharactersCharacterIdFittingsFitting) o;
    return Objects.equals(this.description, postCharactersCharacterIdFittingsFitting.description) &&
        Objects.equals(this.items, postCharactersCharacterIdFittingsFitting.items) &&
        Objects.equals(this.name, postCharactersCharacterIdFittingsFitting.name) &&
        Objects.equals(this.shipTypeId, postCharactersCharacterIdFittingsFitting.shipTypeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, items, name, shipTypeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostCharactersCharacterIdFittingsFitting {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shipTypeId: ").append(toIndentedString(shipTypeId)).append("\n");
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
