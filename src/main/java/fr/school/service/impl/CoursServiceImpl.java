package fr.school.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.bean.CoursBean;
import fr.school.converter.CoursConverter;
import fr.school.dao.ClasseDao;
import fr.school.dao.CoursDao;
import fr.school.dao.MatiereDao;
import fr.school.dao.SalleDao;
import fr.school.dao.UtilisateurDao;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Classe;
import fr.school.model.Cours;
import fr.school.model.Matiere;
import fr.school.model.Salle;
import fr.school.model.Utilisateur;
import fr.school.service.CoursService;

@Service
@Transactional(readOnly = true)
public class CoursServiceImpl implements CoursService {
	
		@Autowired
		private CoursDao coursDao;
		
		@Autowired
		private SalleDao salleDao;
		
		@Autowired
		private ClasseDao classeDao;
		
		@Autowired
		private MatiereDao matiereDao;
		
		@Autowired
		private UtilisateurDao utilisateurDao;

	@Transactional
	@Override
	public long saveCoursByIdClasse(CoursBean coursBean) throws TechnicalBusinessException {
		long classId = coursBean.getClasse_id();
		long matiereId= coursBean.getMatiere_id();
		long salleId = coursBean.getSalle_id();
		long profId = coursBean.getUtilisateur_id();
		Classe classe = classeDao.getById(classId);
		Matiere matiere= matiereDao.getById(matiereId);
		Salle salle = salleDao.getById(salleId);
		Utilisateur utilisateur = utilisateurDao.getById(profId);
		Cours cours = coursDao.getById(coursBean.getId());
		cours = CoursConverter.CoursBeanToCoursModel(coursBean, cours, classe, matiere, salle, utilisateur);
		coursDao.save(cours);
		return cours.getId();
	}

	@Transactional
	@Override
	public void delete(long id) {
		coursDao.delete(id);
		
	}

	@Override
	public void updateCours(long id, Cours cours) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cours> getCoursBydate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getListCoursById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<Cours> getCoursByDateAndByClasseId(Date debut, Date fin, long id) {
		return coursDao.getCoursByDateAndByClasseId(debut,fin, id);
	}
	
	@Override
	public List<Cours> getCoursByDateAndByProfId(Date debut, Date fin, long id) {
		return coursDao.getCoursByDateAndByProfId(debut, fin, id);
	}




}

	