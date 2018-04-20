package webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(schema = "nbc_cust", name = "micro_svc_rating_la_vw")
@IdClass(RatingPK.class)
public class LastApprovedRating extends Rating implements Serializable {
	private Long planId;
	private Long externalUsn;
	private Long targetGroupId;
	private String targetGroupName;
	private String demoPitchedCpm;
	private String demoPitchedImps;
	private String demoRcCpm;
	private String demoRcImps;
	private String actualAudience;
	private String pitchedNatlRating;
	private String pitchedNwRating;
	private String actualNatlRating;
	private Long propertyId;
	private String propertyName;
	private Long actualStatusCode;
	private String stewardshipStatus;		
	
	@Id
	@Column(name="PLAN_ID")
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	@Id
	@Column(name="EXTERNAL_USN")
	public Long getExternalUsn() {
		return externalUsn;
	}
	public void setExternalUsn(Long externalUsn) {
		this.externalUsn = externalUsn;
	}
	
	@Id
	@Column(name="TARGET_GROUP_ID")
	public Long getTargetGroupId() {
		return targetGroupId;
	}
	public void setTargetGroupId(Long targetGroupId) {
		this.targetGroupId = targetGroupId;
	}
	
	@Column(name="TARGET_GROUP_NAME")
	public String getTargetGroupName() {
		return targetGroupName;
	}
	public void setTargetGroupName(String targetGroupName) {
		this.targetGroupName = targetGroupName;
	}
	
	@Column(name="DEMO_PITCHED_CPM")
	public String getDemoPitchedCpm() {
		return demoPitchedCpm;
	}
	public void setDemoPitchedCpm(String demoPitchedCpm) {
		this.demoPitchedCpm = demoPitchedCpm;
	}
	
	@Column(name="DEMO_PITCHED_IMPS")
	public String getDemoPitchedImps() {
		return demoPitchedImps;
	}
	public void setDemoPitchedImps(String demoPitchedImps) {
		this.demoPitchedImps = demoPitchedImps;
	}
	
	@Column(name="DEMO_RC_CPM")
	public String getDemoRcCpm() {
		return demoRcCpm;
	}
	public void setDemoRcCpm(String demoRcCpm) {
		this.demoRcCpm = demoRcCpm;
	}
	
	@Column(name="DEMO_RC_IMPS")
	public String getDemoRcImps() {
		return demoRcImps;
	}
	public void setDemoRcImps(String demoRcImps) {
		this.demoRcImps = demoRcImps;
	}
	
	@Column(name="ACTUAL_AUDIENCE")
	public String getActualAudience() {
		return actualAudience;
	}
	public void setActualAudience(String actualAudience) {
		this.actualAudience = actualAudience;
	}
	
	@Column(name="PITCHED_NATIONAL_RATING")
	public String getPitchedNatlRating() {
		return pitchedNatlRating;
	}
	public void setPitchedNatlRating(String pitchedNatlRating) {
		this.pitchedNatlRating = pitchedNatlRating;
	}
	
	@Column(name="PITCHED_NETWORK_RATING")
	public String getPitchedNwRating() {
		return pitchedNwRating;
	}
	public void setPitchedNwRating(String pitchedNwRating) {
		this.pitchedNwRating = pitchedNwRating;
	}
	
	/**
	 * @return the actualNatlRating
	 */
	@Column(name="ACTUAL_NATIONAL_RATING")
	public String getActualNatlRating() {
		return actualNatlRating;
	}
	/**
	 * @param actualNatlRating the actualNatlRating to set
	 */
	public void setActualNatlRating(String actualNatlRating) {
		this.actualNatlRating = actualNatlRating;
	}
	
	@Column(name="PROPERTY_ID")
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	
	@Column(name="PROPERTY_NAME")
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	@Column(name="ACTUAL_STATUS_CODE")
	public Long getActualStatusCode() {
		return actualStatusCode;
	}
	public void setActualStatusCode(Long actualStatusCode) {
		this.actualStatusCode = actualStatusCode;
	}
	
	@Column(name="STEWARDSHIP_STATUS")
	public String getStewardshipStatus() {
		return stewardshipStatus;
	}
	public void setStewardshipStatus(String stewardshipStatus) {
		this.stewardshipStatus = stewardshipStatus;
	}
	
}