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
public class GetCorporationsCorporationIdStarbases200Ok {
  @SerializedName("moon_id")
  private Integer moonId = null;

  @SerializedName("onlined_since")
  private OffsetDateTime onlinedSince = null;

  @SerializedName("reinforced_until")
  private OffsetDateTime reinforcedUntil = null;

  @SerializedName("starbase_id")
  private Long starbaseId = null;

  /**
   * state string
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    OFFLINE("offline"),
    ONLINE("online"),
    ONLINING("onlining"),
    REINFORCED("reinforced"),
    UNANCHORING("unanchoring");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StateEnum fromValue(String input) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StateEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("state")
  private StateEnum state = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  @SerializedName("unanchor_at")
  private OffsetDateTime unanchorAt = null;

  public GetCorporationsCorporationIdStarbases200Ok moonId(Integer moonId) {
    this.moonId = moonId;
    return this;
  }

   /**
   * The moon this starbase (POS) is anchored on, unanchored POSes do not have this information
   * @return moonId
  **/
  @Schema(description = "The moon this starbase (POS) is anchored on, unanchored POSes do not have this information")
  public Integer getMoonId() {
    return moonId;
  }

  public void setMoonId(Integer moonId) {
    this.moonId = moonId;
  }

  public GetCorporationsCorporationIdStarbases200Ok onlinedSince(OffsetDateTime onlinedSince) {
    this.onlinedSince = onlinedSince;
    return this;
  }

   /**
   * When the POS onlined, for starbases (POSes) in online state
   * @return onlinedSince
  **/
  @Schema(description = "When the POS onlined, for starbases (POSes) in online state")
  public OffsetDateTime getOnlinedSince() {
    return onlinedSince;
  }

  public void setOnlinedSince(OffsetDateTime onlinedSince) {
    this.onlinedSince = onlinedSince;
  }

  public GetCorporationsCorporationIdStarbases200Ok reinforcedUntil(OffsetDateTime reinforcedUntil) {
    this.reinforcedUntil = reinforcedUntil;
    return this;
  }

   /**
   * When the POS will be out of reinforcement, for starbases (POSes) in reinforced state
   * @return reinforcedUntil
  **/
  @Schema(description = "When the POS will be out of reinforcement, for starbases (POSes) in reinforced state")
  public OffsetDateTime getReinforcedUntil() {
    return reinforcedUntil;
  }

  public void setReinforcedUntil(OffsetDateTime reinforcedUntil) {
    this.reinforcedUntil = reinforcedUntil;
  }

  public GetCorporationsCorporationIdStarbases200Ok starbaseId(Long starbaseId) {
    this.starbaseId = starbaseId;
    return this;
  }

   /**
   * Unique ID for this starbase (POS)
   * @return starbaseId
  **/
  @Schema(required = true, description = "Unique ID for this starbase (POS)")
  public Long getStarbaseId() {
    return starbaseId;
  }

  public void setStarbaseId(Long starbaseId) {
    this.starbaseId = starbaseId;
  }

  public GetCorporationsCorporationIdStarbases200Ok state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * state string
   * @return state
  **/
  @Schema(description = "state string")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public GetCorporationsCorporationIdStarbases200Ok systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system this starbase (POS) is in, unanchored POSes have this information
   * @return systemId
  **/
  @Schema(required = true, description = "The solar system this starbase (POS) is in, unanchored POSes have this information")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  public GetCorporationsCorporationIdStarbases200Ok typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * Starbase (POS) type
   * @return typeId
  **/
  @Schema(required = true, description = "Starbase (POS) type")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public GetCorporationsCorporationIdStarbases200Ok unanchorAt(OffsetDateTime unanchorAt) {
    this.unanchorAt = unanchorAt;
    return this;
  }

   /**
   * When the POS started unanchoring, for starbases (POSes) in unanchoring state
   * @return unanchorAt
  **/
  @Schema(description = "When the POS started unanchoring, for starbases (POSes) in unanchoring state")
  public OffsetDateTime getUnanchorAt() {
    return unanchorAt;
  }

  public void setUnanchorAt(OffsetDateTime unanchorAt) {
    this.unanchorAt = unanchorAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdStarbases200Ok getCorporationsCorporationIdStarbases200Ok = (GetCorporationsCorporationIdStarbases200Ok) o;
    return Objects.equals(this.moonId, getCorporationsCorporationIdStarbases200Ok.moonId) &&
        Objects.equals(this.onlinedSince, getCorporationsCorporationIdStarbases200Ok.onlinedSince) &&
        Objects.equals(this.reinforcedUntil, getCorporationsCorporationIdStarbases200Ok.reinforcedUntil) &&
        Objects.equals(this.starbaseId, getCorporationsCorporationIdStarbases200Ok.starbaseId) &&
        Objects.equals(this.state, getCorporationsCorporationIdStarbases200Ok.state) &&
        Objects.equals(this.systemId, getCorporationsCorporationIdStarbases200Ok.systemId) &&
        Objects.equals(this.typeId, getCorporationsCorporationIdStarbases200Ok.typeId) &&
        Objects.equals(this.unanchorAt, getCorporationsCorporationIdStarbases200Ok.unanchorAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moonId, onlinedSince, reinforcedUntil, starbaseId, state, systemId, typeId, unanchorAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdStarbases200Ok {\n");
    
    sb.append("    moonId: ").append(toIndentedString(moonId)).append("\n");
    sb.append("    onlinedSince: ").append(toIndentedString(onlinedSince)).append("\n");
    sb.append("    reinforcedUntil: ").append(toIndentedString(reinforcedUntil)).append("\n");
    sb.append("    starbaseId: ").append(toIndentedString(starbaseId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    unanchorAt: ").append(toIndentedString(unanchorAt)).append("\n");
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
