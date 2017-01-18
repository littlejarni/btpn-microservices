package com.btpn.closingcustomer.soap;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;

public interface ClosingFeeSoapClient {

	public String getClosingFee() throws MalformedURLException, DSCALLFAULT_Exception, JAXBException;
	
}
