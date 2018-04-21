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

import fr.school.dao.BatimentDao;
import fr.school.model.Batiment;

@Repository
public class BatimentDaoImpl implements BatimentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Batiment getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Batiment();
		}
		return session.load(Batiment.class, id);
	}

	@Override
	public List<Batiment> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Batiment> criteriaQuery = criteriaBuilder.createQuery(Batiment.class);
		Root<Batiment> batimentRoot = criteriaQuery.from(Batiment.class);
		criteriaQuery.multiselect(batimentRoot.get("id"),batimentRoot.get("libelle"),batimentRoot.get("etage"))
		.orderBy(criteriaBuilder.asc(batimentRoot.get("libelle")));
		Query<Batiment> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Batiment batiment = session.byId(Batiment.class).load(id);
		session.delete(batiment);
	}

	@Override
	public long save(Batiment batiment) {
		sessionFactory.getCurrentSession().save(batiment);
		return batiment.getId();
	}

}
