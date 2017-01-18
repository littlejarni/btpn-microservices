package com.btpn.wscall.soap;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.wscall.WSCallConstant;

public class FxWsSecurityGenerator {

	@Autowired
	ApplicationConfig appConfig;
	
	public FxWsSecurityHeaderSOAPHandler generateHeaderSOAPHandler() {
		String username = appConfig.getConfig(WSCallConstant.FLEXTERA_USERNAME_DEFAULT_KEY);
		String password = appConfig.getConfig(WSCallConstant.FLEXTERA_PASSWORD_DEFAULT_KEY);
		return generateHeaderSOAPHandler(username, password);
	}
	
	public FxWsSecurityHeaderSOAPHandler generateHeaderSOAPHandler(String username, String password) {
		return new FxWsSecurityHeaderSOAPHandler(username, password);
	}
}