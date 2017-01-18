package com.btpn.persistence.service.closingcustomer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.persistence.entity.closingcustomer.ClosingApprovalEntity;

public class ClosingApprovalDaoServiceImpl implements ClosingApprovalDaoService {

	@Autowired
	ClosingApprovalRepository repo;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public ClosingApprovalEntity saveClosingApproval(ClosingApprovalEntity entity) {
		return repo.save(entity);
	}
	
	@Override
	public ClosingApprovalEntity getClosingApproval(String id) {
		return repo.findOne(id);
	}

	@Override
	public ClosingApprovalEntity getClosingApprovalByDocument(String documentId) {
		return repo.findByDocumentId(documentId);
	}

	@Override
	@Transactional
	public int closeClosingApproval(String documentId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaUpdate<ClosingApprovalEntity> updateCrit = builder.createCriteriaUpdate(ClosingApprovalEntity.class);
		Root<ClosingApprovalEntity> root = updateCrit.from(ClosingApprovalEntity.class);
		
		updateCrit.set(root.get(ClosingApprovalEntity.Constant.STATUS_FIELD), ClosingCustomerConstant.CLOSED_STATUS);
		
		updateCrit.where(builder.equal(root.get(ClosingApprovalEntity.Constant.DOCUMENT_ID_FIELD), documentId));
		
		return em.createQuery(updateCrit).executeUpdate();
	}
}
