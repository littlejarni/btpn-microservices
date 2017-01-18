package com.btpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.btpn.applicationconfig.annotation.EnableLoadAppConfig;
import com.btpn.common.annotation.EnableRegisterRequestIdContext;
import com.btpn.logging.annotation.EnableLogging;
import com.btpn.response.annotation.EnableLoadResponse;
import com.btpn.runningnumber.annotation.EnableRunningNumber;
import com.btpn.wscall.annotation.EnableCommonParamGenerator;
import com.btpn.wscall.annotation.EnableFxWsSecurityGenerator;
import com.btpn.wscall.annotation.EnableRestWSCall;
import com.btpn.wscall.rest.auth.annotation.EnableCustomConsumerAuthentication;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.btpn.persistence")
@EnableJpaRepositories("com.btpn.persistence")
@ComponentScan("com.btpn.closingcustomer.controller")
@Import({SpringConfig.class, DaoSpringConfig.class})
@EnableLogging
@EnableLoadAppConfig
@EnableLoadResponse
@EnableCustomConsumerAuthentication
@EnableRunningNumber
@EnableRestWSCall
@EnableCommonParamGenerator
@EnableFxWsSecurityGenerator
@EnableRegisterRequestIdContext
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
