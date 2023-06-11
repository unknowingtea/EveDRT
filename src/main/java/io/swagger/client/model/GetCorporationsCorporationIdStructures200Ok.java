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
import io.swagger.client.model.GetCorporationsCorporationIdStructuresService;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * 200 ok object
 */
@Schema(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-12-18T15:18:58.117336-05:00[America/New_York]")
public class GetCorporationsCorporationIdStructures200Ok {
  @SerializedName("corporation_id")
  private Integer corporationId = null;

  @SerializedName("fuel_expires")
  private OffsetDateTime fuelExpires = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("next_reinforce_apply")
  private OffsetDateTime nextReinforceApply = null;

  @SerializedName("next_reinforce_hour")
  private Integer nextReinforceHour = null;

  @SerializedName("profile_id")
  private Integer profileId = null;

  @SerializedName("reinforce_hour")
  private Integer reinforceHour = null;

  @SerializedName("services")
  private List<GetCorporationsCorporationIdStructuresService> services = null;

  /**
   * state string
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    ANCHOR_VULNERABLE("anchor_vulnerable"),
    ANCHORING("anchoring"),
    ARMOR_REINFORCE("armor_reinforce"),
    ARMOR_VULNERABLE("armor_vulnerable"),
    DEPLOY_VULNERABLE("deploy_vulnerable"),
    FITTING_INVULNERABLE("fitting_invulnerable"),
    HULL_REINFORCE("hull_reinforce"),
    HULL_VULNERABLE("hull_vulnerable"),
    ONLINE_DEPRECATED("online_deprecated"),
    ONLINING_VULNERABLE("onlining_vulnerable"),
    SHIELD_VULNERABLE("shield_vulnerable"),
    UNANCHORED("unanchored"),
    UNKNOWN("unknown");

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

  @SerializedName("state_timer_end")
  private OffsetDateTime stateTimerEnd = null;

  @SerializedName("state_timer_start")
  private OffsetDateTime stateTimerStart = null;

  @SerializedName("structure_id")
  private Long structureId = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  @SerializedName("unanchors_at")
  private OffsetDateTime unanchorsAt = null;

  public GetCorporationsCorporationIdStructures200Ok corporationId(Integer corporationId) {
    this.corporationId = corporationId;
    return this;
  }

   /**
   * ID of the corporation that owns the structure
   * @return corporationId
  **/
  @Schema(required = true, description = "ID of the corporation that owns the structure")
  public Integer getCorporationId() {
    return corporationId;
  }

  public void setCorporationId(Integer corporationId) {
    this.corporationId = corporationId;
  }

  public GetCorporationsCorporationIdStructures200Ok fuelExpires(OffsetDateTime fuelExpires) {
    this.fuelExpires = fuelExpires;
    return this;
  }

   /**
   * Date on which the structure will run out of fuel
   * @return fuelExpires
  **/
  @Schema(description = "Date on which the structure will run out of fuel")
  public OffsetDateTime getFuelExpires() {
    return fuelExpires;
  }

  public void setFuelExpires(OffsetDateTime fuelExpires) {
    this.fuelExpires = fuelExpires;
  }

  public GetCorporationsCorporationIdStructures200Ok name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The structure name
   * @return name
  **/
  @Schema(description = "The structure name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCorporationsCorporationIdStructures200Ok nextReinforceApply(OffsetDateTime nextReinforceApply) {
    this.nextReinforceApply = nextReinforceApply;
    return this;
  }

   /**
   * The date and time when the structure&#x27;s newly requested reinforcement times (e.g. next_reinforce_hour and next_reinforce_day) will take effect
   * @return nextReinforceApply
  **/
  @Schema(description = "The date and time when the structure's newly requested reinforcement times (e.g. next_reinforce_hour and next_reinforce_day) will take effect")
  public OffsetDateTime getNextReinforceApply() {
    return nextReinforceApply;
  }

  public void setNextReinforceApply(OffsetDateTime nextReinforceApply) {
    this.nextReinforceApply = nextReinforceApply;
  }

  public GetCorporationsCorporationIdStructures200Ok nextReinforceHour(Integer nextReinforceHour) {
    this.nextReinforceHour = nextReinforceHour;
    return this;
  }

   /**
   * The requested change to reinforce_hour that will take effect at the time shown by next_reinforce_apply
   * minimum: 0
   * maximum: 23
   * @return nextReinforceHour
  **/
  @Schema(description = "The requested change to reinforce_hour that will take effect at the time shown by next_reinforce_apply")
  public Integer getNextReinforceHour() {
    return nextReinforceHour;
  }

  public void setNextReinforceHour(Integer nextReinforceHour) {
    this.nextReinforceHour = nextReinforceHour;
  }

  public GetCorporationsCorporationIdStructures200Ok profileId(Integer profileId) {
    this.profileId = profileId;
    return this;
  }

   /**
   * The id of the ACL profile for this citadel
   * @return profileId
  **/
  @Schema(required = true, description = "The id of the ACL profile for this citadel")
  public Integer getProfileId() {
    return profileId;
  }

  public void setProfileId(Integer profileId) {
    this.profileId = profileId;
  }

  public GetCorporationsCorporationIdStructures200Ok reinforceHour(Integer reinforceHour) {
    this.reinforceHour = reinforceHour;
    return this;
  }

   /**
   * The hour of day that determines the four hour window when the structure will randomly exit its reinforcement periods and become vulnerable to attack against its armor and/or hull. The structure will become vulnerable at a random time that is +/- 2 hours centered on the value of this property
   * minimum: 0
   * maximum: 23
   * @return reinforceHour
  **/
  @Schema(description = "The hour of day that determines the four hour window when the structure will randomly exit its reinforcement periods and become vulnerable to attack against its armor and/or hull. The structure will become vulnerable at a random time that is +/- 2 hours centered on the value of this property")
  public Integer getReinforceHour() {
    return reinforceHour;
  }

  public void setReinforceHour(Integer reinforceHour) {
    this.reinforceHour = reinforceHour;
  }

  public GetCorporationsCorporationIdStructures200Ok services(List<GetCorporationsCorporationIdStructuresService> services) {
    this.services = services;
    return this;
  }

  public GetCorporationsCorporationIdStructures200Ok addServicesItem(GetCorporationsCorporationIdStructuresService servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<GetCorporationsCorporationIdStructuresService>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Contains a list of service upgrades, and their state
   * @return services
  **/
  @Schema(description = "Contains a list of service upgrades, and their state")
  public List<GetCorporationsCorporationIdStructuresService> getServices() {
    return services;
  }

  public void setServices(List<GetCorporationsCorporationIdStructuresService> services) {
    this.services = services;
  }

  public GetCorporationsCorporationIdStructures200Ok state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * state string
   * @return state
  **/
  @Schema(required = true, description = "state string")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public GetCorporationsCorporationIdStructures200Ok stateTimerEnd(OffsetDateTime stateTimerEnd) {
    this.stateTimerEnd = stateTimerEnd;
    return this;
  }

   /**
   * Date at which the structure will move to it&#x27;s next state
   * @return stateTimerEnd
  **/
  @Schema(description = "Date at which the structure will move to it's next state")
  public OffsetDateTime getStateTimerEnd() {
    return stateTimerEnd;
  }

  public void setStateTimerEnd(OffsetDateTime stateTimerEnd) {
    this.stateTimerEnd = stateTimerEnd;
  }

  public GetCorporationsCorporationIdStructures200Ok stateTimerStart(OffsetDateTime stateTimerStart) {
    this.stateTimerStart = stateTimerStart;
    return this;
  }

   /**
   * Date at which the structure entered it&#x27;s current state
   * @return stateTimerStart
  **/
  @Schema(description = "Date at which the structure entered it's current state")
  public OffsetDateTime getStateTimerStart() {
    return stateTimerStart;
  }

  public void setStateTimerStart(OffsetDateTime stateTimerStart) {
    this.stateTimerStart = stateTimerStart;
  }

  public GetCorporationsCorporationIdStructures200Ok structureId(Long structureId) {
    this.structureId = structureId;
    return this;
  }

   /**
   * The Item ID of the structure
   * @return structureId
  **/
  @Schema(required = true, description = "The Item ID of the structure")
  public Long getStructureId() {
    return structureId;
  }

  public void setStructureId(Long structureId) {
    this.structureId = structureId;
  }

  public GetCorporationsCorporationIdStructures200Ok systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system the structure is in
   * @return systemId
  **/
  @Schema(required = true, description = "The solar system the structure is in")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  public GetCorporationsCorporationIdStructures200Ok typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * The type id of the structure
   * @return typeId
  **/
  @Schema(required = true, description = "The type id of the structure")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public GetCorporationsCorporationIdStructures200Ok unanchorsAt(OffsetDateTime unanchorsAt) {
    this.unanchorsAt = unanchorsAt;
    return this;
  }

   /**
   * Date at which the structure will unanchor
   * @return unanchorsAt
  **/
  @Schema(description = "Date at which the structure will unanchor")
  public OffsetDateTime getUnanchorsAt() {
    return unanchorsAt;
  }

  public void setUnanchorsAt(OffsetDateTime unanchorsAt) {
    this.unanchorsAt = unanchorsAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdStructures200Ok getCorporationsCorporationIdStructures200Ok = (GetCorporationsCorporationIdStructures200Ok) o;
    return Objects.equals(this.corporationId, getCorporationsCorporationIdStructures200Ok.corporationId) &&
        Objects.equals(this.fuelExpires, getCorporationsCorporationIdStructures200Ok.fuelExpires) &&
        Objects.equals(this.name, getCorporationsCorporationIdStructures200Ok.name) &&
        Objects.equals(this.nextReinforceApply, getCorporationsCorporationIdStructures200Ok.nextReinforceApply) &&
        Objects.equals(this.nextReinforceHour, getCorporationsCorporationIdStructures200Ok.nextReinforceHour) &&
        Objects.equals(this.profileId, getCorporationsCorporationIdStructures200Ok.profileId) &&
        Objects.equals(this.reinforceHour, getCorporationsCorporationIdStructures200Ok.reinforceHour) &&
        Objects.equals(this.services, getCorporationsCorporationIdStructures200Ok.services) &&
        Objects.equals(this.state, getCorporationsCorporationIdStructures200Ok.state) &&
        Objects.equals(this.stateTimerEnd, getCorporationsCorporationIdStructures200Ok.stateTimerEnd) &&
        Objects.equals(this.stateTimerStart, getCorporationsCorporationIdStructures200Ok.stateTimerStart) &&
        Objects.equals(this.structureId, getCorporationsCorporationIdStructures200Ok.structureId) &&
        Objects.equals(this.systemId, getCorporationsCorporationIdStructures200Ok.systemId) &&
        Objects.equals(this.typeId, getCorporationsCorporationIdStructures200Ok.typeId) &&
        Objects.equals(this.unanchorsAt, getCorporationsCorporationIdStructures200Ok.unanchorsAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(corporationId, fuelExpires, name, nextReinforceApply, nextReinforceHour, profileId, reinforceHour, services, state, stateTimerEnd, stateTimerStart, structureId, systemId, typeId, unanchorsAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdStructures200Ok {\n");
    
    sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
    sb.append("    fuelExpires: ").append(toIndentedString(fuelExpires)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nextReinforceApply: ").append(toIndentedString(nextReinforceApply)).append("\n");
    sb.append("    nextReinforceHour: ").append(toIndentedString(nextReinforceHour)).append("\n");
    sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
    sb.append("    reinforceHour: ").append(toIndentedString(reinforceHour)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stateTimerEnd: ").append(toIndentedString(stateTimerEnd)).append("\n");
    sb.append("    stateTimerStart: ").append(toIndentedString(stateTimerStart)).append("\n");
    sb.append("    structureId: ").append(toIndentedString(structureId)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    unanchorsAt: ").append(toIndentedString(unanchorsAt)).append("\n");
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
