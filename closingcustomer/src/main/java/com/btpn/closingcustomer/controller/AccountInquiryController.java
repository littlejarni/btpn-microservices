package com.btpn.closingcustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.closingcustomer.rest.AccountInquiryRestClient;
import com.btpn.closingcustomer.rest.entity.AccountInquiryRestResponse;
import com.btpn.logging.annotation.Logging;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonUtil;
import com.btpn.wscall.CommonParamGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AccountInquiryController {

	public static final String ACCOUNT_INQUIRY_ADDR = "accountInquiry";
	
	@Autowired
	AccountInquiryRestClient accInq;
	
	@RequestMapping(ACCOUNT_INQUIRY_ADDR)
	@Logging
	public String accountInquiry(@RequestParam(value="accountNumber", defaultValue=" ") String accountNumber) throws Exception {
		AccountInquiryRestResponse response = accInq.callAccountInquiry(accountNumber);
		CommonResponse<AccountInquiryRestResponse> ret = new CommonResponse<AccountInquiryRestResponse>(response);
		ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
		return writer.writeValueAsString(ret);
	}
	
	@Autowired
	CommonParamGenerator commonParam;
	
	@RequestMapping("commonParam")
	@Logging
	public String testCommonParam() throws Exception {
		ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
		return writer.writeValueAsString(commonParam.generateCommonParam());
	}
	
}
