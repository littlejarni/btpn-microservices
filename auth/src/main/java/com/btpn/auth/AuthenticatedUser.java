package com.btpn.auth;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class AuthenticatedUser implements Serializable {
	String userName;
	String name;
	String authenticatedMethod;

	String sessionId;
	
	String userId;
	String branch;
	String userRole;
	String spvRole;

	List<String> services;

	public String getAuthenticatedMethod() {
		return authenticatedMethod;
	}

	public String getBranch() {
		return branch;
	}

	public String getName() {
		return name;
	}

	public List<String> getServices() {
		return services;
	}

	public String getSpvRole() {
		return spvRole;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setAuthenticatedMethod(String authenticatedMethod) {
		this.authenticatedMethod = authenticatedMethod;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public void setSpvRole(String spvRole) {
		this.spvRole = spvRole;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
