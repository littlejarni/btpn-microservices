package com.btpn.closingcustomer.controller;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.closingcustomer.soap.ClosingFeeSoapClient;
import com.btpn.logging.annotation.Logging;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonUtil;
import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ClosingFeeController {

	public static final String GET_CLOSING_FEE_ADDR = "getClosingFee";
	
	
	@Autowired
	ClosingFeeSoapClient closingFeeSoapClient;
	
	@RequestMapping(GET_CLOSING_FEE_ADDR)
	@Logging
	public String getClosingFee() throws JsonProcessingException, MalformedURLException, DSCALLFAULT_Exception, JAXBException {

		String fee = closingFeeSoapClient.getClosingFee();
		
		CommonResponse<String> response = new CommonResponse<String>(fee);
		
		ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
		return writer.writeValueAsString(response);
	}
}
