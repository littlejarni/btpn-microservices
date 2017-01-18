package com.btpn.response;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.common.CommonConstant;
import com.btpn.common.context.RequestContext;
import com.btpn.response.rest.CommonPaging;
import com.btpn.response.rest.CommonResponse;
import com.btpn.response.rest.CommonResponsePaging;
import com.btpn.response.rest.CommonStatus;

public class CommonResponseGenerator {

	@Autowired
	RequestContext requestContext;

	@Autowired
	ResponseMapping responseMapping;

	public <T> CommonResponse<T> generateCommonResponse(Class<T> clz) {
		CommonResponse<T> resp = new CommonResponse<T>();
		resp.setRequestId((String) requestContext.get(CommonConstant.REQUEST_ID_CONTEXT));
		return resp;
	}

	public <T> CommonResponse<T> generateCommonResponse(String responseCode, String responseDesc, Class<T> clz) {
		CommonResponse<T> resp = generateCommonResponse(clz);
		CommonStatus stat = responseMapping.generateCommonStatus(responseCode, responseDesc);
		resp.setResponseStatus(stat);
		return resp;
	}

	public <T> CommonResponse<T> generateCommonResponse(T t) {
		CommonResponse<T> resp = new CommonResponse<T>();
		resp.setRequestId((String) requestContext.get(CommonConstant.REQUEST_ID_CONTEXT));
		resp.setData(t);
		return resp;
	}

	public <T> CommonResponsePaging<T> generateCommonResponsePaging(Class<T> clz) {
		CommonResponsePaging<T> resp = new CommonResponsePaging<T>();
		resp.setRequestId((String) requestContext.get(CommonConstant.REQUEST_ID_CONTEXT));
		return resp;
	}

	public <T> CommonResponsePaging<T> generateCommonResponsePaging(String responseCode, String responseDesc, Class<T> clz) {
		CommonResponsePaging<T> resp = generateCommonResponsePaging(clz);
		CommonStatus stat = responseMapping.generateCommonStatus(responseCode, responseDesc);
		resp.setResponseStatus(stat);
		return resp;
	}

	public <T> CommonResponsePaging<T> generateCommonResponsePaging(CommonPaging<T> t) {
		CommonResponsePaging<T> resp = new CommonResponsePaging<T>();
		resp.setRequestId((String) requestContext.get(CommonConstant.REQUEST_ID_CONTEXT));
		resp.setPaging(t);
		return resp;
	}
}
