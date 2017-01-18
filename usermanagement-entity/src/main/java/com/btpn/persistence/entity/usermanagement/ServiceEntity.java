package com.btpn.persistence.entity.usermanagement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "Service")
@Table(name = "sys_service")
@JsonFilter(ServiceEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class ServiceEntity implements Serializable {

	public interface Constant {
		public static final String SERVICE_CODE_FIELD = "serviceCode";
		public static final String ROLE_SERVICES_FIELD = "roleServices";
		public static final String MENU_SERVICES_FIELD = "menuServices";
		public static final String JSON_FILTER = "jsonFilterServiceEntity";
	}

	@Id
	private String serviceCode;

	@OneToMany(mappedBy = "service")
	private List<RoleServiceEntity> roleServices;

	@OneToMany(mappedBy = "service")
	private List<MenuServiceEntity> menuServices;

	public List<RoleServiceEntity> getRoleServices() {
		return roleServices;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setRoleServices(List<RoleServiceEntity> roleServices) {
		this.roleServices = roleServices;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
