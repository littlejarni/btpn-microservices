package com.btpn.closingcustomer.rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInquiryRestResponse {

	

	@JsonProperty("GenericResponseDoc")
	GenericResponseDoc genericResponseDoc;
	DataAERestResponse dataAEResponse;

	public DataAERestResponse getDataAEResponse() {
		return dataAEResponse;
	}

	public GenericResponseDoc getGenericResponseDoc() {
		return genericResponseDoc;
	}

	public void setDataAEResponse(DataAERestResponse dataAEResponse) {
		this.dataAEResponse = dataAEResponse;
	}

	public void setGenericResponseDoc(GenericResponseDoc genericResponseDoc) {
		this.genericResponseDoc = genericResponseDoc;
	}

}
