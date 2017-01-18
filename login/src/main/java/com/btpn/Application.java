package com.btpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.btpn.applicationconfig.annotation.EnableLoadAppConfig;
import com.btpn.auth.annotation.EnableCustomPublisherAuthentication;
import com.btpn.auth.annotation.EnableUserAuditEntity;
import com.btpn.common.annotation.EnableCommonPageUtil;
import com.btpn.common.annotation.EnableRegisterRequestIdContext;
import com.btpn.logging.annotation.EnableLogging;
import com.btpn.response.annotation.EnableLoadResponse;
import com.btpn.runningnumber.annotation.EnableRunningNumber;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.btpn.persistence")
@EnableJpaRepositories("com.btpn.persistence")
@ComponentScan({"com.btpn.login.controller", "com.btpn.usermanagement.controller"})
@Import({SpringConfig.class, DaoSpringConfig.class})
@EnableLogging
@EnableLoadAppConfig
@EnableLoadResponse
@EnableCustomPublisherAuthentication
@EnableRunningNumber
@EnableUserAuditEntity
@EnableRegisterRequestIdContext
@EnableCommonPageUtil
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
