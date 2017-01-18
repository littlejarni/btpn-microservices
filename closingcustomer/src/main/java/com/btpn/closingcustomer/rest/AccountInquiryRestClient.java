package com.btpn.closingcustomer.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.btpn.closingcustomer.rest.entity.AccountInquiryRestRequest;
import com.btpn.closingcustomer.rest.entity.AccountInquiryRestResponse;
import com.btpn.closingcustomer.rest.entity.DataAERequest;
import com.btpn.wscall.CommonParamGenerator;
import com.btpn.wscall.entity.CommonParam;

public class AccountInquiryRestClient {
	
//	public static void main(String[] args) {
//		AccountInquiryRestClient client = new AccountInquiryRestClient();
//		client.callAccountInquiry("");
//	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CommonParamGenerator commonGen;
	
	public AccountInquiryRestResponse callAccountInquiry(String accountNo) throws Exception {		
		AccountInquiryRestRequest req = new AccountInquiryRestRequest();
		DataAERequest aeReq = new DataAERequest();
		aeReq.setAccountNumber(accountNo);
		aeReq.setUserID("ROY");
		req.setDataAERequest(aeReq);
		CommonParam common = commonGen.generateCommonParam();
		common.setProcessingCode("640039");
		req.setCommonParam(common);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("RequestAE", req);
		
		AccountInquiryRestResponse response = restTemplate.postForObject("http://appmdwdev03.dev.corp.btpn.co.id:5555/fes/account/accountEnquiry", map,  AccountInquiryRestResponse.class);

		return response;
	}
}
