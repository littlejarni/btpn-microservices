package com.btpn.persistence.service.applicationconfig;

import org.springframework.data.repository.CrudRepository;

import com.btpn.persistence.entity.ApplicationConfigEntity;

public interface ApplicationConfigRepo extends CrudRepository<ApplicationConfigEntity, String>  {

}
