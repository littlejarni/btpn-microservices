package com.btpn.persistence.service.closingcustomer;

import org.springframework.data.repository.CrudRepository;

import com.btpn.persistence.entity.closingcustomer.ClosingApprovalEntity;

public interface ClosingApprovalRepository extends CrudRepository<ClosingApprovalEntity, String> {
	
	ClosingApprovalEntity findByDocumentId(String documentId);

}
