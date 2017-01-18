package com.btpn.persistence.service.role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.persistence.entity.usermanagement.RoleEntity;

public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, String> {
	
	Page<RoleEntity> findByRoleNameContainingOrDescriptionContaining(String firstName, String roleName, Pageable page);
}
