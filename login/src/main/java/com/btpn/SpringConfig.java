package com.btpn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.login.engine.JWTAuthenticationEngine;
import com.btpn.login.engine.JWTAuthenticationEngineImpl;
import com.btpn.login.engine.StandardAuthenticationEngine;
import com.btpn.login.engine.StandardAuthenticationEngineDBImpl;
import com.btpn.login.engine.StandardAuthenticationEngineLDAPImpl;

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Bean
	public JWTAuthenticationEngine jwtAuthenticationEngine() {
		return new JWTAuthenticationEngineImpl();
	}
	
//	@Bean
//	public StandardAuthenticationEngine stdAuthEngine(ApplicationConfig appConfig) {
//		String authEngine = appConfig.getConfig(LoginConstant.AUTHENTICATION_ENGINE_KEY);
//		if (LoginConstant.AUTHENTICATION_ENGINE_LDAP.equals(authEngine))
//			return new StandardAuthenticationEngineLDAPImpl();
//		else
//			return new StandardAuthenticationEngineDBImpl();
//	}

	@Bean
	public StandardAuthenticationEngine standardAuthenticationEngineLDAPImpl(ApplicationConfig appConfig) {
		return new StandardAuthenticationEngineLDAPImpl();
	}

	@Bean
	public StandardAuthenticationEngine standardAuthenticationEngineDBImpl(ApplicationConfig appConfig) {
		return new StandardAuthenticationEngineDBImpl();
	}
	
}
