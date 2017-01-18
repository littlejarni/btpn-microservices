package com.btpn.response;

import com.btpn.response.rest.CommonStatus;



public interface ResponseMapping {
	void reloadResponseMapping();
	CommonStatus generateCommonStatus(String responseCode, String responseDesc);
}
