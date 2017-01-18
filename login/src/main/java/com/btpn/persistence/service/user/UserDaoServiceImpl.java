package com.btpn.persistence.service.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btpn.persistence.entity.usermanagement.UserEntity;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	@PersistenceContext
	EntityManager em;

	@Autowired
	UserRepository repo;
	
	@Override
	public UserEntity getUsersByName(String name) {
		return repo.findOne(name);
	}

//	@Autowired
//	private CommonPageUtil pageUtil;

//	private Predicate[] createSearchPredicate(Root<UserEntity> rootUser, String search) {
//		CriteriaBuilder critB = em.getCriteriaBuilder();
//
//		List<Predicate> lstPredicate = new ArrayList<Predicate>();
//		lstPredicate.add(
//				critB.or(
//						critB.like(rootUser.get(UserEntity.Constant.USER_NAME_FIELD), "%" + search + "%"),
//						critB.like(rootUser.get(UserEntity.Constant.NAME_FIELD), "%" + search + "%")
//						)
//				);
//		return lstPredicate.toArray(new Predicate[0]);
//	}

//	@Override
//	public CommonPaging<UserEntity> getUserPaging(String search, int page) {
//		CommonPaging<UserEntity> usrPaging = new CommonPaging<UserEntity>();
//		int rowPerPage = pageUtil.getDefaultPageSize();
//		usrPaging.setPage(page);
//		usrPaging.setRowPerPage(rowPerPage);
//		usrPaging.setTotalData(countUserList(search));
//		usrPaging.setData(getUserList(search, usrPaging.getStartRow(), rowPerPage));
//		return usrPaging;
//	}
//
//	@Override
//	public List<UserEntity> getUserList(String search, int startRow, int rowPerPage) {
//		CriteriaBuilder critB = em.getCriteriaBuilder();
//
//		CriteriaQuery<UserEntity> query = critB.createQuery(UserEntity.class);
//		Root<UserEntity> rootUser = query.from(UserEntity.class);
//		query.select(rootUser)
//				.where(createSearchPredicate(rootUser, search));
//
//		TypedQuery<UserEntity> q = em.createQuery(query);
//		q.setFirstResult(startRow);
//		q.setMaxResults(rowPerPage);
//
//		return q.getResultList();
//	}
//
//	@Override
//	public int countUserList(String search) {
//		CriteriaBuilder critB = em.getCriteriaBuilder();
//
//		CriteriaQuery<Long> query = critB.createQuery(Long.class);
//		Root<UserEntity> rootUser = query.from(UserEntity.class);
//		query.select(critB.count(rootUser))
//				.where(createSearchPredicate(rootUser, search));
//
//		return em.createQuery(query).getSingleResult().intValue();
//	}
//
}
