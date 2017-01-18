package com.btpn.auth.session;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btpn.auth.AuthenticationConstant;

public class Session implements Map<String, String> {

	String sessionId;
	private Map<String, String> data;

	SessionRepository sessionRepo;
	private boolean saved = true;

	public Session(SessionRepository sessionRepo, HttpServletRequest request, HttpServletResponse response) {
		this.sessionRepo = sessionRepo;
		data = new HashMap<String, String>();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (AuthenticationConstant.SESSION_COOKIE.equals(c.getName())) {
					sessionId = c.getValue();
					break;
				}
			}
		}

		if (sessionId == null || "".equals(AuthenticationConstant.SESSION_COOKIE) || !lookupSession()) {
			createSessionId();
		}

		Cookie cookie = new Cookie(AuthenticationConstant.SESSION_COOKIE, sessionId);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public void save() {
		if (!saved) {
			if (data.isEmpty()) {
				sessionRepo.delete(sessionId);
			} else {
				sessionRepo.save(sessionId, data);
			}
			saved = true;
		}
	}

	private void createSessionId() {
		sessionId = UUID.randomUUID().toString();
	}

	private boolean lookupSession() {
		Map<String, String> repoData = sessionRepo.get(sessionId);
		if (repoData == null) {
			return false;
		}
		data.putAll(repoData);
		return true;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	@Override
	public String get(Object key) {
		return data.get(key);

	}

	@Override
	public String put(String key, String value) {
		this.saved = false;
		return data.put(key, value);
	}

	@Override
	public String remove(Object key) {
		this.saved = false;
		return data.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		this.saved = false;
		data.putAll(m);
	}

	@Override
	public void clear() {
		this.saved = false;
		data.clear();
	}

	@Override
	public Set<String> keySet() {
		throw new UnsupportedOperationException("session unsupported keySet method.");
	}

	@Override
	public Collection<String> values() {
		throw new UnsupportedOperationException("session unsupported values method.");
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		throw new UnsupportedOperationException("session unsupported entrySet method.");
	}
}
