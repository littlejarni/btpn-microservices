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

@Entity(name = "JwtRoleMenu")
@Table(name = "sys_jwt_role_menu")
@JsonFilter(JwtRoleMenuEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class JwtRoleMenuEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String JWT_ROLE_MENU_ID_FIELD = "jwtRoleMenuId";
		public static final String JWT_ROLE_FIELD = "jwtRole";
		public static final String MENU_FIELD = "menu";
		public static final String JSON_FILTER = "jsonFilterJwtRoleMenuEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String jwtRoleMenuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jwt_role_code")
	private JwtRoleEntity jwtRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_code")
	private MenuEntity menu;

	public JwtRoleEntity getJwtRole() {
		return jwtRole;
	}

	public String getJwtRoleMenuId() {
		return jwtRoleMenuId;
	}

	public MenuEntity getMenu() {
		return menu;
	}

	public void setJwtRole(JwtRoleEntity jwtRole) {
		this.jwtRole = jwtRole;
	}

	public void setJwtRoleMenuId(String jwtRoleMenuId) {
		this.jwtRoleMenuId = jwtRoleMenuId;
	}

	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}

}
