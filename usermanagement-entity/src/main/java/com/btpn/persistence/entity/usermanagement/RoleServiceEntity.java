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

@Entity(name = "RoleService")
@Table(name = "sys_role_service")
@JsonFilter(RoleServiceEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class RoleServiceEntity extends AuditEntity implements Serializable {

	public interface Constant {
		public static final String ROLE_SERVICE_ID_FIELD = "roleServiceId";
		public static final String ROLE_FIELD = "role";
		public static final String SERVICE_FIELD = "service";
		public static final String JSON_FILTER = "jsonFilterRoleServiceEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String roleServiceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_code")
	private ServiceEntity service;

	public RoleEntity getRole() {
		return role;
	}

	public String getRoleServiceId() {
		return roleServiceId;
	}

	public ServiceEntity getService() {
		return service;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public void setRoleServiceId(String roleServiceId) {
		this.roleServiceId = roleServiceId;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}
}
