package webapp.domain.parameter;

public abstract class AbstractProcedureParameter {
	private Long session_id_;
	private Long user_id_;
	/**
	 * @return the session_id_
	 */
	public Long getSession_id_() {
		return session_id_;
	}
	/**
	 * @param session_id_ the session_id_ to set
	 */
	public void setSession_id_(Long session_id_) {
		this.session_id_ = session_id_;
	}
	/**
	 * @return the user_id_
	 */
	public Long getUser_id_() {
		return user_id_;
	}
	/**
	 * @param user_id_ the user_id_ to set
	 */
	public void setUser_id_(Long user_id_) {
		this.user_id_ = user_id_;
	}

}
