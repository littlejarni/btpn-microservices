package com.btpn.applicationconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.applicationconfig.ApplicationConfigDBImpl;
import com.btpn.persistence.service.applicationconfig.ApplicationConfigDaoService;
import com.btpn.persistence.service.applicationconfig.ApplicationConfigDaoServiceImpl;

@Configuration
public class LoadAppConfigurationConfig {

	@Bean
	public ApplicationConfigDaoService applicationConfigDaoService() {
		return new ApplicationConfigDaoServiceImpl();
	}
	
	@Bean
	public ApplicationConfig applicationConfig( ) {
		return new ApplicationConfigDBImpl(applicationConfigDaoService());
	}

}
