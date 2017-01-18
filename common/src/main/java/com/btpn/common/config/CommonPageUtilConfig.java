package com.btpn.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.btpn.common.paging.CommonPageUtil;

@Configuration
public class CommonPageUtilConfig extends WebMvcConfigurerAdapter {

	@Bean
	public CommonPageUtil commonPageUtil() {
		return new CommonPageUtil();
	}

}
