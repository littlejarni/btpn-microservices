package com.btpn.closingcustomer.soap.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateTasklistStatusDSCALLResponse {
	@XmlElement(name = "Status")
	String status;
	@XmlElement(name = "ErrorDescription")
	String errorDescription;
	@XmlElement(name = "Result")
	String result;

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
