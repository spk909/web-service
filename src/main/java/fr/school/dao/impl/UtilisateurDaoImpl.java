package fr.school.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.school.dao.UtilisateurDao;
import fr.school.model.Classe;
import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Utilisateur getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new Utilisateur();
		}
		return session.load(Utilisateur.class, id);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateur = session.byId(Utilisateur.class).load(id);
		session.delete(utilisateur);
	}

	@Override
	public long save(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().save(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public List<Utilisateur> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.select(userRoot);
		criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get("nom")));
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	public Utilisateur checkLoginPassword(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> typeRoot = criteriaQuery.from(Utilisateur.class);
		 criteriaQuery.multiselect(typeRoot.get("id"),typeRoot.get("nom"),typeRoot.get("prenom"));
		 criteriaQuery.where((criteriaBuilder.equal(typeRoot.get("login"), login))
		 ,(criteriaBuilder.equal(typeRoot.get("password"), password)));
		 Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	
	@Override
	public TypeUtilisateur getRole(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<TypeUtilisateur> criteriaQuery = criteriaBuilder.createQuery(TypeUtilisateur.class);
		Root<TypeUtilisateur> typeUser = criteriaQuery.from(TypeUtilisateur.class);
		Join<TypeUtilisateur,Utilisateur > user= typeUser.join("utilisateur", JoinType.LEFT);
		criteriaQuery.multiselect(typeUser.get("id"),typeUser.get("libelle"));
		criteriaQuery.where((criteriaBuilder.equal(user.get("login"), login))
				,(criteriaBuilder.equal(user.get("password"),password)));
		criteriaQuery.distinct(true);
		Query<TypeUtilisateur> query = session.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	
	@Override
	public Utilisateur startLoginEleve(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.multiselect(userRoot.get("id"),userRoot.get("nom"),userRoot.get("prenom"),
				userRoot.get("typeUtilisateur"),userRoot.get("classe"));
		criteriaQuery.where((criteriaBuilder.equal(userRoot.get("login"),login))
				,(criteriaBuilder.equal(userRoot.get("password"), password)));
		criteriaQuery.distinct(true);
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	
	@Override
	public Utilisateur startLogin(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.multiselect(userRoot.get("id"),userRoot.get("nom"),userRoot.get("prenom"),
				userRoot.get("typeUtilisateur"));
		criteriaQuery.where((criteriaBuilder.equal(userRoot.get("login"),login))
				,(criteriaBuilder.equal(userRoot.get("password"), password)));
		criteriaQuery.distinct(true);
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	
	@Override
	public List<Utilisateur> getUtilisateurByNameLike(String nom) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.multiselect(userRoot.get("id"),userRoot.get("nom"),userRoot.get("prenom"));
		 Predicate predicate = criteriaBuilder.like(userRoot.get("nom"), "%"+nom+"%");
		 criteriaQuery.where(predicate);
		    TypedQuery<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	@Override
	public List<Utilisateur> getEleveByIdclasse(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		Join<Utilisateur,Classe > classe= userRoot.join("classe", JoinType.LEFT);
		criteriaQuery.multiselect(userRoot.get("id"),userRoot.get("nom"),userRoot.get("prenom"));
		criteriaQuery.where((criteriaBuilder.equal(classe.get("id"), id)));
		criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get("nom")));
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	public List<Utilisateur> getListByIdclasse(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Utilisateur> getListEleve() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.multiselect(userRoot.get("id"),userRoot.get("nom"), userRoot.get("prenom"))
				.where(criteriaBuilder.equal(userRoot.get("typeUtilisateur"), 1));
		criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get("nom")));
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	
	
	

	@Override
	public TypeUtilisateur getTypeById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null) {
			return new TypeUtilisateur();
		}
		return session.load(TypeUtilisateur.class, id);
	}

	@Override
	public List<Utilisateur> getListEnseignant() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
		criteriaQuery.multiselect(userRoot.get("nom"), userRoot.get("prenom"))
				.where(criteriaBuilder.equal(userRoot.get("typeUtilisateur"), 2));
		criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get("nom")));
		Query<Utilisateur> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void updateUtilisateur(long id, Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateurToUpadate = session.byId(Utilisateur.class).load(id);
		utilisateurToUpadate.setNom(utilisateur.getNom());
		utilisateurToUpadate.setPrenom(utilisateur.getPrenom());
		utilisateurToUpadate.setEmail(utilisateur.getEmail());
		session.flush();
	}

	@Override
	public Utilisateur findUserByLogin(String login) {
		return sessionFactory.getCurrentSession().get(Utilisateur.class, login);
	}

	

	

	

	

	

	

	

}
