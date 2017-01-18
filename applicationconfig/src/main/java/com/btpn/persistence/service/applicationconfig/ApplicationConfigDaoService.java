package com.btpn.persistence.service.applicationconfig;

import java.util.List;

import com.btpn.persistence.entity.ApplicationConfigEntity;

public interface ApplicationConfigDaoService {
	List<ApplicationConfigEntity> getAllApplicationConfig();
}
