package fr.school.dao.impl;


import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.school.dao.CoursDao;
import fr.school.model.Classe;
import fr.school.model.Cours;
import fr.school.model.Utilisateur;

@Repository
public class CoursDaoImpl implements CoursDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Cours getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Cours();
		}
		return session.load(Cours.class, id);
	}

	@Override
	public List<Cours> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Cours cours = session.byId(Cours.class).load(id);
		session.delete(cours);

	}

	@Override
	public long save(Cours cours) {
		sessionFactory.getCurrentSession().save(cours);
		return cours.getId();
	}

	@Override
	public List<Cours> getCoursByClasseId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getCoursByDate(Date date) {
		
		return null;
	}

	

	@Override
	public List<Cours> getCoursByDateAndByClasseId(Date debut,Date fin, long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Cours> criteriaQuery = criteriaBuilder.createQuery(Cours.class);
		Root<Cours> coursRoot = criteriaQuery.from(Cours.class);
		Join<Cours,Classe> classeRoot= coursRoot.join("classe",JoinType.LEFT);
		criteriaQuery.multiselect(coursRoot.get("id"),coursRoot.get("libelle")
				,coursRoot.get("commentaire"),coursRoot.get("dateDebutCours"),
				coursRoot.get("dateFinCours"),
				coursRoot.get("tranche_horaire"),coursRoot.get("examen"),
				coursRoot.get("matiere"),
				coursRoot.get("utilisateur"),coursRoot.get("salle"));
		
		criteriaQuery.where(criteriaBuilder.equal(classeRoot.get("id"), id),criteriaBuilder.
		between(coursRoot.get("dateDebutCours"), debut, fin));	
		criteriaQuery.orderBy(criteriaBuilder.asc(coursRoot.get("dateDebutCours")));
		Query<Cours> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	@Override
	public List<Cours> getCoursByDateAndByProfId(Date debut, Date fin, long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Cours> criteriaQuery = criteriaBuilder.createQuery(Cours.class);
		Root<Cours> coursRoot = criteriaQuery.from(Cours.class);
		Join<Cours, Utilisateur>userRoot= coursRoot.join("utilisateur",JoinType.LEFT);
		criteriaQuery.multiselect(coursRoot.get("id"),coursRoot.get("libelle")
				,coursRoot.get("commentaire"),coursRoot.get("dateDebutCours"),
				coursRoot.get("dateFinCours"),
				coursRoot.get("tranche_horaire"),
				coursRoot.get("examen"),
				coursRoot.get("classe"),
				coursRoot.get("salle"));
		criteriaQuery.where(criteriaBuilder.equal(userRoot.get("id"), id),criteriaBuilder.
		between(coursRoot.get("dateDebutCours"), debut, fin));	
		criteriaQuery.orderBy(criteriaBuilder.asc(coursRoot.get("dateDebutCours")));
		Query<Cours> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	



	@Override
	public void updateCours(long id, Cours cours) {
		Session session = sessionFactory.getCurrentSession();
		Cours coursToUpadate = session.byId(Cours.class).load(id);
		coursToUpadate.setLibelle(cours.getLibelle());
		coursToUpadate.setDateDebutCours(cours.getDateDebutCours());
		coursToUpadate.setDateFinCours(cours.getDateFinCours());
		coursToUpadate.setTranche_horaire(cours.getTranche_horaire());
		coursToUpadate.setClasse(cours.getClasse());
		coursToUpadate.setExamen(cours.getExamen());
		coursToUpadate.setMatiere(cours.getMatiere());
		coursToUpadate.setUtilisateur(cours.getUtilisateur());
		session.flush();
		
	}

	
	
	
	

}
