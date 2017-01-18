package com.btpn.runningnumber.config;

import org.springframework.context.annotation.Bean;

import com.btpn.persistence.service.runningnumber.RunningNumberService;
import com.btpn.persistence.service.runningnumber.RunningNumberServiceImpl;

public class RunningNumberConfig {
	
	@Bean
	public RunningNumberService runningNumberService() {
		return new RunningNumberServiceImpl();
	}
}
