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

import fr.school.dao.SalleDao;
import fr.school.model.Salle;

@Repository
public class SalleDaoImpl implements SalleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Salle getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Salle();
		}
		return session.load(Salle.class, id);
	}


	@Override
	public List<Salle> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Salle> criteriaQuery = criteriaBuilder.createQuery(Salle.class);
		Root<Salle> salleRoot = criteriaQuery.from(Salle.class);
		criteriaQuery.multiselect(salleRoot.get("id"),salleRoot.get("numero"))
		.orderBy(criteriaBuilder.asc(salleRoot.get("numero")));
		Query<Salle> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Salle salle = session.byId(Salle.class).load(id);
		session.delete(salle);		
	}

	@Override
	public long save(Salle salle) {
	 sessionFactory.getCurrentSession().save(salle);
		return salle.getId();
	}

}
