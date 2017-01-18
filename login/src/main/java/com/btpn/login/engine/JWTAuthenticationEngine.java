package com.btpn.login.engine;

import com.btpn.auth.AuthenticatedUser;

public interface JWTAuthenticationEngine {
	AuthenticatedUser authenticate(String jwt) throws Exception;
}
