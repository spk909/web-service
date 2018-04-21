package fr.school.service;

import java.util.List;

import fr.school.bean.UtilisateurBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;

public interface UtilisateurService {
	long saveUserByIdType(UtilisateurBean utilisateurBean) throws TechnicalBusinessException;
	List<Utilisateur>getAllEleve();
	List<Utilisateur>getAllEnseignant();
	void updateUser(long id, Utilisateur utilisateurs);
    void delete(long id);
    Utilisateur getUserById(long id);
    Utilisateur getLoginPassword (String login, String password);
    TypeUtilisateur getRole(String login, String password);
    Utilisateur startLogin(String login, String password);
    Utilisateur startLoginEleve(String login, String password);
    List<Utilisateur>getEleveByIdClasse(long id);
    List<Utilisateur>getUtilisateurByNameLike(String nom);
    
 

}
