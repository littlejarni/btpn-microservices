package com.btpn.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.annotation.Authenticate;
import com.btpn.auth.session.SessionPublisher;
import com.btpn.logging.annotation.Logging;
import com.btpn.login.LoginConstant;
import com.btpn.login.engine.JWTAuthenticationEngine;
import com.btpn.login.engine.StandardAuthenticationEngine;
import com.btpn.persistence.entity.usermanagement.UserEntity;
import com.btpn.persistence.service.user.UserDaoService;
import com.btpn.response.CommonResponseGenerator;
import com.btpn.response.exception.UserException;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class LoginController {
	public static final String LOGIN_JWT_ADDR = "loginJWT";
	public static final String LOGIN_STANDARD_ADDR = "login";
	public static final String WHO_AM_I_ADDR = "whoAmI";
	public static final String LOGOUT_ADDR = "logout";
	public static final String GET_TOKEN_ADDR = "getToken";
	public static final String VALIDATE_TOKEN_ADDR = "validateToken";
	
	@Autowired
	SessionPublisher sessionPublisher;
	
	@Autowired
	UserDaoService userService;

	@Autowired
	JWTAuthenticationEngine jwtAuthEngine;

	@Autowired
	ApplicationContext context;
	
	@Autowired
	CommonResponseGenerator comGen;

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(LOGOUT_ADDR)
	@Logging
	public String logout() throws JsonProcessingException {
		sessionPublisher.clearSession();
		CommonResponse<Void> restResponse = comGen.generateCommonResponse(Void.class);
		return JsonUtil.generateJson(restResponse);
	}
	
	@RequestMapping(LOGIN_JWT_ADDR)
	@Logging
	public String loginJWT(
			HttpServletRequest request,
			HttpServletResponse response,
			@Logging @RequestParam(name = "auth", defaultValue = "") String auth,
			@Logging @RequestParam(name = "redirectURL", defaultValue = "") String redirectURL
			) throws Exception {
		
		AuthenticatedUser usr = jwtAuthEngine.authenticate(auth);
		sessionPublisher.setLoginUser(usr);
		CommonResponse<AuthenticatedUser> restResponse = comGen.generateCommonResponse(usr);
		if (redirectURL != null && !redirectURL.equals("")) {
			try {
				response.sendRedirect(redirectURL);
			} catch (IOException e) {
				logger.error("Failed to redirect response", e);
			}
		}
		return JsonUtil.generateJson(restResponse);
	}
	
	@RequestMapping(LOGIN_STANDARD_ADDR)
	@Logging
	public String loginStandard(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name = "userName") @Logging String userName,
			@RequestParam(name = "password") String password
			) throws Exception {
		UserEntity usrDB = userService.getUsersByName(userName);
		if(usrDB==null || usrDB.getUserName()==null || usrDB.getUserName().equals(""))
			throw new UserException(LoginConstant.USER_DB_NOT_FOUND_ERROR_CODE, LoginConstant.USER_DB_NOT_FOUND_ERROR_DESC);
		
		if(usrDB.getEngine()==null || usrDB.getEngine().equals("")) 
			throw new UserException(LoginConstant.LOGIN_METHOD_UNSET_ERROR_CODE, LoginConstant.LOGIN_METHOD_UNSET_ERROR_DESC);
		
		StandardAuthenticationEngine stdAuthEngine = (StandardAuthenticationEngine) context.getBean(usrDB.getEngine());
		if(stdAuthEngine==null)
			throw new UserException(LoginConstant.LOGIN_METHOD_UNSUPPORTED_ERROR_CODE, LoginConstant.LOGIN_METHOD_UNSUPPORTED_ERROR_DESC);
		
		AuthenticatedUser usr = stdAuthEngine.authenticate(userName, password);
		sessionPublisher.setLoginUser(usr);
		CommonResponse<AuthenticatedUser> restResponse = comGen.generateCommonResponse(usr);;
		return JsonUtil.generateJson(restResponse);
	}
	
	@RequestMapping(WHO_AM_I_ADDR)
	@Logging
	@Authenticate
	public String whoAmI(HttpServletRequest request) throws Exception {
		AuthenticatedUser usr = sessionPublisher.getLoginUser();
		CommonResponse<AuthenticatedUser> restResponse = comGen.generateCommonResponse(usr);
		return JsonUtil.generateJson(restResponse);
	}
	
	@RequestMapping(GET_TOKEN_ADDR)
	@Logging
	@Authenticate
	public String getToken() throws JsonProcessingException {
		String token = sessionPublisher.generateToken();
		CommonResponse<String> restResponse = comGen.generateCommonResponse(token);
		return JsonUtil.generateJson(restResponse);
	}
	
	@RequestMapping(VALIDATE_TOKEN_ADDR)
	@Logging
	@Authenticate
	public String validateToken(
			@RequestParam(name = "token") @Logging String token
			) throws JsonProcessingException, UserException {
		boolean success = sessionPublisher.validateToken(token);
		CommonResponse<Boolean> restResponse = comGen.generateCommonResponse(success);
		return JsonUtil.generateJson(restResponse);
	}	
	
}
