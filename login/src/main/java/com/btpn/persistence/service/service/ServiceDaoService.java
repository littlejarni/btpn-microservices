package com.btpn.persistence.service.service;

import java.util.List;
import java.util.Set;

import com.btpn.persistence.entity.usermanagement.ServiceEntity;

public interface ServiceDaoService {

	List<ServiceEntity> getMenuServicesByUser(String userName);

	List<ServiceEntity> getRoleServicesByUser(String userName);

	Set<ServiceEntity> getServicesByUser(String userName);

	Set<ServiceEntity> getServicesByJwtRole(String roleName);

}
