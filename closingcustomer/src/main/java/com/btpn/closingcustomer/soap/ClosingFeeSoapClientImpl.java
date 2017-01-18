package com.btpn.closingcustomer.soap;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.closingcustomer.soap.entity.ClosingFeeDSCALLResponse;
import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;
import com.btpn.ws.diasoft.frontws2.FRONTWS2PORTTYPE;
import com.btpn.ws.diasoft.frontws2.FRONTWS2SERVICE;
import com.btpn.wscall.soap.FxWsSecurityGenerator;

public class ClosingFeeSoapClientImpl implements ClosingFeeSoapClient {

	public static final String COMMAND_TEXT = "bankProductParamValueGetListByParams";
	public static final String COMMAND_DATA_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<BODY version=\"2.11\">"
			+ "<PARAMID type=\"java.lang.String\">%s</PARAMID>"
			+ "</BODY>";

	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	FxWsSecurityGenerator fxWsSecurityGenerator;

	@Override
	public String getClosingFee() throws MalformedURLException, DSCALLFAULT_Exception, JAXBException {

		String endPoint = appConfig.getConfig(ClosingCustomerConstant.GET_CLOSINGFEE_ENDPOINT_KEY);
		FRONTWS2SERVICE service = new FRONTWS2SERVICE(new URL(endPoint));
		FRONTWS2PORTTYPE servicePort = service.getFRONTWS2PORT();

		BindingProvider bindingProvider = (BindingProvider) servicePort;
		@SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(fxWsSecurityGenerator.generateHeaderSOAPHandler());
		bindingProvider.getBinding().setHandlerChain(handlerChain);

		String paramId = appConfig.getConfig(ClosingCustomerConstant.GET_CLOSINGFEE_PARAMID_KEY);
		String commandData = String.format(COMMAND_DATA_TEMPLATE, paramId);
		String wsResponse = servicePort.dscall(COMMAND_TEXT, commandData);

		JAXBContext context = JAXBContext.newInstance(ClosingFeeDSCALLResponse.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ClosingFeeDSCALLResponse resp = (ClosingFeeDSCALLResponse) unmarshaller.unmarshal(new StringReader(wsResponse));
		return resp.getResult().getLstItem().get(0).getValue1();
	}
}
