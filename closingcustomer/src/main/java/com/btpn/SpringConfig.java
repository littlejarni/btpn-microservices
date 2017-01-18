package com.btpn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.closingcustomer.rest.AccountInquiryRestClient;
import com.btpn.closingcustomer.soap.CloseAccountSoapClient;
import com.btpn.closingcustomer.soap.CloseAccountSoapClientImpl;
import com.btpn.closingcustomer.soap.AddressInquirySOAPClient;
import com.btpn.closingcustomer.soap.AddressInquirySOAPClientImpl;
import com.btpn.closingcustomer.soap.ClosingFeeSoapClient;
import com.btpn.closingcustomer.soap.ClosingFeeSoapClientImpl;
import com.btpn.closingcustomer.soap.TasklistSoapClient;
import com.btpn.closingcustomer.soap.TasklistSoapClientImpl;

@Configuration
public class SpringConfig {

	@Bean
	public AccountInquiryRestClient accountInquiryRestClient() {
		return new AccountInquiryRestClient();
	}

	@Bean
	public ClosingFeeSoapClient closingFeeSoapClient() {
		return new ClosingFeeSoapClientImpl();
	}

	@Bean
	public AddressInquirySOAPClient addressInquirySOAPClient(){
		return new AddressInquirySOAPClientImpl();
	}
	
	@Bean
	public TasklistSoapClient tasklistSoapClient() {
		return new TasklistSoapClientImpl();
	}

	@Bean
	public CloseAccountSoapClient closeAccountSoapClient() {
		return new CloseAccountSoapClientImpl();
	}
}
