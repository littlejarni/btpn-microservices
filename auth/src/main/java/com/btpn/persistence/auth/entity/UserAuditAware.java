package com.btpn.persistence.auth.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.session.SessionPublisher;

public class UserAuditAware implements AuditorAware<String> {

	@Autowired
	SessionPublisher sessionPublisher;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public String getCurrentAuditor() {
		AuthenticatedUser user;
		try {
			user = sessionPublisher.getLoginUser();
		} catch (Exception e) {
			log.error("Error when getting authenticated user", e);
			return null;
		}
		
		if(user!=null) {
			return user.getUserName();
		} else {
			return null;
		}
	}

}
