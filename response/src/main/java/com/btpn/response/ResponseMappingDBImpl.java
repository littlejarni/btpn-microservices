package com.btpn.response;

import java.util.HashMap;
import java.util.List;

import com.btpn.logging.annotation.Logging;
import com.btpn.persistence.entity.ResponseMappingEntity;
import com.btpn.persistence.service.responsemapping.ResponseMappingDaoService;
import com.btpn.response.rest.CommonStatus;


public class ResponseMappingDBImpl implements ResponseMapping{
	private HashMap<String, String> mapResponse = new HashMap<String, String>();
	
	ResponseMappingDaoService service;
	
	public ResponseMappingDBImpl(ResponseMappingDaoService service) {
		this.service = service;
		reloadResponseMapping();
	}

	@Override
	@Logging
	public void reloadResponseMapping() {
		mapResponse.clear();
		List<ResponseMappingEntity> lst = service.getAllResponseMapping();
		lst.forEach((resp) -> mapResponse.put(resp.getResponseCode(), resp.getResponseDesc()));
	}

	@Override
	public CommonStatus generateCommonStatus(String responseCode, String responseDesc) {
		String mappedResponse = mapResponse.get(responseCode);
		if(mappedResponse==null) 
			mappedResponse = responseDesc;
		return new CommonStatus(responseCode, mappedResponse);
	}
	
}
