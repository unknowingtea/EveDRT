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
import org.threeten.bp.OffsetDateTime;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetMarketsRegionIdOrders200Ok {
  @SerializedName("duration")
  private Integer duration = null;

  @SerializedName("is_buy_order")
  private Boolean isBuyOrder = null;

  @SerializedName("issued")
  private OffsetDateTime issued = null;

  @SerializedName("location_id")
  private Long locationId = null;

  @SerializedName("min_volume")
  private Integer minVolume = null;

  @SerializedName("order_id")
  private Long orderId = null;

  @SerializedName("price")
  private Double price = null;

  /**
   * range string
   */
  @JsonAdapter(RangeEnum.Adapter.class)
  public enum RangeEnum {
    STATION("station"),
    REGION("region"),
    SOLARSYSTEM("solarsystem"),
    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _10("10"),
    _20("20"),
    _30("30"),
    _40("40");

    private String value;

    RangeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static RangeEnum fromValue(String input) {
      for (RangeEnum b : RangeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<RangeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RangeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public RangeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return RangeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("range")
  private RangeEnum range = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  @SerializedName("volume_remain")
  private Integer volumeRemain = null;

  @SerializedName("volume_total")
  private Integer volumeTotal = null;

  public GetMarketsRegionIdOrders200Ok duration(Integer duration) {
    this.duration = duration;
    return this;
  }

   /**
   * duration integer
   * @return duration
  **/
  @Schema(required = true, description = "duration integer")
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public GetMarketsRegionIdOrders200Ok isBuyOrder(Boolean isBuyOrder) {
    this.isBuyOrder = isBuyOrder;
    return this;
  }

   /**
   * is_buy_order boolean
   * @return isBuyOrder
  **/
  @Schema(required = true, description = "is_buy_order boolean")
  public Boolean isIsBuyOrder() {
    return isBuyOrder;
  }

  public void setIsBuyOrder(Boolean isBuyOrder) {
    this.isBuyOrder = isBuyOrder;
  }

  public GetMarketsRegionIdOrders200Ok issued(OffsetDateTime issued) {
    this.issued = issued;
    return this;
  }

   /**
   * issued string
   * @return issued
  **/
  @Schema(required = true, description = "issued string")
  public OffsetDateTime getIssued() {
    return issued;
  }

  public void setIssued(OffsetDateTime issued) {
    this.issued = issued;
  }

  public GetMarketsRegionIdOrders200Ok locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * location_id integer
   * @return locationId
  **/
  @Schema(required = true, description = "location_id integer")
  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public GetMarketsRegionIdOrders200Ok minVolume(Integer minVolume) {
    this.minVolume = minVolume;
    return this;
  }

   /**
   * min_volume integer
   * @return minVolume
  **/
  @Schema(required = true, description = "min_volume integer")
  public Integer getMinVolume() {
    return minVolume;
  }

  public void setMinVolume(Integer minVolume) {
    this.minVolume = minVolume;
  }

  public GetMarketsRegionIdOrders200Ok orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * order_id integer
   * @return orderId
  **/
  @Schema(required = true, description = "order_id integer")
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public GetMarketsRegionIdOrders200Ok price(Double price) {
    this.price = price;
    return this;
  }

   /**
   * price number
   * @return price
  **/
  @Schema(required = true, description = "price number")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public GetMarketsRegionIdOrders200Ok range(RangeEnum range) {
    this.range = range;
    return this;
  }

   /**
   * range string
   * @return range
  **/
  @Schema(required = true, description = "range string")
  public RangeEnum getRange() {
    return range;
  }

  public void setRange(RangeEnum range) {
    this.range = range;
  }

  public GetMarketsRegionIdOrders200Ok systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system this order was placed
   * @return systemId
  **/
  @Schema(required = true, description = "The solar system this order was placed")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  public GetMarketsRegionIdOrders200Ok typeId(Integer typeId) {
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

  public GetMarketsRegionIdOrders200Ok volumeRemain(Integer volumeRemain) {
    this.volumeRemain = volumeRemain;
    return this;
  }

   /**
   * volume_remain integer
   * @return volumeRemain
  **/
  @Schema(required = true, description = "volume_remain integer")
  public Integer getVolumeRemain() {
    return volumeRemain;
  }

  public void setVolumeRemain(Integer volumeRemain) {
    this.volumeRemain = volumeRemain;
  }

  public GetMarketsRegionIdOrders200Ok volumeTotal(Integer volumeTotal) {
    this.volumeTotal = volumeTotal;
    return this;
  }

   /**
   * volume_total integer
   * @return volumeTotal
  **/
  @Schema(required = true, description = "volume_total integer")
  public Integer getVolumeTotal() {
    return volumeTotal;
  }

  public void setVolumeTotal(Integer volumeTotal) {
    this.volumeTotal = volumeTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetMarketsRegionIdOrders200Ok getMarketsRegionIdOrders200Ok = (GetMarketsRegionIdOrders200Ok) o;
    return Objects.equals(this.duration, getMarketsRegionIdOrders200Ok.duration) &&
        Objects.equals(this.isBuyOrder, getMarketsRegionIdOrders200Ok.isBuyOrder) &&
        Objects.equals(this.issued, getMarketsRegionIdOrders200Ok.issued) &&
        Objects.equals(this.locationId, getMarketsRegionIdOrders200Ok.locationId) &&
        Objects.equals(this.minVolume, getMarketsRegionIdOrders200Ok.minVolume) &&
        Objects.equals(this.orderId, getMarketsRegionIdOrders200Ok.orderId) &&
        Objects.equals(this.price, getMarketsRegionIdOrders200Ok.price) &&
        Objects.equals(this.range, getMarketsRegionIdOrders200Ok.range) &&
        Objects.equals(this.systemId, getMarketsRegionIdOrders200Ok.systemId) &&
        Objects.equals(this.typeId, getMarketsRegionIdOrders200Ok.typeId) &&
        Objects.equals(this.volumeRemain, getMarketsRegionIdOrders200Ok.volumeRemain) &&
        Objects.equals(this.volumeTotal, getMarketsRegionIdOrders200Ok.volumeTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, isBuyOrder, issued, locationId, minVolume, orderId, price, range, systemId, typeId, volumeRemain, volumeTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMarketsRegionIdOrders200Ok {\n");
    
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    isBuyOrder: ").append(toIndentedString(isBuyOrder)).append("\n");
    sb.append("    issued: ").append(toIndentedString(issued)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    minVolume: ").append(toIndentedString(minVolume)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    volumeRemain: ").append(toIndentedString(volumeRemain)).append("\n");
    sb.append("    volumeTotal: ").append(toIndentedString(volumeTotal)).append("\n");
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
