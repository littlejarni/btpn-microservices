package com.btpn.persistence.service.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.btpn.persistence.entity.usermanagement.JwtRoleEntity;
import com.btpn.persistence.entity.usermanagement.JwtRoleMenuEntity;
import com.btpn.persistence.entity.usermanagement.MenuEntity;
import com.btpn.persistence.entity.usermanagement.MenuServiceEntity;
import com.btpn.persistence.entity.usermanagement.RoleEntity;
import com.btpn.persistence.entity.usermanagement.RoleMenuEntity;
import com.btpn.persistence.entity.usermanagement.RoleServiceEntity;
import com.btpn.persistence.entity.usermanagement.ServiceEntity;
import com.btpn.persistence.entity.usermanagement.UserEntity;
import com.btpn.persistence.entity.usermanagement.UserRoleEntity;

public class ServiceDaoServiceImpl implements ServiceDaoService {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<ServiceEntity> getMenuServicesByUser(String userName) {
		CriteriaBuilder critBuilder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceEntity> query = critBuilder.createQuery(ServiceEntity.class);
		Root<ServiceEntity> root = query.from(ServiceEntity.class);
		Join<ServiceEntity, MenuServiceEntity> joinMS = root.join(ServiceEntity.Constant.MENU_SERVICES_FIELD);
		Join<RoleServiceEntity, MenuEntity> joinMenu = joinMS.join(MenuServiceEntity.Constant.MENU_FIELD);
		Join<ServiceEntity, RoleMenuEntity> joinRM = joinMenu.join(MenuEntity.Constant.ROLE_MENUS_FIELD);
		Join<RoleServiceEntity, RoleEntity> joinRole = joinRM.join(RoleMenuEntity.Constant.ROLE_FIELD);
		Join<RoleServiceEntity, UserRoleEntity> joinRE = joinRole.join(RoleEntity.Constant.USER_ROLES_FIELD);
		Join<RoleServiceEntity, UserEntity> joinUser = joinRE.join(UserRoleEntity.Constant.USER_FIELD);

		List<Predicate> lstWhere = new ArrayList<Predicate>();
		lstWhere.add(critBuilder.equal(joinUser.get(UserEntity.Constant.USER_NAME_FIELD), userName));

		query.select(root)
				.where(lstWhere.toArray(new Predicate[] {}));

		return em.createQuery(query).getResultList();
	}

	@Override
	public List<ServiceEntity> getRoleServicesByUser(String userName) {
		CriteriaBuilder critBuilder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceEntity> query = critBuilder.createQuery(ServiceEntity.class);
		Root<ServiceEntity> root = query.from(ServiceEntity.class);
		Join<ServiceEntity, RoleServiceEntity> joinRS = root.join(ServiceEntity.Constant.ROLE_SERVICES_FIELD);
		Join<RoleServiceEntity, RoleEntity> joinRole = joinRS.join(RoleServiceEntity.Constant.ROLE_FIELD);
		Join<RoleServiceEntity, UserRoleEntity> joinRE = joinRole.join(RoleEntity.Constant.USER_ROLES_FIELD);
		Join<RoleServiceEntity, UserEntity> joinUser = joinRE.join(UserRoleEntity.Constant.USER_FIELD);

		List<Predicate> lstWhere = new ArrayList<Predicate>();
		lstWhere.add(critBuilder.equal(joinUser.get(UserEntity.Constant.USER_NAME_FIELD), userName));

		query.select(root)
				.where(lstWhere.toArray(new Predicate[] {}));

		return em.createQuery(query).getResultList();
	}

	@Override
	public Set<ServiceEntity> getServicesByJwtRole(String roleCode) {
		CriteriaBuilder critBuilder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceEntity> query = critBuilder.createQuery(ServiceEntity.class);
		Root<ServiceEntity> root = query.from(ServiceEntity.class);
		Join<ServiceEntity, MenuServiceEntity> joinMS = root.join(ServiceEntity.Constant.MENU_SERVICES_FIELD);
		Join<RoleServiceEntity, MenuEntity> joinMenu = joinMS.join(MenuServiceEntity.Constant.MENU_FIELD);
		Join<ServiceEntity, JwtRoleMenuEntity> joinRM = joinMenu.join(MenuEntity.Constant.JWT_ROLE_MENUS_FIELD);
		Join<RoleServiceEntity, JwtRoleEntity> joinRole = joinRM.join(JwtRoleMenuEntity.Constant.JWT_ROLE_FIELD);

		List<Predicate> lstWhere = new ArrayList<Predicate>();
		lstWhere.add(critBuilder.equal(joinRole.get(JwtRoleEntity.Constant.JWT_ROLE_CODE_FIELD), roleCode));

		query.select(root)
				.where(lstWhere.toArray(new Predicate[] {}));

		Set<ServiceEntity> setService = new HashSet<ServiceEntity>();
		setService.addAll(em.createQuery(query).getResultList());
		
		return setService;
	}

	@Override
	public Set<ServiceEntity> getServicesByUser(String userName) {
		Set<ServiceEntity> setService = new HashSet<ServiceEntity>();

		setService.addAll(getRoleServicesByUser(userName));
		setService.addAll(getMenuServicesByUser(userName));

		return setService;
	}

}
