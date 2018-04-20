package webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class UnitPK implements Serializable{
	private Long planId;
	private Long externalUsn;
	
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

}