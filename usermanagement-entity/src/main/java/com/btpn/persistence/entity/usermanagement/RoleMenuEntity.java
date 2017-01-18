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

@Entity(name = "RoleMenu")
@Table(name = "sys_role_menu")
@JsonFilter(RoleMenuEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class RoleMenuEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String ROLE_MENU_ID_FIELD = "roleMenuId";
		public static final String ROLE_FIELD = "role";
		public static final String MENU_FIELD = "menu";
		public static final String JSON_FILTER = "jsonFilterRoleMenuEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String roleMenuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleEntity role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_code")
	private MenuEntity menu;

	public MenuEntity getMenu() {
		return menu;
	}

	public RoleEntity getRole() {
		return role;
	}

	public String getRoleMenuId() {
		return roleMenuId;
	}

	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public void setRoleMenuId(String roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

}
