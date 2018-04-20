package webapp.domain.request;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

public class RatingRequestParam {

	private List<Long> channels;
	private List<String> channelNames;
	private List<Long> plans;
	private List<Long> targetGrpIds;
	private List<String> targetGrpNames;
	private List<String> stewardshipStatus;
	
	private String ratingTable;
	
	private String startDate;

	private String endDate;
	/*Plan Fields*/
	private List<Long> planClasses;
	
	private List<String> planSubStatus;
	
	private List<Long> agencies;
	
	private List<String> agencyNames;
	
	private List<Long> advertisers;
	
	private List<String> advertiserNames;
	
	private List<Long> accountExecs;
	
	private List<String> accountExecNames;
	
	private String qtrStartDate;

	private String qtrEndDate;

	private List<Long> divisions;

	private List<Long> subDivisions;

	private List<Long> planStatus;

	private List<Long> aprrovalStatus;
	
	private List<String> guaranteed;
	
	private List<String> approvalStatusDesc;
	
	private List<Long> originalPlans;
	
	private String planStartDate;
	private String planEndDate;
	
	private String unitStartDate;
	
	private String unitEndDate;
	
	private String planModificationDateFrom;
	
	private String planModificationDateTo;

	


	

	/*Unit Fields*/
	
	private List<String> spotPlanStatus;
	private List<String> logType;
	private List<Long> salesUnitIds;
	private List<String> unitDurations;
	private List<Long> externalUsns;
	private String unitTable;
	private List<String> quarters;
	
	@ApiModelProperty(notes = "Specify the list of Channel ID/IDs eg. [10152]", required = false)
	public List<Long> getChannels() {
		return channels;
	}
	public void setChannels(List<Long> channels) {
		this.channels = channels;
	}
	@ApiModelProperty(notes = "Specify the list of Channel Name/Names eg. [\"CNBC\"]", required = false)
	public List<String> getChannelNames() {
		return channelNames;
	}
	public void setChannelNames(List<String> channelNames) {
		this.channelNames = channelNames;
	}
	@ApiModelProperty(notes = "Specify the list of Plan ID/IDs eg. [139192]", required = false)
	public List<Long> getPlans() {
		return plans;
	}
	public void setPlans(List<Long> plans) {
		this.plans = plans;
	}
	@ApiModelProperty(notes = "Specify the list of Target Group ID/IDs eg. [\"2477\"]", required = false)
	public List<Long> getTargetGrpIds() {
		return targetGrpIds;
	}
	public void setTargetGrpIds(List<Long> targetGrpIds) {
		this.targetGrpIds = targetGrpIds;
	}
	
	@ApiModelProperty(notes = "Specify the list of Target Group Name/Names eg. [\"HH\",\"P25-54\"]", required = false)
	public List<String> getTargetGrpNames() {
		return targetGrpNames;
	}
	public void setTargetGrpNames(List<String> targetGrpNames) {
		this.targetGrpNames = targetGrpNames;
	}
	@ApiModelProperty(notes = "Specify the list of possible Stewardship Status/Statuses eg. [\"MSA Actual\"]", required = false)
	public List<String> getStewardshipStatus() {
		return stewardshipStatus;
	}
	public void setStewardshipStatus(List<String> stewardshipStatus) {
		this.stewardshipStatus = stewardshipStatus;
	}
							
	@ApiModelProperty(notes = "Specify the Rating Table to be used eg. [\"lastapproved\"]", required = false,hidden=true)
	@ApiIgnore
	public String getRatingTable() {
		return ratingTable;
	}
	public void setRatingTable(String ratingTable) {
		this.ratingTable = ratingTable;
	}
	/**
	 * @return the startDate
	 *//*
	public String getStartDate() {
		return startDate;
	}
	*//**
	 * @param startDate the startDate to set
	 *//*
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	*//**
	 * @return the endDate
	 *//*
	public String getEndDate() {
		return endDate;
	}
	*//**
	 * @param endDate the endDate to set
	 *//*
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}*/
	/**
	 * @return the planClasses
	 */
							
	@ApiModelProperty(notes = "Specify the list of Plan Class/Classses associated with the Plan eg. [\"National\"]", required = false)
	public List<Long> getPlanClasses() {
		return planClasses;
	}
	/**
	 * @param planClasses the planClasses to set
	 */
	public void setPlanClasses(List<Long> planClasses) {
		this.planClasses = planClasses;
	}
	/**
	 * @return the planSubStatus
	 */
							
	@ApiModelProperty(notes = "Specify the list of Plan Sub Status eg. [\"AOL\"]", required = false)
	public List<String> getPlanSubStatus() {
		return planSubStatus;
	}
	/**
	 * @param planSubStatus the planSubStatus to set
	 */
	public void setPlanSubStatus(List<String> planSubStatus) {
		this.planSubStatus = planSubStatus;
	}
	/**
	 * @return the agencies
	 */
						
	@ApiModelProperty(notes = "Specify the list of Agency ID/IDs eg. [\"12536\"]", required = false)
	public List<Long> getAgencies() {
		return agencies;
	}
	/**
	 * @param agencies the agencies to set
	 */
	public void setAgencies(List<Long> agencies) {
		this.agencies = agencies;
	}
	/**
	 * @return the agencyNames
	 */
						
	@ApiModelProperty(notes = "Specify the list of Agency Name/Names eg. [\"Zenith Media Services Inc.\"]", required = false)
	public List<String> getAgencyNames() {
		return agencyNames;
	}
	/**
	 * @param agencyNames the agencyNames to set
	 */
	public void setAgencyNames(List<String> agencyNames) {
		this.agencyNames = agencyNames;
	}
	/**
	 * @return the advertisers
	 */
							
	@ApiModelProperty(notes = "Specify the list of Advertiser ID/IDs eg. [\"14990\"]", required = false)
	public List<Long> getAdvertisers() {
		return advertisers;
	}
	/**
	 * @param advertisers the advertisers to set
	 */
	public void setAdvertisers(List<Long> advertisers) {
		this.advertisers = advertisers;
	}
	/**
	 * @return the advertiserNames
	 */
						
	@ApiModelProperty(notes = "Specify the list of Advertiser Name/Names eg. [\"Merck & Company\"]", required = false)
	public List<String> getAdvertiserNames() {
		return advertiserNames;
	}
	/**
	 * @param advertiserNames the advertiserNames to set
	 */
	public void setAdvertiserNames(List<String> advertiserNames) {
		this.advertiserNames = advertiserNames;
	}
	/**
	 * @return the accountExecs
	 */
	@ApiModelProperty(notes = "Specify the list of Account Executive ID/IDs eg. [\"17956\"]", required = false)
	public List<Long> getAccountExecs() {
		return accountExecs;
	}
	/**
	 * @param accountExecs the accountExecs to set
	 */
	public void setAccountExecs(List<Long> accountExecs) {
		this.accountExecs = accountExecs;
	}
	/**
	 * @return the accountExecNames
	 */
	@ApiModelProperty(notes = "Specify the list of Account Executive Name/ Names eg. [\"Sztorc, Daniel (206037738)\"]", required = false)
	public List<String> getAccountExecNames() {
		return accountExecNames;
	}
	/**
	 * @param accountExecNames the accountExecNames to set
	 */
	public void setAccountExecNames(List<String> accountExecNames) {
		this.accountExecNames = accountExecNames;
	}
	/**
	 * @return the qtrStart
	 */
	@ApiModelProperty(notes = "Specify the Quarter Start Date eg. \"26-Dec-2016\"", required = false)
	public String getQtrStartDate() {
		return qtrStartDate;
	}
	/**
	 * @param qtrStart the qtrStart to set
	 */
	public void setQtrStartDate(String qtrStartDate) {
		this.qtrStartDate = qtrStartDate;
	}
	/**
	 * @return the qtrEnd
	 */
	@ApiModelProperty(notes = "Specify the Quarter End Date eg. \"26-Mar-2017\"", required = false)
	public String getQtrEndDate() {
		return qtrEndDate;
	}
	/**
	 * @param qtrEnd the qtrEnd to set
	 */
	public void setQtrEndDate(String qtrEndDate) {
		this.qtrEndDate = qtrEndDate;
	}
	/**
	 * @return the divisions
	 */
	@ApiModelProperty(notes = "Specify the list of Division ID/Division IDs of the Plan eg. [102]", required = false)
	public List<Long> getDivisions() {
		return divisions;
	}
	/**
	 * @param divisions the divisions to set
	 */
	public void setDivisions(List<Long> divisions) {
		this.divisions = divisions;
	}
	/**
	 * @return the subDivisions
	 */
	@ApiModelProperty(notes = "Specify the list of Sub Division ID/Sub Division IDs of the Plan eg. [440]", required = false)
	public List<Long> getSubDivisions() {
		return subDivisions;
	}
	/**
	 * @param subDivisions the subDivisions to set
	 */
	public void setSubDivisions(List<Long> subDivisions) {
		this.subDivisions = subDivisions;
	}
	/**
	 * @return the planStatus
	 */
	@ApiModelProperty(notes = "Specify the list of Plan Status ID/ Plan Status IDs of the Plan eg. [1336007]", required = false)
	public List<Long> getPlanStatus() {
		return planStatus;
	}
	/**
	 * @param planStatus the planStatus to set
	 */
	public void setPlanStatus(List<Long> planStatus) {
		this.planStatus = planStatus;
	}
	/**
	 * @return the aprrovalStatus
	 *//*
	@ApiModelProperty(notes = "Specify the list of Plan Approval Status/Statuses of the Plan eg. \"Approved\"", required = false)
	public List<Long> getAprrovalStatus() {
		return aprrovalStatus;
	}
	*//**
	 * @param aprrovalStatus the aprrovalStatus to set
	 *//*
	public void setAprrovalStatus(List<Long> aprrovalStatus) {
		this.aprrovalStatus = aprrovalStatus;
	}
	*//**
	 * @return the guaranteed
	 */
	@ApiModelProperty(notes = "Specify if the Plan is Guaranteed eg. [\"Guaranteed\"]", required = false)
	public List<String> getGuaranteed() {
		return guaranteed;
	}
	/**
	 * @param guaranteed the guaranteed to set
	 */
	public void setGuaranteed(List<String> guaranteed) {
		this.guaranteed = guaranteed;
	}
	/**
	 * @return the originalPlans
	 */
	@ApiModelProperty(notes = "Specify the list of Original Plan ID/IDs eg. [\"172231\"]", required = false)
	public List<Long> getOriginalPlans() {
		return originalPlans;
	}
	/**
	 * @param originalPlans the originalPlans to set
	 */
	public void setOriginalPlans(List<Long> originalPlans) {
		this.originalPlans = originalPlans;
	}
	/**
	 * @return the approvalStatusDesc
	 */
	@ApiModelProperty(notes = "Specify the list of Plan Approval Status/Statuses of the Plan eg. [\"Approved\"]", required = false)
	public List<String> getApprovalStatusDesc() {
		return approvalStatusDesc;
	}
	/**
	 * @param approvalStatusDesc the approvalStatusDesc to set
	 */
	public void setApprovalStatusDesc(List<String> approvalStatusDesc) {
		this.approvalStatusDesc = approvalStatusDesc;
	}
	/**
	 * @return the spotPlanStatus
	 */
	@ApiModelProperty(notes = "Specify the list of the log the spot occurs in eg. [\"Actual\"]", required = false)
	public List<String> getSpotPlanStatus() {
		return spotPlanStatus;
	}
	/**
	 * @param spotPlanStatus the spotPlanStatus to set
	 */
	public void setSpotPlanStatus(List<String> spotPlanStatus) {
		this.spotPlanStatus = spotPlanStatus;
	}
	/**
	 * @return the logTypes
	 */
	
	@ApiModelProperty(notes = "Specify the list of the log the spot occurs in eg. [\"Actual\"]", required = false)
	public List<String> getLogType() {
		return logType;
	}
	/**
	 * @param logTypes the logTypes to set
	 */
	public void setLogType(List<String> logType) {
		this.logType = logType;
	}
	/**
	 * @return the salesUnitIds
	 */
	@ApiModelProperty(notes = "Specify list of Sales Unit ID/IDs eg. [44152,44165,45377]", required = false)
	public List<Long> getSalesUnitIds() {
		return salesUnitIds;
	}
	/**
	 * @param salesUnitIds the salesUnitIds to set
	 */
	public void setSalesUnitIds(List<Long> salesUnitIds) {
		this.salesUnitIds = salesUnitIds;
	}
	/**
	 * @return the unitDurations
	 */

	@ApiModelProperty(notes = "Specify the list of the Unit Duration of the Spot eg. [\":30\"]", required = false)
	public List<String> getUnitDurations() {
		return unitDurations;
	}
	/**
	 * @param unitDurations the unitDurations to set
	 */
	public void setUnitDurations(List<String> unitDurations) {
		this.unitDurations = unitDurations;
	}
	/**
	 * @return the externalUsns
	 */
	@ApiModelProperty(notes = "Specify the list of the External USN/USNs eg. [101630779]", required = false)
	public List<Long> getExternalUsns() {
		return externalUsns;
	}
	/**
	 * @param externalUsns the externalUsns to set
	 */
	public void setExternalUsns(List<Long> externalUsns) {
		this.externalUsns = externalUsns;
	}
	/**
	 * @return the unitTable
	 *//*
	public String getUnitTable() {
		return unitTable;
	}
	*//**
	 * @param unitTable the unitTable to set
	 *//*
	public void setUnitTable(String unitTable) {
		this.unitTable = unitTable;
	}*/
	/**
	 * @return the spotQtrs
	 */
	@ApiModelProperty(notes = "Specify the list of Quarter/Quarters the spots occur in eg. [\"1Q17\"]", required = false)
	public List<String> getQuarters() {
		return quarters;
	}
	/**
	 * @param spotQtrs the spotQtrs to set
	 */
	public void setQuarters(List<String> quarters) {
		this.quarters = quarters;
	}
	/**
	 * @return the planStartDate
	 */
	@ApiModelProperty(notes = "Specify the Date for the plan range start date eg. \"29-Jun-15\"", required = false)
	public String getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * @param planStartDate the planStartDate to set
	 */
	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}
	/**
	 * @return the planEndDate
	 */
	@ApiModelProperty(notes = "Specify the Date for the plan range end date eg. \"26-Mar-16\"", required = false)
	public String getPlanEndDate() {
		return planEndDate;
	}
	/**
	 * @param planEndDate the planEndDate to set
	 */
	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}
	/**
	 * @return the unitStartDate
	 */
	@ApiModelProperty(notes = "Specify the Date for the unit range start date eg. \"29-Jun-15\"", required = false)
	public String getUnitStartDate() {
		return unitStartDate;
	}
	/**
	 * @param unitStartDate the unitStartDate to set
	 */
	public void setUnitStartDate(String unitStartDate) {
		this.unitStartDate = unitStartDate;
	}
	/**
	 * @return the unitEndDate
	 */
	@ApiModelProperty(notes = "Specify the Date for the unit range end date eg. \"26-Mar-16\"", required = false)
	public String getUnitEndDate() {
		return unitEndDate;
	}
	/**
	 * @param unitEndDate the unitEndDate to set
	 */
	public void setUnitEndDate(String unitEndDate) {
		this.unitEndDate = unitEndDate;
	}
	/**
	 * @return the modificationDateFrom
	 */
	@ApiModelProperty(notes = "Specify plan modification date from eg. \"26-Jan-2016 18:44:24\"", required = false)
	public String getPlanModificationDateFrom() {
		return planModificationDateFrom;
	}

	/**
	 * @param modificationDateFrom the modificationDateFrom to set
	 */
	public void setPlanModificationDateFrom(String modificationDateFrom) {
		this.planModificationDateFrom = modificationDateFrom;
	}

	/**
	 * @return the modificationDateTo
	 */
	@ApiModelProperty(notes = "Specify plan modification date to eg. \"29-Apr-2016 10:50:40\"", required = false)
	public String getPlanModificationDateTo() {
		return planModificationDateTo;
	}
	/**
	 * @param modificationDateTo the modificationDateTo to set
	 */
	public void setPlanModificationDateTo(String modificationDateTo) {
		this.planModificationDateTo = modificationDateTo;
	}
	
}