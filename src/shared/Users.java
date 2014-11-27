package shared;

import java.io.Serializable;

public class Users implements Serializable{

	//Declaration of attributes
	private final long serialVersionUID = 2L;
	private String email;
	private String password;
	private boolean active;
	private String overallID;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
}