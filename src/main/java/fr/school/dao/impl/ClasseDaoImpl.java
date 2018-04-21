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

import fr.school.dao.ClasseDao;
import fr.school.model.Classe;

@Repository
public class ClasseDaoImpl implements ClasseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Classe getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Classe();
		}
		return session.load(Classe.class, id);
	}

	@Override
	public List<Classe> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Classe> criteriaQuery = criteriaBuilder.createQuery(Classe.class);
		Root<Classe> classeRoot = criteriaQuery.from(Classe.class);
		criteriaQuery.multiselect(classeRoot.get("id"),classeRoot.get("libelle"));
		criteriaQuery.orderBy(criteriaBuilder.asc(classeRoot.get("libelle")));
		Query<Classe> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Classe classe = session.byId(Classe.class).load(id);
		session.delete(classe);
		
	}

	@Override
	public long save(Classe classe) {
		sessionFactory.getCurrentSession().save(classe);
		return classe.getId();
	}

	

}
