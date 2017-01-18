package com.btpn.persistence.service.runningnumber;


public interface RunningNumberService {

	int getRunningNumber() throws Exception;
	int getRunningNumber(String runningNumberCode) throws Exception;
	void reloadRunningNumber(String code) throws Exception;
	
	
}
