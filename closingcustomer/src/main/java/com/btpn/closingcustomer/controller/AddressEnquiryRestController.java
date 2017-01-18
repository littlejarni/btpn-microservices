package com.btpn.closingcustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.closingcustomer.soap.AddressInquirySOAPClient;
import com.btpn.logging.annotation.Logging;
import com.btpn.response.rest.CommonResponse;
import com.btpn.response.rest.CommonStatus;
import com.btpn.util.json.JsonUtil;
import com.btpn.ws.mdw.btpnfescustomerequation.AddressEnquiryResp;
import com.btpn.ws.mdw.btpnfescustomerequation.DataAaeResp;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class AddressEnquiryRestController {

	public static final String ADDRESS_INQUIRY_ADDR = "addressEnquiry";
	
	@Autowired
	AddressInquirySOAPClient addressInquirySOAP;
	
	@RequestMapping(ADDRESS_INQUIRY_ADDR)
	@Logging
	public String addressInquiry(@RequestParam(value="accountNumber", defaultValue=" ") String accountNumber) throws Exception {
	
		AddressEnquiryResp addressEnquiryResponse = addressInquirySOAP.getAddressEnquiry(accountNumber);
		
		DataAaeResp dataAEResp = addressEnquiryResponse.getDataAaeResp();
		
		CommonStatus comstat = null;
		
		CommonResponse<DataAaeResp> response;
		
		if(addressEnquiryResponse.getGenericResponseDoc().getResponseCode().equalsIgnoreCase("00")){
			response = new CommonResponse<DataAaeResp>(dataAEResp);
		} else {
			comstat = new CommonStatus(addressEnquiryResponse.getGenericResponseDoc().getResponseCode(), addressEnquiryResponse.getGenericResponseDoc().getResponseDesc());
			response = new CommonResponse<DataAaeResp>(comstat);
		}
		
		
		ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
		return writer.writeValueAsString(response);
	}
	
}
