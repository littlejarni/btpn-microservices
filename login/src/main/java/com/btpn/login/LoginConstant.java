package com.btpn.login;

public class LoginConstant {

	public static final String LDAP_HOST_KEY = "ldap.host";
	public static final String LDAP_DOMAIN_KEY = "ldap.domain";
	public static final String LDAP_NAME_FIELD_KEY = "ldap.name.field";
	public static final String LDAP_NIK_FIELD_KEY = "ldap.nik.field";
	public static final String LDAP_SEARCH_BASE_KEY = "ldap.search.base";

	public static final String JWT_KEY_ENCRIPTION_KEY = "jwt.key.encription";
	public static final String JWT_NAME_CLAIM = "name";
	public static final String JWT_USERID_CLAIM = "userId";
	public static final String JWT_BRANCH_CLAIM = "branch";
	public static final String JWT_USERROLE_CLAIM = "userRole";
	public static final String JWT_SPVROLE_CLAIM = "spvRole";

	public static final String AUTHENTICATION_ENGINE_KEY = "auth.engine";
	public static final String AUTHENTICATION_ENGINE_DB = "DB";
	public static final String AUTHENTICATION_ENGINE_LDAP = "LDAP";

	public static final String PASSWORD_SALT_KEY = "password.salt";

	public static final String JWT_EXPIRED_ERROR_CODE = "L01";
	public static final String JWT_EXPIRED_ERROR_DESC = "JWT Expired";
	public static final String JWT_MALFORMED_ERROR_CODE = "L02";
	public static final String JWT_MALFORMED_ERROR_DESC = "JWT Malformed";
	public static final String JWT_UNSUPPORTED_ERROR_CODE = "L03";
	public static final String JWT_UNSUPPORTED_ERROR_DESC = "JWT Unsupported";
	public static final String JWT_PARSE_ERROR_CODE = "L04";
	public static final String JWT_PARSE_ERROR_DESC = "JWT Parse Error";
	public static final String USER_DB_NOT_FOUND_ERROR_CODE = "L05";
	public static final String USER_DB_NOT_FOUND_ERROR_DESC = "User Not Found";
	public static final String INVALID_PASSWORD_DB_ERROR_CODE = "L05";
	public static final String INVALID_PASSWORD_DB_ERROR_DESC = "Invalid Password";
	public static final String INVALID_LOGIN_LDAP_ERROR_CODE = "L06";
	public static final String INVALID_LOGIN_LDAP_ERROR_DESC = "Invalid LDAP Login";
	public static final String EMPTY_ROLE_NAME_ERROR_CODE = "L07";
	public static final String EMPTY_ROLE_NAME_ERROR_DESC = "Role Name must not empty";
	public static final String LOGIN_METHOD_UNSET_ERROR_CODE = "L08";
	public static final String LOGIN_METHOD_UNSET_ERROR_DESC = "Login method not set";
	public static final String LOGIN_METHOD_UNSUPPORTED_ERROR_CODE = "L09";
	public static final String LOGIN_METHOD_UNSUPPORTED_ERROR_DESC = "Login method unsupported";

}
