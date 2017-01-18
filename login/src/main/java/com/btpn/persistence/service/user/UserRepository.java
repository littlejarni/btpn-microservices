package com.btpn.persistence.service.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.persistence.entity.usermanagement.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {
}
