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
import io.swagger.client.model.GetKillmailsKillmailIdKillmailHashItemsItem;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * item object
 */
@Schema(description = "item object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetKillmailsKillmailIdKillmailHashItem {
  @SerializedName("flag")
  private Integer flag = null;

  @SerializedName("item_type_id")
  private Integer itemTypeId = null;

  @SerializedName("items")
  private List<GetKillmailsKillmailIdKillmailHashItemsItem> items = null;

  @SerializedName("quantity_destroyed")
  private Long quantityDestroyed = null;

  @SerializedName("quantity_dropped")
  private Long quantityDropped = null;

  @SerializedName("singleton")
  private Integer singleton = null;

  public GetKillmailsKillmailIdKillmailHashItem flag(Integer flag) {
    this.flag = flag;
    return this;
  }

   /**
   * Flag for the location of the item 
   * @return flag
  **/
  @Schema(required = true, description = "Flag for the location of the item ")
  public Integer getFlag() {
    return flag;
  }

  public void setFlag(Integer flag) {
    this.flag = flag;
  }

  public GetKillmailsKillmailIdKillmailHashItem itemTypeId(Integer itemTypeId) {
    this.itemTypeId = itemTypeId;
    return this;
  }

   /**
   * item_type_id integer
   * @return itemTypeId
  **/
  @Schema(required = true, description = "item_type_id integer")
  public Integer getItemTypeId() {
    return itemTypeId;
  }

  public void setItemTypeId(Integer itemTypeId) {
    this.itemTypeId = itemTypeId;
  }

  public GetKillmailsKillmailIdKillmailHashItem items(List<GetKillmailsKillmailIdKillmailHashItemsItem> items) {
    this.items = items;
    return this;
  }

  public GetKillmailsKillmailIdKillmailHashItem addItemsItem(GetKillmailsKillmailIdKillmailHashItemsItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<GetKillmailsKillmailIdKillmailHashItemsItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * items array
   * @return items
  **/
  @Schema(description = "items array")
  public List<GetKillmailsKillmailIdKillmailHashItemsItem> getItems() {
    return items;
  }

  public void setItems(List<GetKillmailsKillmailIdKillmailHashItemsItem> items) {
    this.items = items;
  }

  public GetKillmailsKillmailIdKillmailHashItem quantityDestroyed(Long quantityDestroyed) {
    this.quantityDestroyed = quantityDestroyed;
    return this;
  }

   /**
   * How many of the item were destroyed if any 
   * @return quantityDestroyed
  **/
  @Schema(description = "How many of the item were destroyed if any ")
  public Long getQuantityDestroyed() {
    return quantityDestroyed;
  }

  public void setQuantityDestroyed(Long quantityDestroyed) {
    this.quantityDestroyed = quantityDestroyed;
  }

  public GetKillmailsKillmailIdKillmailHashItem quantityDropped(Long quantityDropped) {
    this.quantityDropped = quantityDropped;
    return this;
  }

   /**
   * How many of the item were dropped if any 
   * @return quantityDropped
  **/
  @Schema(description = "How many of the item were dropped if any ")
  public Long getQuantityDropped() {
    return quantityDropped;
  }

  public void setQuantityDropped(Long quantityDropped) {
    this.quantityDropped = quantityDropped;
  }

  public GetKillmailsKillmailIdKillmailHashItem singleton(Integer singleton) {
    this.singleton = singleton;
    return this;
  }

   /**
   * singleton integer
   * @return singleton
  **/
  @Schema(required = true, description = "singleton integer")
  public Integer getSingleton() {
    return singleton;
  }

  public void setSingleton(Integer singleton) {
    this.singleton = singleton;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetKillmailsKillmailIdKillmailHashItem getKillmailsKillmailIdKillmailHashItem = (GetKillmailsKillmailIdKillmailHashItem) o;
    return Objects.equals(this.flag, getKillmailsKillmailIdKillmailHashItem.flag) &&
        Objects.equals(this.itemTypeId, getKillmailsKillmailIdKillmailHashItem.itemTypeId) &&
        Objects.equals(this.items, getKillmailsKillmailIdKillmailHashItem.items) &&
        Objects.equals(this.quantityDestroyed, getKillmailsKillmailIdKillmailHashItem.quantityDestroyed) &&
        Objects.equals(this.quantityDropped, getKillmailsKillmailIdKillmailHashItem.quantityDropped) &&
        Objects.equals(this.singleton, getKillmailsKillmailIdKillmailHashItem.singleton);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flag, itemTypeId, items, quantityDestroyed, quantityDropped, singleton);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetKillmailsKillmailIdKillmailHashItem {\n");
    
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    itemTypeId: ").append(toIndentedString(itemTypeId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    quantityDestroyed: ").append(toIndentedString(quantityDestroyed)).append("\n");
    sb.append("    quantityDropped: ").append(toIndentedString(quantityDropped)).append("\n");
    sb.append("    singleton: ").append(toIndentedString(singleton)).append("\n");
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