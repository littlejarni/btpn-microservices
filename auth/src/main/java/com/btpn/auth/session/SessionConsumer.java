package com.btpn.auth.session;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.response.exception.UserException;

public interface SessionConsumer {

	AuthenticatedUser getLoginUser() throws Exception;

	String getSessionId();
	
	boolean validateToken(String token) throws UserException;
}
