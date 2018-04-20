package webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class RatingPK implements Serializable{
	private Long planId;
	private Long externalUsn;
	private Long targetGroupId;
	
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	public Long getExternalUsn() {
		return externalUsn;
	}
	public void setExternalUsn(Long externalUsn) {
		this.externalUsn = externalUsn;
	}

	public Long getTargetGroupId() {
		return targetGroupId;
	}
	public void setTargetGroupId(Long targetGroupId) {
		this.targetGroupId = targetGroupId;
	}
}