package com.btpn.persistence.entity.closingcustomer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity(name = "ClosingApproval")
@Table(name = "cls_closing_approval")
@JsonFilter(RoleEntity.Constant.JSON_FILTER)
public class ClosingApprovalEntity {

	public interface Constant {
		public static final String CLOSING_APPROVAL_ID_FIELD = "closingApprovalId";
		public static final String DOCUMENT_ID_FIELD = "documentId";
		public static final String STATUS_FIELD = "status";
		public static final String DATA_FIELD = "data";
		public static final String JSON_FILTER = "jsonFilterClosingApprovalEntity";
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String closingApprovalId;

	private String documentId;
	private String status;
	private String data;

	public String getClosingApprovalId() {
		return closingApprovalId;
	}

	public String getData() {
		return data;
	}

	public String getDocumentId() {
		return documentId;
	}

	public String getStatus() {
		return status;
	}

	public void setClosingApprovalId(String closingApprovalId) {
		this.closingApprovalId = closingApprovalId;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
