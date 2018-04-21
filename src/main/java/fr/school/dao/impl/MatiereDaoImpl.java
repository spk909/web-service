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

import fr.school.dao.MatiereDao;
import fr.school.model.Matiere;

@Repository
public class MatiereDaoImpl implements MatiereDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Matiere getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Matiere();
		}
		return session.load(Matiere.class, id);
	}
	@Override
	public List<Matiere> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Matiere> criteriaQuery = criteriaBuilder.createQuery(Matiere.class);
		Root<Matiere> matiereRoot = criteriaQuery.from(Matiere.class);
		criteriaQuery.multiselect(matiereRoot.get("id"), matiereRoot.get("nom"),matiereRoot.get("type"))
		.orderBy(criteriaBuilder.asc(matiereRoot.get("nom")));
		Query<Matiere> query = session.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Matiere matiere = session.byId(Matiere.class).load(id);
		session.delete(matiere);

	}

	@Override
	public long save(Matiere matiere) {
		sessionFactory.getCurrentSession().save(matiere);
		return matiere.getId();
	}

}
