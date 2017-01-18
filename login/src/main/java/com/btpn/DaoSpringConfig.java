package com.btpn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.btpn.persistence.service.role.RoleDaoService;
import com.btpn.persistence.service.role.RoleDaoServiceImpl;
import com.btpn.persistence.service.service.ServiceDaoService;
import com.btpn.persistence.service.service.ServiceDaoServiceImpl;
import com.btpn.persistence.service.user.UserDaoService;
import com.btpn.persistence.service.user.UserDaoServiceImpl;

@Configuration
public class DaoSpringConfig {

	@Bean
	public UserDaoService userDaoService() {
		return new UserDaoServiceImpl();
	}
	
	@Bean
	public ServiceDaoService serviceDaoService() {
		return new ServiceDaoServiceImpl();
	}
	
	@Bean
	public RoleDaoService roleDaoService() {
		return new RoleDaoServiceImpl();
	}
	
}
