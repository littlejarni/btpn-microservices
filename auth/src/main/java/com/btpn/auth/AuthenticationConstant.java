package com.btpn.auth;

public class AuthenticationConstant {
	public static final String UNAUTHORIZED_MESSAGE = "You do not have authorization";
	public static final String FORBIDDEN_MESSAGE = "You do not have access";
	
	public static final String AUTHENTICATION_METHOD_JWT = "JWT";
	public static final String AUTHENTICATION_METHOD_DB = "DB";
	public static final String AUTHENTICATION_METHOD_LDAP = "LDAP";
	
	public static final String SESSION_COOKIE = "BSESSION";
	public static final String USER_NAME_LOG_CONTEXT = "userName";
	public static final String USER_ID_LOG_CONTEXT = "userId";
	public static final String AUTH_METHOD_LOG_CONTEXT = "authenticationMethod";
	
	public static final String SESSION_TIMEOUT_KEY = "session.timeout";
	public static final String LOGIN_PUBLISHER_URL_KEY = "login.publisher.url";
	public static final String TOKEN_VALIDATOR_URL_KEY = "token.validator.url";
	
	public static final String INIT_SESSION_HTTP_RESPONSE_ERROR_CODE = "AU01";
	public static final String INIT_SESSION_HTTP_RESPONSE_ERROR_DESC = "Failed to get valid server reponse from authentication server";
	public static final String INIT_SESSION_RESPONSE_STATUS_ERROR_CODE = "AU02";
	public static final String INIT_SESSION_RESPONSE_STATUS_ERROR_DESC = "Failed to get valid response code from authentication server";
	public static final String VALIDATE_TOKEN_HTTP_RESPONSE_ERROR_CODE = "AU03";
	public static final String VALIDATE_TOKEN_HTTP_RESPONSE_ERROR_DESC = "Failed to get valid server reponse from validation server";;
	public static final String VALIDATE_TOKEN_RESPONSE_STATUS_ERROR_CODE = "AU04";
	public static final String VALIDATE_TOKEN_RESPONSE_STATUS_ERROR_DESC = "Failed to get valid response code from validation server";
	public static final String INVALID_TOKEN_ERROR_CODE = "AU05";
	public static final String INVALID_TOKEN_ERROR_DESC = "Invalid token";
	

}
