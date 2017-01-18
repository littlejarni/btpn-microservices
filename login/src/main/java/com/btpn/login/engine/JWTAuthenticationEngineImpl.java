package com.btpn.login.engine;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.login.LoginConstant;
import com.btpn.login.controller.LoginController;
import com.btpn.persistence.service.service.ServiceDaoService;
import com.btpn.persistence.entity.usermanagement.ServiceEntity;
import com.btpn.response.exception.UserException;
import com.btpn.util.security.jwt.JWTUtils;

public class JWTAuthenticationEngineImpl implements JWTAuthenticationEngine {

	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	ServiceDaoService serviceService;

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Override
	public AuthenticatedUser authenticate(String jwt) throws Exception {
		try {
			Claims claims = JWTUtils.parseJWT(jwt, appConfig.getConfig(LoginConstant.JWT_KEY_ENCRIPTION_KEY));
			AuthenticatedUser usr = new AuthenticatedUser();
			usr.setUserName(claims.getSubject());
			String name = (String) claims.get(LoginConstant.JWT_NAME_CLAIM);
			String userId = (String) claims.get(LoginConstant.JWT_USERID_CLAIM);
			String branch = (String) claims.get(LoginConstant.JWT_BRANCH_CLAIM);
			String spvRole = (String) claims.get(LoginConstant.JWT_SPVROLE_CLAIM);
			usr.setName(name);
			usr.setAuthenticatedMethod(AuthenticationConstant.AUTHENTICATION_METHOD_JWT);

			usr.setUserId(userId);
			usr.setBranch(branch);
			usr.setSpvRole(spvRole);
			
			String role = (String) claims.get(LoginConstant.JWT_USERROLE_CLAIM);
			Set<ServiceEntity> setService = serviceService.getServicesByJwtRole(role);
			List<String> services = new ArrayList<String>();
			setService.forEach((service) -> services.add(service.getServiceCode()));
			usr.setServices(services);
			
			return usr;
		} catch (ExpiredJwtException e) {
			logger.error("JWT Expired", e);
			throw new UserException(LoginConstant.JWT_EXPIRED_ERROR_CODE, LoginConstant.JWT_EXPIRED_ERROR_DESC);
		} catch (UnsupportedJwtException e) {
			logger.error("JWT Unsupported", e);
			throw new UserException(LoginConstant.JWT_UNSUPPORTED_ERROR_CODE, LoginConstant.JWT_UNSUPPORTED_ERROR_DESC);
		} catch (MalformedJwtException e) {
			logger.error("JWT Malformed", e);
			throw new UserException(LoginConstant.JWT_MALFORMED_ERROR_CODE, LoginConstant.JWT_MALFORMED_ERROR_DESC);
		} catch (Exception e) {
			logger.error("Failed to parse JSON Web Token", e);
			throw new UserException(LoginConstant.JWT_PARSE_ERROR_CODE, LoginConstant.JWT_PARSE_ERROR_DESC);
		}
	}
	
}
