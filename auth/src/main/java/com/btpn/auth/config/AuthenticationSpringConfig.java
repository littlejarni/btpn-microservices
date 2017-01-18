package com.btpn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.btpn.auth.session.SessionPublisher;
import com.btpn.auth.session.SessionPublisherSpringImpl;



@Configuration
public class AuthenticationSpringConfig extends BaseAuthenticationConfig {

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(registerAuthenticationContextInterceptor());
		registry.addInterceptor(authenticationInterceptor());
	}
	
	@Bean
	public SessionPublisher sessionPublisher() {
		return new SessionPublisherSpringImpl();
	}
}
