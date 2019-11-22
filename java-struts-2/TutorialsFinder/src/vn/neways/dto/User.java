package vn.neways.dto;

import org.apache.commons.lang3.StringUtils;

public class User {
	private String userId;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean auth() {
		return StringUtils.isNotEmpty(this.userId) && this.userId.equals(this.password);
	}

}
