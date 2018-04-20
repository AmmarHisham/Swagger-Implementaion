package webapp.domain.parameter;

public abstract class AbstractOracleParameter {
	
	private String procName;
	public String getProcName() {
		return procName;
	}

	/**
	 * @param procName the procName to set
	 */
	public void setProcName(String procName) {
		this.procName = procName;
	}

}
