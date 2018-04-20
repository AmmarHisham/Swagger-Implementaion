package webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(schema = "nbc_cust", name = "MVW_MS_UNIT_WK")
public class WorkingUnit extends Unit implements Serializable {
	
	private Long planId;
	private Long externalUsn;
	private Long internalUsn;
	private String spotDate;
	private String spotTime;
	private Long brandId;
	private String brandName;
	private Long commSubTypeId;
	private String commSubTypeName;
	private Long commTypeId;
	private String commTypeName;
	private Long lineClassCode;
	private String lineClassName;
	private String logType;
	private Long pitchedRate;
	private String iscii;
	private Long pgmEventId;
	private Long commVersionId;
	private String pgmName;
	private String prodCode;
	private Long rcPrice;
	private Long salesUnitId;
	private String salesUnitName;
	private Long spotPlanStatusCode;
	private String spotPlanStatus;
	private String unitDuration;
	private String dow;
	private String weekOfDate;
	private Long standRate;
	private String spotQtr;
	private Long propertyId;
	private String propertyName;
	
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
	
	@Column(name="INTERNAL_USN")
	public Long getInternalUsn() {
		return internalUsn;
	}
	public void setInternalUsn(Long internalUsn) {
		this.internalUsn = internalUsn;
	}
	
	@Column(name="SPOT_DATE")
	public String getSpotDate() {
		return spotDate;
	}
	public void setSpotDate(String spotDate) {
		this.spotDate = spotDate;
	}
	
	@Column(name="SPOT_TIME")
	public String getSpotTime() {
		return spotTime;
	}
	public void setSpotTime(String spotTime) {
		this.spotTime = spotTime;
	}
	
	@Column(name="BRAND_ID")
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	@Column(name="BRAND_NAME")
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	@Column(name="COMMERCIAL_SUB_TYPE_ID")
	public Long getCommSubTypeId() {
		return commSubTypeId;
	}
	public void setCommSubTypeId(Long commSubTypeId) {
		this.commSubTypeId = commSubTypeId;
	}
	
	@Column(name="COMMERCIAL_SUB_TYPE_NAME")
	public String getCommSubTypeName() {
		return commSubTypeName;
	}
	public void setCommSubTypeName(String commSubTypeName) {
		this.commSubTypeName = commSubTypeName;
	}
	
	@Column(name="COMMERCIAL_TYPE_ID")
	public Long getCommTypeId() {
		return commTypeId;
	}
	public void setCommTypeId(Long commTypeId) {
		this.commTypeId = commTypeId;
	}
	
	@Column(name="COMMERCIAL_TYPE_NAME")
	public String getCommTypeName() {
		return commTypeName;
	}
	public void setCommTypeName(String commTypeName) {
		this.commTypeName = commTypeName;
	}
	
	@Column(name="LINE_CLASS_CODE")
	public Long getLineClassCode() {
		return lineClassCode;
	}
	public void setLineClassCode(Long lineClassCode) {
		this.lineClassCode = lineClassCode;
	}
	
	@Column(name="LINE_CLASS_NAME")
	public String getLineClassName() {
		return lineClassName;
	}
	public void setLineClassName(String lineClassName) {
		this.lineClassName = lineClassName;
	}
	
	@Column(name="LOG_TYPE")
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	@Column(name="PITCHED_RATE")
	public Long getPitchedRate() {
		return pitchedRate;
	}
	public void setPitchedRate(Long pitchedRate) {
		this.pitchedRate = pitchedRate;
	}
	
	@Column(name="ISCII")
	public String getIscii() {
		return iscii;
	}
	public void setIscii(String iscii) {
		this.iscii = iscii;
	}
	
	@Column(name="PROGRAM_EVENT_ID")
	public Long getPgmEventId() {
		return pgmEventId;
	}
	public void setPgmEventId(Long pgmEventId) {
		this.pgmEventId = pgmEventId;
	}
	
	@Column(name="COMM_VERSION_ID")
	public Long getCommVersionId() {
		return commVersionId;
	}
	public void setCommVersionId(Long commVersionId) {
		this.commVersionId = commVersionId;
	}
	
	@Column(name="PROGRAM_NAME")
	public String getPgmName() {
		return pgmName;
	}
	public void setPgmName(String pgmName) {
		this.pgmName = pgmName;
	}
	
	@Column(name="PRODUCT_CODE")
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	@Column(name="RATECARD_PRICE")
	public Long getRcPrice() {
		return rcPrice;
	}
	public void setRcPrice(Long rcPrice) {
		this.rcPrice = rcPrice;
	}
	
	@Column(name="SALES_UNIT_ID")
	public Long getSalesUnitId() {
		return salesUnitId;
	}
	public void setSalesUnitId(Long salesUnitId) {
		this.salesUnitId = salesUnitId;
	}
	
	@Column(name="SALES_UNIT_NAME")
	public String getSalesUnitName() {
		return salesUnitName;
	}
	public void setSalesUnitName(String salesUnitName) {
		this.salesUnitName = salesUnitName;
	}
	
	@Column(name="SPOT_PLAN_STATUS_CODE")
	public Long getSpotPlanStatusCode() {
		return spotPlanStatusCode;
	}
	public void setSpotPlanStatusCode(Long spotPlanStatusCode) {
		this.spotPlanStatusCode = spotPlanStatusCode;
	}
	
	@Column(name="SPOT_PLAN_STATUS")
	public String getSpotPlanStatus() {
		return spotPlanStatus;
	}
	public void setSpotPlanStatus(String spotPlanStatus) {
		this.spotPlanStatus = spotPlanStatus;
	}
	
	@Column(name="UNIT_DURATION")
	public String getUnitDuration() {
		return unitDuration;
	}
	public void setUnitDuration(String unitDuration) {
		this.unitDuration = unitDuration;
	}
	
	@Column(name="DOW")
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}
	
	@Column(name="WEEK_OF_DATE")
	public String getWeekOfDate() {
		return weekOfDate;
	}
	public void setWeekOfDate(String weekOfDate) {
		this.weekOfDate = weekOfDate;
	}
	
	@Column(name="STANDARDIZED_RATE")
	public Long getStandRate() {
		return standRate;
	}
	public void setStandRate(Long standRate) {
		this.standRate = standRate;
	}
	
	@Column(name="SPOT_QUARTER")
	public String getSpotQtr() {
		return spotQtr;
	}
	public void setSpotQtr(String spotQtr) {
		this.spotQtr = spotQtr;
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
	
}