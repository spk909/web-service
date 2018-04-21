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

import fr.school.dao.RetardDao;
import fr.school.model.Retard;

@Repository
public class RetardDaoImpl implements RetardDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Retard getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Retard();
		}
		return session.load(Retard.class, id);
	}

	@Override
	public List<Retard> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Retard retard = session.byId(Retard.class).load(id);
		session.delete(retard);

	}

	@Override
	public long save(Retard retard) {
		sessionFactory.getCurrentSession().save(retard);
		return retard.getId();
	}

	@Override
	public List<Retard> listRetardById(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Retard> criteriaQuery = builder.createQuery(Retard.class);
		Root<Retard> retardRoot = criteriaQuery.from(Retard.class);
		criteriaQuery.multiselect(retardRoot.get("id"),retardRoot.get("date_retard"),retardRoot.get("duree_retard"),retardRoot.get("motif"))
		.where(builder.equal(retardRoot.get("utilisateur"),id));
		criteriaQuery.orderBy(builder.asc(retardRoot.get("date_retard")));
		Query<Retard> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void updateRetard(long id, Retard retard) {
		Session session = sessionFactory.getCurrentSession();
		Retard retardToUpdate = session.byId(Retard.class).load(id);
		retardToUpdate.setDuree_retard(retard.getDuree_retard());
		retardToUpdate.setMotif(retard.getMotif());
		session.flush();
		
		
	}

}
