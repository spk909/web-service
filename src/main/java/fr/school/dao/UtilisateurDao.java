package fr.school.dao;

import java.util.List;

import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur> {
	List<Utilisateur>getListEleve();
	List<Utilisateur>getListEnseignant();
	List<Utilisateur> getUtilisateurByNameLike(String nom);
	TypeUtilisateur getTypeById(Long id);
	void updateUtilisateur(long id, Utilisateur utilisateur);
	Utilisateur findUserByLogin(String login);
	Utilisateur checkLoginPassword (String login, String password);
	TypeUtilisateur getRole(String login, String password);
	Utilisateur startLogin(String login, String password);
	Utilisateur startLoginEleve(String login, String password);
	List<Utilisateur> getEleveByIdclasse(long id);
	List<Utilisateur> getListByIdclasse(long id);
}
