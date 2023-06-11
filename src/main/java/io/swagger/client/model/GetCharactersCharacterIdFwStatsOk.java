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
import io.swagger.client.model.GetCharactersCharacterIdFwStatsKills;
import io.swagger.client.model.GetCharactersCharacterIdFwStatsVictoryPoints;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetCharactersCharacterIdFwStatsOk {
  @SerializedName("current_rank")
  private Integer currentRank = null;

  @SerializedName("enlisted_on")
  private OffsetDateTime enlistedOn = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  @SerializedName("highest_rank")
  private Integer highestRank = null;

  @SerializedName("kills")
  private GetCharactersCharacterIdFwStatsKills kills = null;

  @SerializedName("victory_points")
  private GetCharactersCharacterIdFwStatsVictoryPoints victoryPoints = null;

  public GetCharactersCharacterIdFwStatsOk currentRank(Integer currentRank) {
    this.currentRank = currentRank;
    return this;
  }

   /**
   * The given character&#x27;s current faction rank
   * minimum: 0
   * maximum: 9
   * @return currentRank
  **/
  @Schema(description = "The given character's current faction rank")
  public Integer getCurrentRank() {
    return currentRank;
  }

  public void setCurrentRank(Integer currentRank) {
    this.currentRank = currentRank;
  }

  public GetCharactersCharacterIdFwStatsOk enlistedOn(OffsetDateTime enlistedOn) {
    this.enlistedOn = enlistedOn;
    return this;
  }

   /**
   * The enlistment date of the given character into faction warfare. Will not be included if character is not enlisted in faction warfare
   * @return enlistedOn
  **/
  @Schema(description = "The enlistment date of the given character into faction warfare. Will not be included if character is not enlisted in faction warfare")
  public OffsetDateTime getEnlistedOn() {
    return enlistedOn;
  }

  public void setEnlistedOn(OffsetDateTime enlistedOn) {
    this.enlistedOn = enlistedOn;
  }

  public GetCharactersCharacterIdFwStatsOk factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * The faction the given character is enlisted to fight for. Will not be included if character is not enlisted in faction warfare
   * @return factionId
  **/
  @Schema(description = "The faction the given character is enlisted to fight for. Will not be included if character is not enlisted in faction warfare")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }

  public GetCharactersCharacterIdFwStatsOk highestRank(Integer highestRank) {
    this.highestRank = highestRank;
    return this;
  }

   /**
   * The given character&#x27;s highest faction rank achieved
   * minimum: 0
   * maximum: 9
   * @return highestRank
  **/
  @Schema(description = "The given character's highest faction rank achieved")
  public Integer getHighestRank() {
    return highestRank;
  }

  public void setHighestRank(Integer highestRank) {
    this.highestRank = highestRank;
  }

  public GetCharactersCharacterIdFwStatsOk kills(GetCharactersCharacterIdFwStatsKills kills) {
    this.kills = kills;
    return this;
  }

   /**
   * Get kills
   * @return kills
  **/
  @Schema(required = true, description = "")
  public GetCharactersCharacterIdFwStatsKills getKills() {
    return kills;
  }

  public void setKills(GetCharactersCharacterIdFwStatsKills kills) {
    this.kills = kills;
  }

  public GetCharactersCharacterIdFwStatsOk victoryPoints(GetCharactersCharacterIdFwStatsVictoryPoints victoryPoints) {
    this.victoryPoints = victoryPoints;
    return this;
  }

   /**
   * Get victoryPoints
   * @return victoryPoints
  **/
  @Schema(required = true, description = "")
  public GetCharactersCharacterIdFwStatsVictoryPoints getVictoryPoints() {
    return victoryPoints;
  }

  public void setVictoryPoints(GetCharactersCharacterIdFwStatsVictoryPoints victoryPoints) {
    this.victoryPoints = victoryPoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdFwStatsOk getCharactersCharacterIdFwStatsOk = (GetCharactersCharacterIdFwStatsOk) o;
    return Objects.equals(this.currentRank, getCharactersCharacterIdFwStatsOk.currentRank) &&
        Objects.equals(this.enlistedOn, getCharactersCharacterIdFwStatsOk.enlistedOn) &&
        Objects.equals(this.factionId, getCharactersCharacterIdFwStatsOk.factionId) &&
        Objects.equals(this.highestRank, getCharactersCharacterIdFwStatsOk.highestRank) &&
        Objects.equals(this.kills, getCharactersCharacterIdFwStatsOk.kills) &&
        Objects.equals(this.victoryPoints, getCharactersCharacterIdFwStatsOk.victoryPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentRank, enlistedOn, factionId, highestRank, kills, victoryPoints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdFwStatsOk {\n");
    
    sb.append("    currentRank: ").append(toIndentedString(currentRank)).append("\n");
    sb.append("    enlistedOn: ").append(toIndentedString(enlistedOn)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
    sb.append("    highestRank: ").append(toIndentedString(highestRank)).append("\n");
    sb.append("    kills: ").append(toIndentedString(kills)).append("\n");
    sb.append("    victoryPoints: ").append(toIndentedString(victoryPoints)).append("\n");
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