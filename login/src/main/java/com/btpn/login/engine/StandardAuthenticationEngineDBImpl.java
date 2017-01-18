package com.btpn.login.engine;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.login.LoginConstant;
import com.btpn.persistence.service.service.ServiceDaoService;
import com.btpn.persistence.service.user.UserDaoService;
import com.btpn.persistence.entity.usermanagement.ServiceEntity;
import com.btpn.persistence.entity.usermanagement.UserEntity;
import com.btpn.response.exception.UserException;
import com.btpn.util.security.password.PasswordUtil;

public class StandardAuthenticationEngineDBImpl implements StandardAuthenticationEngine {

	@Autowired
	UserDaoService userService;

	@Autowired
	ServiceDaoService serviceService;
	
	@Autowired
	ApplicationConfig appConf;
	
	@Override
	public AuthenticatedUser authenticate(String username, String password) throws UserException, NoSuchAlgorithmException {
		AuthenticatedUser usr = new AuthenticatedUser();
		UserEntity usrDB = userService.getUsersByName(username);
		if(usrDB==null || usrDB.getUserName()==null || usrDB.getUserName().equals("")) {
			throw new UserException(LoginConstant.USER_DB_NOT_FOUND_ERROR_CODE, LoginConstant.USER_DB_NOT_FOUND_ERROR_DESC);
		}
		String salt = appConf.getConfig(LoginConstant.PASSWORD_SALT_KEY);
		String hashPassword = PasswordUtil.getPasswordHash(password, salt);
		if(!usrDB.getPassword().equals(hashPassword)) {
			throw new UserException(LoginConstant.INVALID_PASSWORD_DB_ERROR_CODE, LoginConstant.INVALID_PASSWORD_DB_ERROR_DESC);
		}
		usr.setUserName(usrDB.getUserName());
		usr.setName(usrDB.getName());
		usr.setAuthenticatedMethod(AuthenticationConstant.AUTHENTICATION_METHOD_DB);
		
		Set<ServiceEntity> setService = getUserServices(usrDB.getUserName());
		List<String> services = new ArrayList<String>();
		setService.forEach((service) -> services.add(service.getServiceCode()));
		usr.setServices(services);
		
		return usr;
	}
	
	private Set<ServiceEntity> getUserServices(String userName) {
		return serviceService.getServicesByUser(userName);
		
	}
}
