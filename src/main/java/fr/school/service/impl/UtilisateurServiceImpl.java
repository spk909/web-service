package fr.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.bean.UtilisateurBean;
import fr.school.converter.UtilisateurConverter;
import fr.school.dao.ClasseDao;
import fr.school.dao.FormationDao;
import fr.school.dao.UtilisateurDao;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Classe;
import fr.school.model.Formation;
import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;
import fr.school.service.UtilisateurService;

@Service
@Transactional(readOnly = true)
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private FormationDao formationDao;
	
	@Autowired
	private ClasseDao classeDao;
	

	@Transactional
	@Override
	public long saveUserByIdType(UtilisateurBean utilisateurBean) throws TechnicalBusinessException {
		long typeId = utilisateurBean.getTypeUtilisateur_id();
		long classeId= utilisateurBean.getClasse_id();
		long formationId= utilisateurBean.getFormation_id();
		TypeUtilisateur typeUtilisateur = utilisateurDao.getTypeById(typeId);
		Utilisateur utilisateur = utilisateurDao.getById(utilisateurBean.getId());
		Classe classe = classeDao.getById(classeId);
		Formation formation = formationDao.getById(formationId);
		utilisateur = UtilisateurConverter.utilisateurBeanToUtilisateurModel(utilisateurBean, utilisateur, typeUtilisateur,classe,formation);
		utilisateurDao.save(utilisateur);
		return utilisateur.getId();
	}
	
	@Override
	public Utilisateur getUserById(long id) {
		return utilisateurDao.getById(id);
	}


	@Override
	public List<Utilisateur> getAllEleve() {
		return utilisateurDao.getListEleve();
	}

	@Override
	public List<Utilisateur> getAllEnseignant() {
		return utilisateurDao.getListEnseignant();
	}
	
	@Override
	public List<Utilisateur> getEleveByIdClasse(long id) {
		return utilisateurDao.getEleveByIdclasse(id);
	}

	@Transactional
	@Override
	public void updateUser(long id, Utilisateur utilisateur) {
		utilisateurDao.updateUtilisateur(id, utilisateur);

	}

	@Transactional
	@Override
	public void delete(long id) {
		utilisateurDao.delete(id);
	}
	
	
	@Override
	public Utilisateur getLoginPassword(String login, String password) {
		return  utilisateurDao.checkLoginPassword(login, password);
	}
	
	@Override
	public TypeUtilisateur getRole(String login, String password) {
		return utilisateurDao.getRole(login,password);
	}
	
	@Override
	public Utilisateur startLogin(String login, String password) {
		return utilisateurDao.startLogin(login, password);
	}
	
	@Override
	public Utilisateur startLoginEleve(String login, String password) {
		return utilisateurDao.startLoginEleve(login, password);
	}

	@Override
	public List<Utilisateur> getUtilisateurByNameLike(String nom) {
		return utilisateurDao.getUtilisateurByNameLike(nom);
	}

	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	

	
	

	
	

	
	


}
