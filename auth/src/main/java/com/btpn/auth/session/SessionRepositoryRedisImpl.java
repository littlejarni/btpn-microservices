package com.btpn.auth.session;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.AuthenticationConstant;

public class SessionRepositoryRedisImpl implements SessionRepository {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	private static Logger logger = LoggerFactory.getLogger(SessionRepositoryRedisImpl.class);

	long sessionTimeout = 30;

	public SessionRepositoryRedisImpl(ApplicationConfig appConfig) {
		String timeoutStr = appConfig.getConfig(AuthenticationConstant.SESSION_TIMEOUT_KEY);
		try {
			sessionTimeout = Long.parseLong(timeoutStr);
		} catch(Exception e) {}
		logger.info("Session timeout : " + sessionTimeout);
	}
	
	@Override
	public Map<String, String> get(String sessionId) {
		HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
		Map<String, String> session = opsForHash.entries(sessionId);
		refreshExpire(sessionId);
		return session;
	}

	private void refreshExpire(String sessionId) {
		redisTemplate.expire(sessionId, sessionTimeout, TimeUnit.MINUTES);
	}

	@Override
	public void delete(String sessionId) {
		redisTemplate.delete(sessionId);
	}

	@Override
	public void save(String sessionId, Map<String, String> data) {
		redisTemplate.delete(sessionId);
		redisTemplate.opsForHash().putAll(sessionId, data);
		refreshExpire(sessionId);
	}
}
