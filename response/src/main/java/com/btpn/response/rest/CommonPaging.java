package com.btpn.response.rest;

import java.util.List;

import org.springframework.data.domain.Page;

public class CommonPaging<T> {
	List<T> data;

	int page;
	int rowPerPage;
	long totalData;

	public CommonPaging() {

	}

	public CommonPaging(Page<T> paging) {
		page = paging.getNumber();
		rowPerPage = paging.getSize();
		totalData = paging.getTotalElements();
		data = paging.getContent();
	}

	public List<T> getData() {
		return data;
	}

	public int getPage() {
		return page;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public int getStartRow() {
		return page * rowPerPage;
	}

	public long getTotalData() {
		return totalData;
	}

	public long getTotalPage() {
		return ((totalData-1)/rowPerPage) + 1;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}

}
