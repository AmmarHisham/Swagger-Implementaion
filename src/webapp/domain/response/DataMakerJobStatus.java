package webapp.domain.response;

import java.util.Collection;

public class DataMakerJobStatus {
		
	private String jobId;
	private String jobStatus;	
	private String details;
	private String jobEndDateTime;
	private String jobStartDateTime;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the jobEndDateTime
	 */
	public String getJobEndDateTime() {
		return jobEndDateTime;
	}
	/**
	 * @param jobEndDateTime the jobEndDateTime to set
	 */
	public void setJobEndDateTime(String jobEndDateTime) {
		this.jobEndDateTime = jobEndDateTime;
	}
	/**
	 * @return the jobStartDateTime
	 */
	public String getJobStartDateTime() {
		return jobStartDateTime;
	}
	/**
	 * @param jobStartDateTime the jobStartDateTime to set
	 */
	public void setJobStartDateTime(String jobStartDateTime) {
		this.jobStartDateTime = jobStartDateTime;
	}
	/**
	 * @return the jobStatus
	 */
	public String getJobStatus() {
		return jobStatus;
	}
	/**
	 * @param jobStatus the jobStatus to set
	 */
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	
	
}
