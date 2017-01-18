package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.btpn.persistence.auth.entity.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "Menu")
@Table(name = "sys_menu")
@JsonFilter(MenuEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class MenuEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String MENU_CODE_FIELD = "menuCode";
		public static final String URL_FIELD = "url";
		public static final String DESCRIPTION_FIELD = "description";
		public static final String ORDER_FIELD = "order";
		public static final String ROLE_MENUS_FIELD = "roleMenus";
		public static final String JWT_ROLE_MENUS_FIELD = "jwtRoleMenus";
		public static final String MENU_SERVICES_FIELD = "menuServices";
		public static final String JSON_FILTER = "jsonFilterMenuEntity";
	}

	@Id
	private String menuCode;

	private String url;
	private String description;
	private String order;

	@OneToMany(mappedBy = "menu")
	private List<RoleMenuEntity> roleMenus;

	@OneToMany(mappedBy = "menu")
	private List<JwtRoleMenuEntity> jwtRoleMenus;

	@OneToMany(mappedBy = "menu")
	private List<MenuServiceEntity> menuServices;

	public MenuEntity() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public List<JwtRoleMenuEntity> getJwtRoleMenus() {
		return jwtRoleMenus;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public List<MenuServiceEntity> getMenuServices() {
		return menuServices;
	}

	public String getOrder() {
		return order;
	}

	public List<RoleMenuEntity> getRoleMenus() {
		return roleMenus;
	}

	public String getUrl() {
		return url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setJwtRoleMenus(List<JwtRoleMenuEntity> jwtRoleMenus) {
		this.jwtRoleMenus = jwtRoleMenus;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public void setMenuServices(List<MenuServiceEntity> menuServices) {
		this.menuServices = menuServices;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setRoleMenus(List<RoleMenuEntity> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
