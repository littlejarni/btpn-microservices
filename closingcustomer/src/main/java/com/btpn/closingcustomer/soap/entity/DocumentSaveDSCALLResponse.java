package com.btpn.closingcustomer.soap.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentSaveDSCALLResponse {
	@XmlElement(name = "Status")
	String status;
	@XmlElement(name = "ErrorMessage")
	String errorMessage;
	@XmlElement(name = "RetCode")
	String retCode;
	@XmlElement(name = "DOCUMENTID")
	String documentId;

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

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

}
