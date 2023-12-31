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
public class GetStatusOk {
  @SerializedName("players")
  private Integer players = null;

  @SerializedName("server_version")
  private String serverVersion = null;

  @SerializedName("start_time")
  private OffsetDateTime startTime = null;

  @SerializedName("vip")
  private Boolean vip = null;

  public GetStatusOk players(Integer players) {
    this.players = players;
    return this;
  }

   /**
   * Current online player count
   * @return players
  **/
  @Schema(required = true, description = "Current online player count")
  public Integer getPlayers() {
    return players;
  }

  public void setPlayers(Integer players) {
    this.players = players;
  }

  public GetStatusOk serverVersion(String serverVersion) {
    this.serverVersion = serverVersion;
    return this;
  }

   /**
   * Running version as string
   * @return serverVersion
  **/
  @Schema(required = true, description = "Running version as string")
  public String getServerVersion() {
    return serverVersion;
  }

  public void setServerVersion(String serverVersion) {
    this.serverVersion = serverVersion;
  }

  public GetStatusOk startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Server start timestamp
   * @return startTime
  **/
  @Schema(required = true, description = "Server start timestamp")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public GetStatusOk vip(Boolean vip) {
    this.vip = vip;
    return this;
  }

   /**
   * If the server is in VIP mode
   * @return vip
  **/
  @Schema(description = "If the server is in VIP mode")
  public Boolean isVip() {
    return vip;
  }

  public void setVip(Boolean vip) {
    this.vip = vip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetStatusOk getStatusOk = (GetStatusOk) o;
    return Objects.equals(this.players, getStatusOk.players) &&
        Objects.equals(this.serverVersion, getStatusOk.serverVersion) &&
        Objects.equals(this.startTime, getStatusOk.startTime) &&
        Objects.equals(this.vip, getStatusOk.vip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players, serverVersion, startTime, vip);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetStatusOk {\n");
    
    sb.append("    players: ").append(toIndentedString(players)).append("\n");
    sb.append("    serverVersion: ").append(toIndentedString(serverVersion)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
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
