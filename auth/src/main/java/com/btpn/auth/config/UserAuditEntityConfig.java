package com.btpn.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.btpn.persistence.auth.entity.UserAuditAware;

@Configuration
@EnableJpaAuditing
public class UserAuditEntityConfig {
	
	@Bean
    AuditorAware<String> auditorProvider() {
        return new UserAuditAware();
    }
}
