package com.btpn.auth.session;

import java.util.Map;

public interface SessionRepository {

	Map<String, String> get(String sessionId);

	void delete(String sessionId);

	void save(String sessionId, Map<String, String> data);

}
