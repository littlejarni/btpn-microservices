package com.btpn.logging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.logging.LoggingAspect;

@Configuration
public class LoggingConfig {

	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	
}
