package com.btpn.response.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.persistence.service.responsemapping.ResponseMappingDaoService;
import com.btpn.persistence.service.responsemapping.ResponseMappingDaoServiceImpl;
import com.btpn.response.CommonResponseGenerator;
import com.btpn.response.ResponseMapping;
import com.btpn.response.ResponseMappingDBImpl;
import com.btpn.response.filter.GlobalErrorHandler;

@Configuration
public class LoadResponseConfig {
	@Bean
	public ResponseMappingDaoService responseMappingDaoService() {
		return new ResponseMappingDaoServiceImpl();
	}

	@Bean
	public ResponseMapping responseMapping( ) {
		return new ResponseMappingDBImpl(responseMappingDaoService());
	}

	@Bean
	public CommonResponseGenerator commonResponseGenerator() {
		return new CommonResponseGenerator();
	}

	@Bean
	public GlobalErrorHandler globalErrorHandler( ) {
		return new GlobalErrorHandler();
	}

}
