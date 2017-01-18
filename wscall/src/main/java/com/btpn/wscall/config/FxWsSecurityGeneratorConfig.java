package com.btpn.wscall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.wscall.soap.FxWsSecurityGenerator;

@Configuration
public class FxWsSecurityGeneratorConfig {

	@Autowired
	ApplicationConfig appConfig; 
	
	@Bean
	public FxWsSecurityGenerator fxWsSecurityGenerator() {
		return new FxWsSecurityGenerator();
	}
}
