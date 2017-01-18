package com.btpn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.btpn.auth.filter.AuthenticationInterceptor;
import com.btpn.auth.filter.RegisterAuthenticationContextInterceptor;

@Configuration
public class BaseAuthenticationConfig extends WebMvcConfigurerAdapter {

	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	@Bean
	public RegisterAuthenticationContextInterceptor registerAuthenticationContextInterceptor() {
		return new RegisterAuthenticationContextInterceptor();
	}
		
}
