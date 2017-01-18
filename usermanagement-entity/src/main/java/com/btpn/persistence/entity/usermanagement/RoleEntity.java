package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.btpn.persistence.auth.entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "Role")
@Table(name = "sys_role")
@JsonFilter(RoleEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class RoleEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String ROLE_ID_FIELD = "roleId";
		public static final String ROLE_NAME_FIELD = "roleName";
		public static final String DESCRIPTION_FIELD = "description";
		public static final String USER_ROLES_FIELD = "userRoles";
		public static final String ROLE_MENUS_FIELD = "roleMenus";
		public static final String ROLE_SERVICES_FIELD = "roleServices";
		public static final String JSON_FILTER = "jsonFilterRoleEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String roleId;

	private String roleName;
	private String description;

	@OneToMany(mappedBy = "role")
	private List<UserRoleEntity> userRoles;

	@OneToMany(mappedBy = "role")
	private List<RoleServiceEntity> roleServices;

	@OneToMany(mappedBy = "role")
	private List<RoleMenuEntity> roleMenus;

	public RoleEntity() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public String getRoleId() {
		return roleId;
	}

	public List<RoleMenuEntity> getRoleMenus() {
		return roleMenus;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<RoleServiceEntity> getRoleServices() {
		return roleServices;
	}

	public List<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleMenus(List<RoleMenuEntity> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleServices(List<RoleServiceEntity> roleServices) {
		this.roleServices = roleServices;
	}

	public void setUserRoles(List<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}

}
