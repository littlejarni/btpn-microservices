package com.btpn.closingcustomer.soap;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.persistence.service.runningnumber.RunningNumberService;
import com.btpn.ws.mdw.btpnfescustomerequation.AddressEnquiryReq;
import com.btpn.ws.mdw.btpnfescustomerequation.AddressEnquiryResp;
import com.btpn.ws.mdw.btpnfescustomerequation.BtpnFesCustomerEquationPortType;
import com.btpn.ws.mdw.btpnfescustomerequation.ComBtpnFesWsProviderBtpnFesCustomerEquation;
import com.btpn.ws.mdw.btpnfescustomerequation.CommonParam2;
import com.btpn.ws.mdw.btpnfescustomerequation.DataAaeReq;
import com.btpn.ws.mdw.btpnfescustomerequation.ObjectFactory;
import com.btpn.wscall.CommonParamGenerator;

public class AddressInquirySOAPClientImpl implements AddressInquirySOAPClient {

	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	CommonParamGenerator commonParamGen;
	
	@Autowired
	RunningNumberService runningNumberService;
	
	@Override
	public AddressEnquiryResp getAddressEnquiry(String accountNumber) throws Exception  {
		
		//get ENDPOINT ADDRESS
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.GET_ADDRESS_ENQUIRY_ENDPOINT_KEY);
		
		ObjectFactory objectFactory = new ObjectFactory();
		
		String refNo = String.valueOf(runningNumberService.getRunningNumber());
		
		CommonParam2 commPar2 = objectFactory.createCommonParam2();
		commPar2.setProcessingCode(objectFactory.createCommonParam2ProcessingCode("640009"));
		commPar2.setChannelId(objectFactory.createCommonParam2ChannelId("FES"));
		commPar2.setChannelType(objectFactory.createCommonParam2ChannelType("FES"));
		commPar2.setNode(objectFactory.createCommonParam2Node("FES"));
		commPar2.setReferenceNo(objectFactory.createCommonParam2ReferenceNo(refNo));
		commPar2.setRequestId(objectFactory.createCommonParam2RequestId(refNo));

		DataAaeReq dae = new DataAaeReq();
		dae.setAccountNumber(accountNumber);
		dae.setOperator("FESE");
		dae.setCif("");
		dae.setAddressType("");
		
		//prepare Request
		AddressEnquiryReq req = objectFactory.createAddressEnquiryReq();
		req.setCommonParam2(commPar2);
		req.setDataAaeReq(dae);
		
		ComBtpnFesWsProviderBtpnFesCustomerEquation service = new ComBtpnFesWsProviderBtpnFesCustomerEquation(new URL(endPoint));
		BtpnFesCustomerEquationPortType port = service.getComBtpnFesWsProviderBtpnFesCustomerEquationPort();
		
		AddressEnquiryResp response = port.addressEnquiry(req);
		
		return response;
		
	}

}
