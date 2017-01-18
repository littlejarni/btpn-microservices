package com.btpn.response.rest;

import com.btpn.response.CommonResponseConstant;

public class CommonResponse<T> {
	CommonStatus responseStatus;
	String requestId;
	T data;

	public CommonResponse() {
		responseStatus = new CommonStatus(CommonResponseConstant.DEFAULT_SUCCESS_CODE, CommonResponseConstant.DEFAULT_SUCCESS_DESC);
	}

	public CommonResponse(CommonStatus status) {
		this.responseStatus = status;
	}

	public CommonResponse(T data) {
		this();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public String getRequestId() {
		return requestId;
	}

	public CommonStatus getResponseStatus() {
		return responseStatus;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setResponseStatus(CommonStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
}
