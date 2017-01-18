package com.btpn.wscall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.wscall.CommonParamGenerator;

@Configuration
public class CommonParamGeneratorConfig {

	@Bean
	public CommonParamGenerator commonParamGenerator() {
		return new CommonParamGenerator();
	}
}
