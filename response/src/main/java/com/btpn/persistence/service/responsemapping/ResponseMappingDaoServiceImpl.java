package com.btpn.persistence.service.responsemapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.persistence.entity.ResponseMappingEntity;

public class ResponseMappingDaoServiceImpl implements ResponseMappingDaoService {

	@Autowired
	ResponseMappingRepo appConfRepo;
	
	@Override
	public List<ResponseMappingEntity> getAllResponseMapping() {
		List<ResponseMappingEntity> lst =  new ArrayList<ResponseMappingEntity>();
		appConfRepo.findAll().forEach((resp) -> lst.add(resp));
		return lst;
	}

}
