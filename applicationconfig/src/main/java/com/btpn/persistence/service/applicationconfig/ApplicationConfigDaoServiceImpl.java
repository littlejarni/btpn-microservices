package com.btpn.persistence.service.applicationconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.persistence.entity.ApplicationConfigEntity;

public class ApplicationConfigDaoServiceImpl implements ApplicationConfigDaoService {

	@Autowired
	ApplicationConfigRepo appConfRepo;
	
	@Override
	public List<ApplicationConfigEntity> getAllApplicationConfig() {
		List<ApplicationConfigEntity> lst =  new ArrayList<ApplicationConfigEntity>();
		appConfRepo.findAll().forEach((appConf) -> lst.add(appConf));
		return lst;
	}

}
