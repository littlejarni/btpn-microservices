package com.btpn.wscall.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.util.json.JsonUtil;
import com.btpn.wscall.WSCallConstant;
import com.btpn.wscall.rest.CustomRestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RestWSCallConfig {

	@Autowired
	ApplicationConfig appConfig; 
	
	@Bean
	public HttpClient httpClient() {
		PoolingHttpClientConnectionManager mgr = new PoolingHttpClientConnectionManager();

		String maxTotalPool = appConfig.getConfig(WSCallConstant.HTTP_CLIENT_MAX_TOTAL_POOL_KEY);
		String maxPerRoutePool = appConfig.getConfig(WSCallConstant.HTTP_CLIENT_MAX_PER_ROUTE_POOL_KEY);
		
		mgr.setDefaultMaxPerRoute(Integer.parseInt(maxPerRoutePool));
		mgr.setMaxTotal(Integer.parseInt(maxTotalPool));

		HttpClientBuilder builder = HttpClientBuilder
				.create()
				.setConnectionManager(mgr);
		return builder.build();
	}

	@Bean
	public ClientHttpRequestFactory clientHttpRequestFactory() {

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient());

		String connectTimeout = appConfig.getConfig(WSCallConstant.HTTP_CLIENT_CONNECT_TIMEOUT_KEY);
		String readTimeout = appConfig.getConfig(WSCallConstant.HTTP_CLIENT_READ_TIMEOUT_KEY);

		factory.setConnectTimeout(Integer.parseInt(connectTimeout));
		factory.setReadTimeout(Integer.parseInt(readTimeout));

		return factory;
	}

	@Bean
	public CustomRestTemplate restTemplate() {
		CustomRestTemplate restTemplate = new CustomRestTemplate(clientHttpRequestFactory());
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper om = JsonUtil.generateDefaultJsonMapper();
	    converter.setObjectMapper(om);
		restTemplate.getMessageConverters().add(0, converter);
		
		return restTemplate;
	}
}
