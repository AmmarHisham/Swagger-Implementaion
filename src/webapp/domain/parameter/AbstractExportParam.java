package webapp.domain.parameter;

public abstract class AbstractExportParam {
	
	/*public AbstractExportParam(AbstractOracleParameter oracleParams, Long userId, String loadType) {
		super();
		this.oracleParams = oracleParams;
		this.userId = userId;
		this.loadType = loadType;
	}*/

	private AbstractOracleParameter oracleParams;
	private Long userId;
	private String loadType; 
	private Long tibcoJobId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the oracleParams
	 */
	public AbstractOracleParameter getOracleParams() {
		return oracleParams;
	}
	/**
	 * @param oracleParams the oracleParams to set
	 */
	public void setOracleParams(AbstractOracleParameter oracleParams) {
		this.oracleParams = oracleParams;
	}
	/**
	 * @return the loadType
	 */
	public String getLoadType() {
		return loadType;
	}
	/**
	 * @param loadType the loadType to set
	 */
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	/**
	 * @return the tibcoJobId
	 */
	public Long getTibcoJobId() {
		return tibcoJobId;
	}
	/**
	 * @param tibcoJobId the tibcoJobId to set
	 */
	public void setTibcoJobId(Long tibcoJobId) {
		this.tibcoJobId = tibcoJobId;
	}
		

}
