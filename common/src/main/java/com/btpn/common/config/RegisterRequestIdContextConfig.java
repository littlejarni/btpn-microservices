package com.btpn.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.btpn.common.context.RequestContext;
import com.btpn.common.filter.RegisterRequestIdContextInterceptor;

@Configuration
public class RegisterRequestIdContextConfig extends WebMvcConfigurerAdapter {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public RequestContext requestContext() {
		return new RequestContext();
	}
	
	@Bean
	public RegisterRequestIdContextInterceptor registerRequestIdInterceptor() {
		return new RegisterRequestIdContextInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(registerRequestIdInterceptor());

	}
		
}
