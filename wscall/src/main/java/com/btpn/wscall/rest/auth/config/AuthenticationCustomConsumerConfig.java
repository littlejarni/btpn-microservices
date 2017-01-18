package com.btpn.wscall.rest.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.btpn.auth.config.BaseAuthenticationConfig;
import com.btpn.wscall.rest.auth.filter.CustomRestSessionConsumerInterceptor;
import com.btpn.wscall.rest.auth.session.SessionConsumerCustomRestImpl;

@Configuration
public class AuthenticationCustomConsumerConfig extends BaseAuthenticationConfig {

	@Bean
	public CustomRestSessionConsumerInterceptor sessionInterceptor() {
		return new CustomRestSessionConsumerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor());
		registry.addInterceptor(registerAuthenticationContextInterceptor());
		registry.addInterceptor(authenticationInterceptor());
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionConsumerCustomRestImpl sessionConsumer() {
		return new SessionConsumerCustomRestImpl();
	}
}
