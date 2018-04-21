package fr.school.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.school.dao.FormationDao;
import fr.school.model.Formation;

@Repository
public class FormationDaoImpl implements FormationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Formation getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Formation();
		}
		return session.load(Formation.class, id);
	}

	@Override
	public List<Formation> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Formation> criteriaQuery = criteriaBuilder.createQuery(Formation.class);
		Root<Formation> formation = criteriaQuery.from(Formation.class);
		criteriaQuery.select(formation);
		criteriaQuery.orderBy(criteriaBuilder.asc(formation.get("nom")));
		Query<Formation> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Formation formation = session.byId(Formation.class).load(id);
		session.delete(formation);
		
	}

	@Override
	public long save(Formation formation) {
		sessionFactory.getCurrentSession().save(formation);
		return formation.getId();
	}

	
}
