package com.btpn.wscall.rest.auth.session;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.session.SessionConsumer;
import com.btpn.response.CommonResponseConstant;
import com.btpn.response.exception.UserException;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.http.HTTPUtil;
import com.btpn.wscall.rest.CustomRestTemplate;

public class SessionConsumerCustomRestImpl implements SessionConsumer {

	Logger log = LoggerFactory.getLogger(SessionConsumerCustomRestImpl.class);

	public static final String TOKEN_URL_VARIABLE = "token";

	@Autowired
	HttpServletRequest request;

	@Autowired
	CustomRestTemplate customRestTemplate;

	@Autowired
	ApplicationConfig appConfig;

	AuthenticatedUser userSession;

	String sessionId;

	public SessionConsumerCustomRestImpl() {

	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	public void initSession() throws UserException {

		Cookie currentCookie = HTTPUtil.getCookieByName(request, AuthenticationConstant.SESSION_COOKIE);
		if (currentCookie != null)
			sessionId = currentCookie.getValue();

		String url = appConfig.getConfig(AuthenticationConstant.LOGIN_PUBLISHER_URL_KEY);
		ResponseEntity<CommonResponse<AuthenticatedUser>> restResponse;
		try {
			restResponse = customRestTemplate.exchangeInternal(url, HttpMethod.GET, new HttpEntity<String>(""),
					new ParameterizedTypeReference<CommonResponse<AuthenticatedUser>>() {
					});
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED)
				return;
			log.error("Get HTTP Status " + e.getRawStatusCode() + " when validate session data");
			throw new UserException(AuthenticationConstant.INIT_SESSION_HTTP_RESPONSE_ERROR_CODE, AuthenticationConstant.INIT_SESSION_HTTP_RESPONSE_ERROR_DESC);
		}

		if (restResponse.getBody().getResponseStatus() == null || !CommonResponseConstant.DEFAULT_SUCCESS_CODE.equals(restResponse.getBody().getResponseStatus().getResponseCode())) {
			log.error("Get Response Code " + restResponse.getBody().getResponseStatus() + " when validate session data");
			throw new UserException(AuthenticationConstant.INIT_SESSION_RESPONSE_STATUS_ERROR_CODE, AuthenticationConstant.INIT_SESSION_RESPONSE_STATUS_ERROR_DESC);
		}

		userSession = restResponse.getBody().getData();
	}

	@Override
	public AuthenticatedUser getLoginUser() throws Exception {
		return userSession;
	}

	@Override
	public boolean validateToken(String token) throws UserException {
		if (token == null || token.equals(""))
			return false;

		String url = appConfig.getConfig(AuthenticationConstant.TOKEN_VALIDATOR_URL_KEY);
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put(TOKEN_URL_VARIABLE, token);

		ResponseEntity<CommonResponse<Boolean>> restResponse;
		try {
			restResponse = customRestTemplate.exchangeInternal(url, HttpMethod.GET, new HttpEntity<String>(""),
					new ParameterizedTypeReference<CommonResponse<Boolean>>() {
					},
					uriVariable);
		} catch (HttpClientErrorException e) {
			log.error("Get HTTP Status " + e.getRawStatusCode() + " when validate session data");
			throw new UserException(AuthenticationConstant.VALIDATE_TOKEN_HTTP_RESPONSE_ERROR_CODE, AuthenticationConstant.VALIDATE_TOKEN_HTTP_RESPONSE_ERROR_DESC);
		}

		if (restResponse.getBody().getResponseStatus() == null || !CommonResponseConstant.DEFAULT_SUCCESS_CODE.equals(restResponse.getBody().getResponseStatus().getResponseCode())) {
			log.error("Get Response Code " + restResponse.getBody().getResponseStatus() + " when validate session data");
			throw new UserException(AuthenticationConstant.VALIDATE_TOKEN_RESPONSE_STATUS_ERROR_CODE, AuthenticationConstant.VALIDATE_TOKEN_RESPONSE_STATUS_ERROR_DESC);
		}

		return restResponse.getBody().getData();
	}

}
