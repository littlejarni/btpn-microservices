package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.btpn.persistence.auth.entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "UserRole")
@Table(name = "sys_user_role")
@JsonFilter(UserRoleEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class UserRoleEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String USER_ROLE_ID_FIELD = "userRoleId";
		public static final String USER_FIELD = "user";
		public static final String ROLE_FIELD = "role";
		public static final String JSON_FILTER = "jsonFilterUserRoleEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String userRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	private UserEntity user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleEntity role;

	public UserRoleEntity() {
		super();
	}

	public RoleEntity getRole() {
		return role;
	}

	public UserEntity getUser() {
		return user;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

}
