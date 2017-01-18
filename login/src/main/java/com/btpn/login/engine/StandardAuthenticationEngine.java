package com.btpn.login.engine;

import com.btpn.auth.AuthenticatedUser;

public interface StandardAuthenticationEngine {

	AuthenticatedUser authenticate(String username, String password) throws Exception;
}
