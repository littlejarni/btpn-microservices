package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.btpn.persistence.auth.entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "User")
@Table(name = "sys_user")
@JsonFilter(UserEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class UserEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String USER_NAME_FIELD = "userName";
		public static final String NAME_FIELD = "name";
		public static final String PASSWORD_FIELD = "password";
		public static final String ENGINE_FIELD = "engine";
		public static final String USER_ROLES_FIELD = "userRoles";
		public static final String JSON_FILTER = "jsonFilterUserEntity";
	}

	@Id
	private String userName;

	private String name;
	private String password;
	private String engine;

	@OneToMany(mappedBy = "user")
	private List<UserRoleEntity> userRoles;

	public UserEntity() {
	}

	public UserEntity(String userName, String name, String password) {
		this.userName = userName;
		this.name = name;
		this.password = password;
	}

	public String getEngine() {
		return engine;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public List<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserRoles(List<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}
}
