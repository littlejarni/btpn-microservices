package com.btpn.persistence.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.btpn.common.paging.CommonPageUtil;
import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.btpn.response.rest.CommonPaging;


public class RoleDaoServiceImpl implements RoleDaoService {
	
	@Autowired
	RoleRepository repo;
	
	@Autowired
	CommonPageUtil pageUtil;
	
	@Override
	public RoleEntity saveRole(RoleEntity role) {
		return repo.save(role);
	}
	
	@Override
	public CommonPaging<RoleEntity> searchRole(String search, int page) {
		Pageable pageable = pageUtil.generateDefaultPageRequest(page);
		Page<RoleEntity> paging = repo.findByRoleNameContainingOrDescriptionContaining(search, search, pageable);
		return new CommonPaging<RoleEntity>(paging);
	}
	
	@Override
	public RoleEntity getRole(String id) {
		return repo.findOne(id);
	}
}
