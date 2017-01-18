package com.btpn.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.annotation.Authenticate;
import com.btpn.auth.session.SessionPublisher;
import com.btpn.common.entity.TokenizeRequest;
import com.btpn.logging.annotation.Logging;
import com.btpn.login.LoginConstant;
import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.btpn.persistence.service.role.RoleDaoService;
import com.btpn.response.CommonResponseGenerator;
import com.btpn.response.exception.UserException;
import com.btpn.response.rest.CommonPaging;
import com.btpn.response.rest.CommonResponse;
import com.btpn.response.rest.CommonResponsePaging;
import com.btpn.util.json.JsonFilter;
import com.btpn.util.json.JsonUtil;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class RoleController {
	public static final String SAVE_ROLE_ADDR = "saveRole";
	public static final String SAVE_ROLE_AUTH = "SAVE_ROLE";
	public static final String SEARCH_ROLE_ADDR = "searchRole";
	public static final String SEARCH_ROLE_AUTH = "SEARCH_ROLE";
	private static final String GET_ROLE_ADDR = "getRole";
	private static final String GET_ROLE_AUTH = "GET_ROLE";

	@Autowired
	private RoleDaoService service;

	@Autowired
	CommonResponseGenerator comGen;

	@Autowired
	SessionPublisher sessionPub;
	
	@RequestMapping(method=RequestMethod.POST, value=SAVE_ROLE_ADDR)
	@Logging
	@Authenticate(SAVE_ROLE_AUTH)
	public String saveRole(
			@RequestBody TokenizeRequest<RoleEntity> reqBody) throws Exception {
		String token = reqBody.getToken();
		if(!sessionPub.validateToken(token))
			throw new UserException(AuthenticationConstant.INVALID_TOKEN_ERROR_CODE, AuthenticationConstant.INVALID_TOKEN_ERROR_DESC);
		
		RoleEntity role = reqBody.getData();
		if(role==null || role.getRoleName()==null || role.getRoleName().equals("")) 
			throw new UserException(LoginConstant.EMPTY_ROLE_NAME_ERROR_CODE, LoginConstant.EMPTY_ROLE_NAME_ERROR_DESC);
		
		RoleEntity returnRole = service.saveRole(role);

		CommonResponse<RoleEntity> restResponse = comGen.generateCommonResponse(returnRole);
		ObjectWriter writer = JsonUtil.generateJsonWriterWithFilter(
				new JsonFilter(RoleEntity.Constant.JSON_FILTER,
						RoleEntity.Constant.ROLE_MENUS_FIELD,
						RoleEntity.Constant.ROLE_SERVICES_FIELD,
						RoleEntity.Constant.USER_ROLES_FIELD)
				);
		return writer.writeValueAsString(restResponse);
	}
	
	@RequestMapping(value=SEARCH_ROLE_ADDR)
	@Logging
	@Authenticate(SEARCH_ROLE_AUTH)
	public String searchRole(
			@RequestParam(name="search", defaultValue="", required=false) String search, 
			@RequestParam(name="page", defaultValue="0", required=false) int page) throws Exception {
		
		CommonPaging<RoleEntity> paging = service.searchRole(search, page);
		CommonResponsePaging<RoleEntity> restResponse =  comGen.generateCommonResponsePaging(paging);
		
		ObjectWriter writer = JsonUtil.generateJsonWriterWithFilter(
				new JsonFilter(RoleEntity.Constant.JSON_FILTER,
						RoleEntity.Constant.ROLE_MENUS_FIELD,
						RoleEntity.Constant.ROLE_SERVICES_FIELD,
						RoleEntity.Constant.USER_ROLES_FIELD)
				);
		return writer.writeValueAsString(restResponse);
	}

	@RequestMapping(value=GET_ROLE_ADDR)
	@Logging
	@Authenticate(GET_ROLE_AUTH)
	public String getRole(
			@RequestParam(name="id") String id) throws Exception {
		
		RoleEntity role = service.getRole(id);
		CommonResponse<RoleEntity> restResponse =  comGen.generateCommonResponse(role);
		
		ObjectWriter writer = JsonUtil.generateJsonWriterWithFilter(
				new JsonFilter(RoleEntity.Constant.JSON_FILTER,
						RoleEntity.Constant.ROLE_MENUS_FIELD,
						RoleEntity.Constant.ROLE_SERVICES_FIELD,
						RoleEntity.Constant.USER_ROLES_FIELD)
				);
		return writer.writeValueAsString(restResponse);
	}

}
