package com.btpn.closingcustomer.rest.entity;

public class DataAERequest {

	String userID;
	String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
