package com.btpn.auth.session;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.util.json.JsonUtil;
import com.fasterxml.jackson.databind.ObjectWriter;

public class SessionPublisherSpringImpl implements SessionPublisher {

	@Autowired
	HttpServletRequest request;
	
	public static final String USER_SESSION_KEY_ATTR = "userSession";
	public static final String TRANS_TOKEN_KEY_ATTR = "transactionToken";

	Logger log = LoggerFactory.getLogger(SessionPublisherSpringImpl.class);
	
	@Override
	public AuthenticatedUser getLoginUser() throws Exception {
		HttpSession session = request.getSession();
		String userSession = (String) session.getAttribute(USER_SESSION_KEY_ATTR);
		if(userSession!=null && !userSession.equals("")) {
			try {
				return JsonUtil.parseJson(userSession, AuthenticatedUser.class);
			} catch(Exception e) {
				log.error("Error when parsing session json", e);
				throw e;
			}
		}
		return null;
	}
	
	@Override
	public void setLoginUser(AuthenticatedUser authUser) throws Exception {
		HttpSession session = request.getSession();
		ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
		try {
			String userSession = writer.writeValueAsString(authUser);
			session.setAttribute(USER_SESSION_KEY_ATTR, userSession);
		} catch(Exception e) {
			log.error("Error when creating json session", e);
			throw e;
		}
	}

	@Override
	public void putSession(String key, String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	@Override
	public void removeSession(String key) {
		HttpSession session = request.getSession();
		session.removeAttribute(key);
	}

	@Override
	public void clearSession() {
		HttpSession session = request.getSession();
		session.invalidate();
	}

	@Override
	public String getSessionId() {
		HttpSession session = request.getSession();
		return session.getId();
	}

	@Override
	public boolean validateToken(String token) {
		HttpSession session = request.getSession();
		String sessionToken = (String) session.getAttribute(TRANS_TOKEN_KEY_ATTR);
		
		if(sessionToken==null || sessionToken.equals(""))
			return false;
		if(token==null || token.equals(""))
			return false;
		if(!sessionToken.equals(token))
			return false;
		
		session.removeAttribute(TRANS_TOKEN_KEY_ATTR);
		
		return true;
	}

	@Override
	public String generateToken() {
		String token = UUID.randomUUID().toString().replace("-", "");
		HttpSession session = request.getSession();
		session.setAttribute(TRANS_TOKEN_KEY_ATTR, token);
		return token;
	}
}
