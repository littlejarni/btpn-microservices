package com.btpn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.filter.CustomSessionPublisherInterceptor;
import com.btpn.auth.session.SessionPublisherCustomImpl;
import com.btpn.auth.session.SessionRepository;
import com.btpn.auth.session.SessionRepositoryRedisImpl;

@Configuration
public class AuthenticationCustomPublisherConfig extends BaseAuthenticationConfig {

	@Bean
	public SessionRepository sessionRepo(ApplicationConfig appConfig) {
		return new SessionRepositoryRedisImpl(appConfig);
	}

	@Bean
	public CustomSessionPublisherInterceptor sessionInterceptor() {
		return new CustomSessionPublisherInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor());
		registry.addInterceptor(registerAuthenticationContextInterceptor());
		registry.addInterceptor(authenticationInterceptor());
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionPublisherCustomImpl sessionPublisher() {
		return new SessionPublisherCustomImpl();
	}
}
