package com.btpn.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "RunningNumber")
@Table(name = "sys_running_number")
@JsonFilter(RunningNumberEntity.Constant.JSON_FILTER)
@SuppressWarnings("serial")
public class RunningNumberEntity implements Serializable {

	public interface Constant {
		public static final String START_FIELD = "start";
		public static final String END_FIELD = "end";
		public static final String CURRENT_FIELD = "current";
		public static final String interval_FIELD = "interval";
		public static final String JSON_FILTER = "jsonFilterRunningNumberEntity";
	}

	@Id
	private String runningNumberCode;

	private Integer start;
	private Integer end;
	private Integer current;
	private Integer cacheInterval;

	public Integer getCacheInterval() {
		return cacheInterval;
	}

	public void setCacheInterval(Integer cacheInterval) {
		this.cacheInterval = cacheInterval;
	}

	public Integer getCurrent() {
		return current;
	}

	public Integer getEnd() {
		return end;
	}

	public String getRunningNumberCode() {
		return runningNumberCode;
	}

	public Integer getStart() {
		return start;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setRunningNumberCode(String runningNumberCode) {
		this.runningNumberCode = runningNumberCode;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

}
