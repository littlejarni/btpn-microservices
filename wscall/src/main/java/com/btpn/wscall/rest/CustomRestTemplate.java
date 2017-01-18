package com.btpn.wscall.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.session.SessionConsumer;

public class CustomRestTemplate extends RestTemplate {


	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SessionConsumer sessionCon;

	public CustomRestTemplate() {
		super();
	}
	
	public CustomRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
		super(clientHttpRequestFactory);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> ResponseEntity<T> exchangeInternal(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
		HttpHeaders headers = generateSessionHeader(requestEntity);
		return super.exchange(url, method, new HttpEntity(requestEntity.getBody(), headers), responseType, uriVariables);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> ResponseEntity<T> exchangeInternal(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
		HttpHeaders headers = generateSessionHeader(requestEntity);
		return super.exchange(url, method, new HttpEntity(requestEntity.getBody(), headers), responseType, uriVariables);
	}

	private HttpHeaders generateSessionHeader(HttpEntity<?> requestEntity) {
		HttpHeaders headers = new HttpHeaders();
		HttpHeaders requestHeaders = requestEntity.getHeaders();
		if (requestHeaders != null && requestHeaders.size() > 0)
			headers.putAll(requestHeaders);

		String sessionId = sessionCon.getSessionId();
		if (sessionId != null && !sessionId.equals("")) {
			headers.remove(HttpHeaders.COOKIE);
			headers.add(HttpHeaders.COOKIE, AuthenticationConstant.SESSION_COOKIE + "=" + sessionId);
		}
		return headers;
	}
}
