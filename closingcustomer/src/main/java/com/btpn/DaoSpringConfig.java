package com.btpn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.persistence.service.closingcustomer.ClosingApprovalDaoService;
import com.btpn.persistence.service.closingcustomer.ClosingApprovalDaoServiceImpl;

@Configuration
public class DaoSpringConfig {

	@Bean
	public ClosingApprovalDaoService closingApprovalDaoService() {
		return new ClosingApprovalDaoServiceImpl();
	}
}
