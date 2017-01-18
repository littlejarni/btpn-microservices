package com.btpn.closingcustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.annotation.Authenticate;
import com.btpn.auth.session.SessionConsumer;
import com.btpn.common.entity.TokenizeRequest;
import com.btpn.logging.annotation.Logging;
import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.btpn.response.exception.UserException;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonFilter;
import com.btpn.util.json.JsonUtil;
import com.btpn.wscall.rest.CustomRestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class TestController {

	@Autowired
	SessionConsumer sessionCon;
	
	@Autowired
	CustomRestTemplate restTemplate;
	
	@RequestMapping("TestingToken")
	@Authenticate
	@Logging
	public String testingToken(
			@RequestBody TokenizeRequest<String> reqBody) throws UserException, JsonProcessingException {
		String token = reqBody.getToken();
		System.out.println("---------------token : " + token);
		if(!sessionCon.validateToken(token))
			throw new UserException(AuthenticationConstant.INVALID_TOKEN_ERROR_CODE, AuthenticationConstant.INVALID_TOKEN_ERROR_DESC);
		
		CommonResponse<String> resp = new CommonResponse<String>(reqBody.getData());
		return JsonUtil.generateJson(resp);
	}
	
	@RequestMapping("testingPost")
	@Authenticate
	@Logging
	public String testingPost(
			@RequestBody TokenizeRequest<RoleEntity> reqBody) throws UserException, JsonProcessingException {
		ResponseEntity<CommonResponse<RoleEntity>> resp = restTemplate.exchangeInternal(
				"http://localhost:8080/saveRole", 
				HttpMethod.POST, 
				new HttpEntity<TokenizeRequest<RoleEntity>>(reqBody), 
				new ParameterizedTypeReference<CommonResponse<RoleEntity>>() {
				});

		ObjectWriter writer = JsonUtil.generateJsonWriterWithFilter(
				new JsonFilter(RoleEntity.Constant.JSON_FILTER,
						RoleEntity.Constant.ROLE_MENUS_FIELD,
						RoleEntity.Constant.ROLE_SERVICES_FIELD,
						RoleEntity.Constant.USER_ROLES_FIELD)
				);
		return writer.writeValueAsString(resp.getBody());
	}
	
}
