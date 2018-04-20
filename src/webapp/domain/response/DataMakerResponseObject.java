package webapp.domain.response;

import java.util.List;

public class DataMakerResponseObject {

	private String payloadId;
	private String payloadStatus;
	private String payloadStartDateTime;
	private String payloadEndDateTime;
	private String scheduleId;
	private List<DataMakerJobStatus> jobStatuses;
	/**
	 * @return the payloadStatus
	 */
	public String getPayloadStatus() {
		return payloadStatus;
	}
	/**
	 * @param payloadStatus the payloadStatus to set
	 */
	public void setPayloadStatus(String payloadStatus) {
		this.payloadStatus = payloadStatus;
	}
	/**
	 * @return the payloadStartDateTime
	 */
	public String getPayloadStartDateTime() {
		return payloadStartDateTime;
	}
	/**
	 * @param payloadStartDateTime the payloadStartDateTime to set
	 */
	public void setPayloadStartDateTime(String payloadStartDateTime) {
		this.payloadStartDateTime = payloadStartDateTime;
	}
	/**
	 * @return the payloadEndDateTime
	 */
	public String getPayloadEndDateTime() {
		return payloadEndDateTime;
	}
	/**
	 * @param payloadEndDateTime the payloadEndDateTime to set
	 */
	public void setPayloadEndDateTime(String payloadEndDateTime) {
		this.payloadEndDateTime = payloadEndDateTime;
	}
	/**
	 * @return the scheduleId
	 */
	public String getScheduleId() {
		return scheduleId;
	}
	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	
	/**
	 * @return the payloadId
	 */
	public String getPayloadId() {
		return payloadId;
	}
	/**
	 * @param payloadId the payloadId to set
	 */
	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}
	/**
	 * @return the jobStatuses
	 */
	public List<DataMakerJobStatus> getJobStatuses() {
		return jobStatuses;
	}
	/**
	 * @param jobStatuses the jobStatuses to set
	 */
	public void setJobStatuses(List<DataMakerJobStatus> jobStatuses) {
		this.jobStatuses = jobStatuses;
	}
	

}
