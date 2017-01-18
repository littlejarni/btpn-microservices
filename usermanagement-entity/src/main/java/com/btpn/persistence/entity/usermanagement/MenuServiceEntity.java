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

@Entity(name = "MenuService")
@Table(name = "sys_menu_service")
@JsonFilter(MenuServiceEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class MenuServiceEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String MENU_SERVICE_ID_FIELD = "menuServiceId";
		public static final String MENU_FIELD = "menu";
		public static final String SERVICE_FIELD = "service";
		public static final String JSON_FILTER = "jsonFilterMenuServiceEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String menuServiceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_code")
	private MenuEntity menu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_code")
	private RoleEntity service;

	public MenuEntity getMenu() {
		return menu;
	}

	public String getMenuServiceId() {
		return menuServiceId;
	}

	public RoleEntity getService() {
		return service;
	}

	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}

	public void setMenuServiceId(String menuServiceId) {
		this.menuServiceId = menuServiceId;
	}

	public void setService(RoleEntity service) {
		this.service = service;
	}

}
