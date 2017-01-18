package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.btpn.persistence.auth.entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "JwtRoleEntity")
@Table(name = "sys_jwt_role")
@JsonFilter(JwtRoleEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class JwtRoleEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String JWT_ROLE_CODE_FIELD = "jwtRoleCode";
		public static final String JWT_ROLE_NAME_FIELD = "jwtRoleName";
		public static final String DESCRIPTION_FIELD = "description";
		public static final String JWT_ROLE_MENUS_FIELD = "jwtRolesMenus";
		public static final String JSON_FILTER = "jsonFilterJwtRoleEntity";
	}

	@Id
	private String jwtRoleCode;

	private String jwtRoleName;
	private String description;

	@OneToMany(mappedBy = "jwtRole")
	private List<JwtRoleMenuEntity> jwtRoleMenus;

	public JwtRoleEntity() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public String getJwtRoleCode() {
		return jwtRoleCode;
	}

	public List<JwtRoleMenuEntity> getJwtRoleMenus() {
		return jwtRoleMenus;
	}

	public String getJwtRoleName() {
		return jwtRoleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setJwtRoleCode(String jwtRoleCode) {
		this.jwtRoleCode = jwtRoleCode;
	}

	public void setJwtRoleMenus(List<JwtRoleMenuEntity> jwtRoleMenus) {
		this.jwtRoleMenus = jwtRoleMenus;
	}

	public void setJwtRoleName(String jwtRoleName) {
		this.jwtRoleName = jwtRoleName;
	}

}
