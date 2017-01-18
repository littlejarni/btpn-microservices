package com.btpn.auth.session;

import com.btpn.auth.AuthenticatedUser;

public interface SessionPublisher extends SessionConsumer {

	void setLoginUser(AuthenticatedUser authUser) throws Exception;

	void putSession(String key, String value);

	void removeSession(String key);

	void clearSession();
	
	String generateToken();

}
