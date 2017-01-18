package com.btpn.auth.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.util.http.HTTPUtil;
import com.btpn.util.json.JsonUtil;

public class SessionPublisherCustomImpl implements SessionPublisher {

	public static final String USER_SESSION_KEY_ATTR = "userSession";
	public static final String TRANS_TOKEN_KEY_ATTR = "transactionToken";

	Logger log = LoggerFactory.getLogger(SessionPublisherCustomImpl.class);

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@Autowired
	SessionRepository sessionRepo;

	String sessionId;
	Map<String, String> session;
	boolean saved = true;

	@Override
	public void clearSession() {
		this.saved = false;
		session.clear();
	}

	private String generateSessionId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Override
	public String generateToken() {
		String token = UUID.randomUUID().toString().replace("-", "");
		putSession(TRANS_TOKEN_KEY_ATTR, token);
		return token;
	}

	@Override
	public AuthenticatedUser getLoginUser() throws Exception {
		String userSession = session.get(USER_SESSION_KEY_ATTR);
		if (userSession != null && !userSession.equals("")) {
			try {
				return JsonUtil.parseJson(userSession, AuthenticatedUser.class);
			} catch (Exception e) {
				log.error("Error when parsing session json", e);
				throw e;
			}
		}
		return null;
	}

	public Map<String, String> getSession() {
		return session;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	public void initSession() {
		session = new HashMap<String, String>();

		Cookie currentCookie = HTTPUtil.getCookieByName(request, AuthenticationConstant.SESSION_COOKIE);
		if (currentCookie != null)
			sessionId = currentCookie.getValue();

		if (sessionId == null || "".equals(sessionId) || !lookupSession()) {
			sessionId = generateSessionId();
		}

		Cookie setCookie = new Cookie(AuthenticationConstant.SESSION_COOKIE, sessionId);
		setCookie.setHttpOnly(true);
		response.addCookie(setCookie);
	}

	private boolean lookupSession() {
		Map<String, String> repoData = sessionRepo.get(sessionId);
		if (repoData == null) {
			return false;
		}
		session.putAll(repoData);
		return true;
	}

	public void putAllSession(Map<? extends String, ? extends String> m) {
		this.saved = false;
		session.putAll(m);
	}

	@Override
	public void putSession(String key, String value) {
		this.saved = false;
		session.put(key, value);
	}

	@Override
	public void removeSession(String key) {
		this.saved = false;
		session.remove(key);
	}

	public void saveSession() {
		if (!saved) {
			if (session.isEmpty()) {
				sessionRepo.delete(sessionId);
			} else {
				sessionRepo.save(sessionId, session);
			}
			saved = true;
		}
	}

	@Override
	public void setLoginUser(AuthenticatedUser authUser) throws Exception {
		try {
			String userSession = JsonUtil.generateJson(authUser);
			putSession(USER_SESSION_KEY_ATTR, userSession);
		} catch (Exception e) {
			log.error("Error when creating json session", e);
			throw e;
		}
	}

	@Override
	public boolean validateToken(String token) {
		String sessionToken = session.get(TRANS_TOKEN_KEY_ATTR);

		if (sessionToken == null || sessionToken.equals(""))
			return false;
		if (token == null || token.equals(""))
			return false;
		if (!sessionToken.equals(token))
			return false;

		removeSession(TRANS_TOKEN_KEY_ATTR);

		return true;
	}

}
