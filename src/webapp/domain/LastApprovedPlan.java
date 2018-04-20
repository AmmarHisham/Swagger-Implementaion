package webapp.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "nbc_cust", name = "MVW_MS_PLAN_LA") 	
public class LastApprovedPlan extends Plan implements Serializable {
	private Long planId;
	private String planName;
	private Long planStatusCode;
	private String planStatus;
	private String planSubStatus;
	private Long planClassCode;	
	private String planClass;	
	private String startDate;
	private String endDate;
	private Long originalPlanId;
	private Long propertyId;
	private String propertyName;
	private Long aeId;
	private String aeName;
	private Long ratingStreamCode;
	private String ratingStream;
	private Long demoPostBuyId;
	private String demoPostBuy;
	private String equiv;
	private Long hhPostBuyId;
	private String hhPostBuy;
	private String primaryDemo;	
	private String qtrStart;
	private String qtrEnd;
	private String guaranteedPrice;
	private String guaranteedImpressions;
	private Long divisionId;
	private String division;
	private Long subDivisionId;
	private String subDivision;
	private Long agencyId;
	private String agencyName;	
	private Long portfolioPlanId;	
	private Long advertiserId;
	private String advertiserName;	
	private Long prgPlanId;
	private String guaranteedCode;
	private String guaranteed;
	private String approvalStatusDesc;
	private String modificationDate;
	@Column(name="MODIFICATION_DT")
	public String getModificationDate() throws ParseException {
		if(modificationDate!=null){
		 SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		 SimpleDateFormat dbformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2016-02-05 14:56:33.0
		return df.format(dbformat.parse(modificationDate));
		}
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Id	
	@Column(name="PLAN_ID")
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	/*@Column(name="PLAN_CLASS_CODE")
	public String getPlanClassId() {
		return planClassId;
	}
	public void setPlanClassId(String planClassId) {
		this.planClassId = planClassId;
	}*/
	
	@Column(name="START_DATE")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="END_DATE")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Column(name="PLAN_SUB_STATUS")
	public String getPlanSubStatus() {
		return planSubStatus;
	}
	public void setPlanSubStatus(String planSubStatus) {
		this.planSubStatus = planSubStatus;
	}
	
	@Column(name="AGENCY_ID")
	public Long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
	
	@Column(name="AGENCY")
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	@Column(name="ADVERTISER_ID")
	public Long getAdvertiserId() {
		return advertiserId;
	}
	public void setAdvertiserId(Long advertiserId) {
		this.advertiserId = advertiserId;
	}
	
	@Column(name="ADVERTISER")
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	
	@Column(name="ACCOUNT_EXEC_ID")
	public Long getAeId() {
		return aeId;
	}
	public void setAeId(Long aeId) {
		this.aeId = aeId;
	}
	
	@Column(name="ACCOUNT_EXECUTIVE")
	public String getAeName() {
		return aeName;
	}
	public void setAeName(String aeName) {
		this.aeName = aeName;
	}
	
	@Column(name="ORIGINAL_PLAN_ID")
	public Long getOriginalPlanId() {
		return originalPlanId;
	}
	public void setOriginalPlanId(Long originalPlanId) {
		this.originalPlanId = originalPlanId;
	}
	
	@Column(name="QTR_START")
	public String getQtrStart() {
		return qtrStart;
	}
	public void setQtrStart(String qtrStart) {
		this.qtrStart = qtrStart;
	}
	
	@Column(name="QTR_END")
	public String getQtrEnd() {
		return qtrEnd;
	}
	public void setQtrEnd(String qtrEnd) {
		this.qtrEnd = qtrEnd;
	}
	
	@Column(name="DIVISION")
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	@Column(name="SUB_DIVISION")
	public String getSubDivision() {
		return subDivision;
	}
	public void setSubDivision(String subDivision) {
		this.subDivision = subDivision;
	}
	
	@Column(name="PLAN_STATUS")
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	@Column(name="GUAR_PRICE")
	public String getGuaranteedPrice() {
		return guaranteedPrice;
	}
	public void setGuaranteedPrice(String guaranteedPrice) {
		this.guaranteedPrice = guaranteedPrice;
	}
	
	@Column(name="GUAR_IMPRESSIONS")
	public String getGuaranteedImpressions() {
		return guaranteedImpressions;
	}
	public void setGuaranteedImpressions(String guaranteedImpressions) {
		this.guaranteedImpressions = guaranteedImpressions;
	}
	
	
	
	@Column(name="PLAN_NAME")
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	@Column(name="PLAN_STATUS_CODE")
	public Long getPlanStatusCode() {
		return planStatusCode;
	}
	public void setPlanStatusCode(Long planStatusCode) {
		this.planStatusCode = planStatusCode;
	}
	
	@Column(name="PLAN_CLASS_CODE")
	public Long getPlanClassCode() {
		return planClassCode;
	}
	public void setPlanClassCode(Long planClassCode) {
		this.planClassCode = planClassCode;
	}
	
	@Column(name="PLAN_CLASS")
	public String getPlanClass() {
		return planClass;
	}
	public void setPlanClass(String planClass) {
		this.planClass = planClass;
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
	
	@Column(name="RATING_STREAM_CODE")
	public Long getRatingStreamCode() {
		return ratingStreamCode;
	}
	public void setRatingStreamCode(Long ratingStreamCode) {
		this.ratingStreamCode = ratingStreamCode;
	}
	
	@Column(name="RATING_STREAM")
	public String getRatingStream() {
		return ratingStream;
	}
	public void setRatingStream(String ratingStream) {
		this.ratingStream = ratingStream;
	}
	
	@Column(name="DEMO_POST_BUY_ID")
	public Long getDemoPostBuyId() {
		return demoPostBuyId;
	}
	public void setDemoPostBuyId(Long demoPostBuyId) {
		this.demoPostBuyId = demoPostBuyId;
	}
	
	@Column(name="DEMO_POST_BUY")
	public String getDemoPostBuy() {
		return demoPostBuy;
	}
	public void setDemoPostBuy(String demoPostBuy) {
		this.demoPostBuy = demoPostBuy;
	}
	
	@Column(name="EQUIV")
	public String getEquiv() {
		return equiv;
	}
	public void setEquiv(String equiv) {
		this.equiv = equiv;
	}
	
	@Column(name="HH_POST_BUY_ID")
	public Long getHhPostBuyId() {
		return hhPostBuyId;
	}
	public void setHhPostBuyId(Long hhPostBuyId) {
		this.hhPostBuyId = hhPostBuyId;
	}
	
	@Column(name="HH_POST_BUY")
	public String getHhPostBuy() {
		return hhPostBuy;
	}
	public void setHhPostBuy(String hhPostBuy) {
		this.hhPostBuy = hhPostBuy;
	}
	
	@Column(name="PRIMARY_DEMO")
	public String getPrimaryDemo() {
		return primaryDemo;
	}
	public void setPrimaryDemo(String primaryDemo) {
		this.primaryDemo = primaryDemo;
	}
	
	@Column(name="DIVISION_ID")
	public Long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	
	@Column(name="SUB_DIVISION_ID")
	public Long getSubDivisionId() {
		return subDivisionId;
	}
	public void setSubDivisionId(Long subDivisionId) {
		this.subDivisionId = subDivisionId;
	}
	
	@Column(name="PORTFOLIO_PLAN_ID")
	public Long getPortfolioPlanId() {
		return portfolioPlanId;
	}
	public void setPortfolioPlanId(Long portfolioPlanId) {
		this.portfolioPlanId = portfolioPlanId;
	}
	
	@Column(name="PRG_PLAN_ID")
	public Long getPrgPlanId() {
		return prgPlanId;
	}
	public void setPrgPlanId(Long prgPlanId) {
		this.prgPlanId = prgPlanId;
	}
	
	
	@Column(name="GUARANTEED_CODE")
	public String getGuaranteedCode() {
		return guaranteedCode;
	}
	public void setGuaranteedCode(String guaranteedCode) {
		this.guaranteedCode = guaranteedCode;
	}
	
	@Column(name="GUARANTEED")
	public String getGuaranteed() {
		return guaranteed;
	}
	public void setGuaranteed(String guaranteed) {
		this.guaranteed = guaranteed;
	}
	
	@Column(name="PLAN_APPROVAL_STATUS_DESC")
	public String getApprovalStatusDesc() {
		return approvalStatusDesc;
	}
	public void setApprovalStatusDesc(String approvalStatusDesc) {
		this.approvalStatusDesc = approvalStatusDesc;
	}
	
	
	
}
