package com.btpn.closingcustomer.soap;

import com.btpn.ws.mdw.btpnfescustomerequation.AddressEnquiryResp;

public interface AddressInquirySOAPClient {

	public AddressEnquiryResp getAddressEnquiry(String accountNumber) throws Exception;
	
}
