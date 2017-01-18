package com.btpn.persistence.auth.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity implements Serializable {

	public interface Constant {
		public static final String CREATED_BY_FIELD = "createdBy";
		public static final String CREATED_DATE_FIELD = "createdDate";
		public static final String MODIFIED_BY_FIELD = "createdBy";
		public static final String MODIFIED_DATE_FIELD = "modifiedDate";
	}
	
	@CreatedBy
	@Column(updatable=false)
	private String createdBy;
	@CreatedDate
	@Column(updatable=false)
	private Date createdDate;

	@LastModifiedBy
	private String modifiedBy;
	@LastModifiedDate
	private Date modifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
