package com.btpn.applicationconfig;

import java.util.HashMap;
import java.util.List;

import com.btpn.logging.annotation.Logging;
import com.btpn.persistence.entity.ApplicationConfigEntity;
import com.btpn.persistence.service.applicationconfig.ApplicationConfigDaoService;


public class ApplicationConfigDBImpl implements ApplicationConfig{
	private HashMap<String, String> mapConfig = new HashMap<String, String>();
	
	ApplicationConfigDaoService appConfigService;
	
	public ApplicationConfigDBImpl(ApplicationConfigDaoService appConfigService) {
		this.appConfigService = appConfigService;
		reloadConfig();
	}
	
	@Override
	@Logging
	public void reloadConfig() {
		mapConfig.clear();
		List<ApplicationConfigEntity> lst = appConfigService.getAllApplicationConfig();
		lst.forEach((appConf) -> mapConfig.put(appConf.getConfigKey(), appConf.getConfigValue()));
	}

	@Override
	public String getConfig(String key) {
		return mapConfig.get(key);
	}

}
