package fr.school.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.school.dao.AbsenceDao;
import fr.school.model.Absence;

@Repository
public class AbsenceDaoImpl implements AbsenceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Absence getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Absence();
		}
		return session.load(Absence.class, id);
	}

	@Override
	public List<Absence> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Absence absence = session.byId(Absence.class).load(id);
		session.delete(absence);
	}

	@Override
	public long save(Absence absence) {
		sessionFactory.getCurrentSession().save(absence);
		return absence.getId();
	}

	@Override
	public List<Absence> listAbsenceByDateOfTheDay() {
		Calendar myCal = Calendar.getInstance();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Absence> criteriaQuery = builder.createQuery(Absence.class);
		Root<Absence> absenceRoot = criteriaQuery.from(Absence.class);
		criteriaQuery.multiselect(absenceRoot.get("date_debut_absence"), absenceRoot.get("date_fin_absence"),
				absenceRoot.get("motif")).where(builder.equal(absenceRoot.get("date_debut_absence"), myCal));
		criteriaQuery.orderBy(builder.asc(absenceRoot.get("date_debut_absence")));
		Query<Absence> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Absence> listAbsenceEleveById(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Absence> criteriaQuery = builder.createQuery(Absence.class);
		Root<Absence> absenceRoot = criteriaQuery.from(Absence.class);
		criteriaQuery.multiselect(absenceRoot.get("id"),absenceRoot.get("date_debut_absence"), absenceRoot.get("date_fin_absence"),
				absenceRoot.get("motif")).where(builder.equal(absenceRoot.get("utilisateur"), id));
		criteriaQuery.orderBy(builder.asc(absenceRoot.get("date_debut_absence")));
		Query<Absence> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void updateRetard(long id, Absence absence) {
		Session session = sessionFactory.getCurrentSession();
		Absence absenceToUpdate = session.byId(Absence.class).load(id);
		absenceToUpdate.setDate_debut_absence(absence.getDate_debut_absence());
		absenceToUpdate.setDate_fin_absence(absence.getDate_fin_absence());
		absenceToUpdate.setMotif(absence.getMotif());
		session.flush();
	}

}
