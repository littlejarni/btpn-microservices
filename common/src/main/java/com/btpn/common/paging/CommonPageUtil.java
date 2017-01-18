package com.btpn.common.paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.common.CommonConstant;

@Component
public class CommonPageUtil  {

	@Autowired
	private ApplicationConfig appConfig;

	public CommonPageUtil() {
		
	}

//	public CommonPageUtil(ApplicationConfig appConfig) {
//		this.appConfig = appConfig;
//	}

	public PageRequest generateDefaultPageRequest(int page) {
		int size = getDefaultPageSize();
		return new PageRequest(page, size);
	}

	public PageRequest generateDefaultPageRequest(int page, Direction direction, String... properties) {
		int size = getDefaultPageSize();
		return new PageRequest(page, size, direction, properties);
	}

	public PageRequest generateDefaultPageRequest(int page, Sort sort) {
		int size = getDefaultPageSize();
		return new PageRequest(page, size, sort);
	}
	
	public int getDefaultPageSize() {
		String pageSize = appConfig.getConfig(CommonConstant.APP_PAGING_SIZE_KEY);
		return pageSize!=null?Integer.parseInt(pageSize):10;
	}
}
