package com.plot.commute.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.plot.commute.entity.LandDetail;
import com.plot.commute.entity.Venture;
import com.plot.commute.repository.dao.LandDao;

@Repository
public class LandDaoImpl implements LandDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<LandDetail> findLandsByVentureId(Long ventureId) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<LandDetail> query = cb.createQuery(LandDetail.class);
		Root<LandDetail> landDetail = query.from(LandDetail.class);
		Join<LandDetail, Venture> Venturejoin = landDetail.join("venture");
		query.select(landDetail).where(cb.gt(Venturejoin.get("id"), ventureId));
		TypedQuery<LandDetail> typedQuery = this.entityManager.createQuery(query);
		return typedQuery.getResultList();
	}
}
