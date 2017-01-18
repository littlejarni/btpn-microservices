package com.btpn.closingcustomer.soap.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class StartTasklistDSCALLResponse {
	@XmlElement(name = "Status")
	String status;
	@XmlElement(name = "ErrorDescription")
	String errorDescription;
	@XmlElement(name = "OBJECTID")
	String objectId;
	@XmlElement(name = "ASSIGNTYPE")
	String assignType;
	@XmlElement(name = "ACCOUNTNUMBER")
	String accountNumber;
	@XmlElement(name = "OBJECTTYPE")
	String objectType;
	@XmlElement(name = "PROJECTID")
	String projectId;
	@XmlElement(name = "PROCESSID")
	String processId;
	@XmlElement(name = "ASSIGNOBJECT")
	String assignObject;
	@XmlElement(name = "Result")
	String result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getAssignType() {
		return assignType;
	}

	public void setAssignType(String assignType) {
		this.assignType = assignType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getAssignObject() {
		return assignObject;
	}

	public void setAssignObject(String assignObject) {
		this.assignObject = assignObject;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
