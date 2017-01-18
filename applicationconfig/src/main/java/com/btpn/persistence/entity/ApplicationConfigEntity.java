package com.btpn.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ApplicationConfiguration")
@Table(name = "sys_app_config")
public class ApplicationConfigEntity {

	public interface Constant {
		public static final String CONFIG_KEY_FIELD = "configKey";
		public static final String CONFIG_VALUE_FIELD = "configValue";
	}

	@Id
	String configKey;

	String configValue;

	public ApplicationConfigEntity() {
	}

	public ApplicationConfigEntity(String configKey, String configValue) {
		this.configKey = configKey;
		this.configValue = configValue;
	}

	public String getConfigKey() {
		return configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
}
