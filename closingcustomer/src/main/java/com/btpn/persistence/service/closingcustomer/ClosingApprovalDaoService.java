package com.btpn.persistence.service.closingcustomer;

import com.btpn.persistence.entity.closingcustomer.ClosingApprovalEntity;

public interface ClosingApprovalDaoService {

	public ClosingApprovalEntity saveClosingApproval(ClosingApprovalEntity entity);

	ClosingApprovalEntity getClosingApproval(String id);
	
	ClosingApprovalEntity getClosingApprovalByDocument(String documentId);

	int closeClosingApproval(String documentId);
	
	
}
