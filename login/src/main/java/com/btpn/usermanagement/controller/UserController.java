package com.btpn.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.auth.annotation.Authenticate;
import com.btpn.logging.annotation.Logging;
import com.btpn.persistence.entity.usermanagement.UserEntity;
import com.btpn.persistence.service.user.UserDaoService;
import com.btpn.response.CommonResponseGenerator;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonUtil;

@RestController
public class UserController {
	public static final String SEARCH_USER_ADDR = "searchUser";
	public static final String SEARCH_USER_AUTH = "SEARCH_USER";
	public static final String GET_USER_ADDR = "getUser";
	public static final String GET_USER_AUTH = "GET_USER";
	
	@Autowired
	private UserDaoService service;

	@Autowired
	CommonResponseGenerator comGen;

	@RequestMapping(GET_USER_ADDR)
	@Logging
	@Authenticate(GET_USER_AUTH)
	public String getUsersByName(
			@Logging @RequestParam(name="name")String name) throws Exception {
		UserEntity usr = service.getUsersByName(name);
		CommonResponse<UserEntity> restResponse = comGen.generateCommonResponse(usr);
		return JsonUtil.generateJson(restResponse);
	}

//	@RequestMapping(GET_USER_LIST_ADDR)
//	@Logging
//	@Authenticate(GET_USER_LIST_AUTH)
//	public String getUsersList(
//			@Logging @RequestParam(name="search", defaultValue = "")String search,
//			@RequestParam(name = "page", defaultValue = "0") int page) throws Exception {
//		CommonResponsePaging<UserEntity> restResponse = new CommonResponsePaging<UserEntity>();
//		return JsonUtil.generateJson(restResponse);
//	}

}
