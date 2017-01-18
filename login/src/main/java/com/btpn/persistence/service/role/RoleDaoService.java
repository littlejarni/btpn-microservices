package com.btpn.persistence.service.role;

import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.btpn.response.rest.CommonPaging;

public interface RoleDaoService {
	RoleEntity getRole(String id);

	RoleEntity saveRole(RoleEntity role);

	CommonPaging<RoleEntity> searchRole(String search, int page);
}
