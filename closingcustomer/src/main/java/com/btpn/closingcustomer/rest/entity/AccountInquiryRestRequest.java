package com.btpn.closingcustomer.rest.entity;

import com.btpn.wscall.entity.CommonParam;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInquiryRestRequest {

	DataAERequest dataAERequest;
	@JsonProperty("CommonParam")
	CommonParam commonParam;

	public CommonParam getCommonParam() {
		return commonParam;
	}

	public DataAERequest getDataAERequest() {
		return dataAERequest;
	}

	public void setCommonParam(CommonParam commonParam) {
		this.commonParam = commonParam;
	}

	public void setDataAERequest(DataAERequest dataAERequest) {
		this.dataAERequest = dataAERequest;
	}
}
