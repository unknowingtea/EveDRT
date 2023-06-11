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
 * dogma_attribute object
 */
@Schema(description = "dogma_attribute object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute {
  @SerializedName("attribute_id")
  private Integer attributeId = null;

  @SerializedName("value")
  private Float value = null;

  public GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute attributeId(Integer attributeId) {
    this.attributeId = attributeId;
    return this;
  }

   /**
   * attribute_id integer
   * @return attributeId
  **/
  @Schema(required = true, description = "attribute_id integer")
  public Integer getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(Integer attributeId) {
    this.attributeId = attributeId;
  }

  public GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute value(Float value) {
    this.value = value;
    return this;
  }

   /**
   * value number
   * @return value
  **/
  @Schema(required = true, description = "value number")
  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute getDogmaDynamicItemsTypeIdItemIdDogmaAttribute = (GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute) o;
    return Objects.equals(this.attributeId, getDogmaDynamicItemsTypeIdItemIdDogmaAttribute.attributeId) &&
        Objects.equals(this.value, getDogmaDynamicItemsTypeIdItemIdDogmaAttribute.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeId, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDogmaDynamicItemsTypeIdItemIdDogmaAttribute {\n");
    
    sb.append("    attributeId: ").append(toIndentedString(attributeId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
