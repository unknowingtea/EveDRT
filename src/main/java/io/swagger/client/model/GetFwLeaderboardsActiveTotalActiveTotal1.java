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
 * active_total object
 */
@Schema(description = "active_total object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetFwLeaderboardsActiveTotalActiveTotal1 {
  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  public GetFwLeaderboardsActiveTotalActiveTotal1 amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount of victory points
   * @return amount
  **/
  @Schema(description = "Amount of victory points")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public GetFwLeaderboardsActiveTotalActiveTotal1 factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * faction_id integer
   * @return factionId
  **/
  @Schema(description = "faction_id integer")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFwLeaderboardsActiveTotalActiveTotal1 getFwLeaderboardsActiveTotalActiveTotal1 = (GetFwLeaderboardsActiveTotalActiveTotal1) o;
    return Objects.equals(this.amount, getFwLeaderboardsActiveTotalActiveTotal1.amount) &&
        Objects.equals(this.factionId, getFwLeaderboardsActiveTotalActiveTotal1.factionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, factionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwLeaderboardsActiveTotalActiveTotal1 {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
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
