package com.btpn.applicationconfig;


public interface ApplicationConfig {
	void reloadConfig();
	String getConfig(String key);
}
