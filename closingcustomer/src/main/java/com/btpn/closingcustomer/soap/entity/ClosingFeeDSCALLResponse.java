package com.btpn.closingcustomer.soap.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClosingFeeDSCALLResponse {

	@XmlRootElement(name = "Item")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Item {
		@XmlElement(name = "PARAMVALUEID")
		String paramValueId;
		@XmlElement(name = "PARAMID")
		String paramId;
		@XmlElement(name = "VALUETYPE")
		String valueType;
		@XmlElement(name = "VALUE1")
		String value1;
		@XmlElement(name = "VALUE2")
		String value2;

		public String getParamId() {
			return paramId;
		}

		public String getParamValueId() {
			return paramValueId;
		}

		public String getValue1() {
			return value1;
		}

		public String getValue2() {
			return value2;
		}

		public String getValueType() {
			return valueType;
		}

		public void setParamId(String paramId) {
			this.paramId = paramId;
		}

		public void setParamValueId(String paramValueId) {
			this.paramValueId = paramValueId;
		}

		public void setValue1(String value1) {
			this.value1 = value1;
		}

		public void setValue2(String value2) {
			this.value2 = value2;
		}

		public void setValueType(String valueType) {
			this.valueType = valueType;
		}
	}

	@XmlRootElement(name = "Result")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Result {
		@XmlElementWrapper(name = "ListItems")
		@XmlElement(name = "Item")
		List<Item> lstItem;

		public List<Item> getLstItem() {
			return lstItem;
		}

		public void setLstItem(List<Item> lstItem) {
			this.lstItem = lstItem;
		}
	}

	@XmlElement(name = "Status")
	String status;
	@XmlElement(name = "ErrorMessage")
	String errorMessage;
	@XmlElement(name = "RetCode")
	String retCode;
	@XmlElement(name = "TOTALCOUNT")
	String totalCount;
	@XmlElement(name = "Result")
	Result result;

	public String getErrorMessage() {
		return errorMessage;
	}

	public Result getResult() {
		return result;
	}

	public String getRetCode() {
		return retCode;
	}

	public String getStatus() {
		return status;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalCaount(String totalCount) {
		this.totalCount = totalCount;
	}
}
