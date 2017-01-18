package com.btpn.persistence.service.user;

import com.btpn.persistence.entity.usermanagement.UserEntity;


public interface UserDaoService {
	UserEntity getUsersByName(String name);

//	int countUserList(String search);
//
//	List<UserEntity> getUserList(String search, int startRow, int pageSize);
//
//	CommonPaging<UserEntity> getUserPaging(String search, int page);
}
