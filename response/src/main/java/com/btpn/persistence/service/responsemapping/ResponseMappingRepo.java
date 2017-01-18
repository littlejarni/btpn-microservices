package com.btpn.persistence.service.responsemapping;

import org.springframework.data.repository.CrudRepository;

import com.btpn.persistence.entity.ResponseMappingEntity;

public interface ResponseMappingRepo extends CrudRepository<ResponseMappingEntity, String>  {

}
