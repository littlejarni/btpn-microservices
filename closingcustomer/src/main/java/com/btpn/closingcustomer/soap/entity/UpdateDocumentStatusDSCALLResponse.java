package com.btpn.closingcustomer.soap.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateDocumentStatusDSCALLResponse {

	@XmlRootElement(name = "Result")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Result {
		@XmlElement(name = "DOCUMENTID")
		String documentId;

		public String getDocumentId() {
			return documentId;
		}

		public void setDocumentId(String documentId) {
			this.documentId = documentId;
		}

	}

	@XmlElement(name = "Status")
	String status;
	@XmlElement(name = "ErrorMessage")
	String errorMessage;
	@XmlElement(name = "RetCode")
	String retCode;
	@XmlElement(name = "Result")
	String result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRetCode() {
		return retCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
}
