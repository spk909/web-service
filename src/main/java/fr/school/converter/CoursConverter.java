package fr.school.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import fr.school.bean.CoursBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Classe;
import fr.school.model.Cours;
import fr.school.model.Matiere;
import fr.school.model.Salle;
import fr.school.model.Utilisateur;

public class CoursConverter {
	
	public static Cours CoursBeanToCoursModel(CoursBean coursBean, Cours cours, Classe classe, Matiere matiere, Salle salle, Utilisateur utilisateur) throws TechnicalBusinessException {
		try{
			PropertyUtils.copyProperties(cours, coursBean);
		}catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
		}
		cours.setClasse(classe);
		cours.setMatiere(matiere);
		cours.setSalle(salle);
		cours.setUtilisateur(utilisateur);
		return cours;
	}
	
	public static CoursBean CoursModelToCoursBean(CoursBean coursBean, Cours cours, Classe classe, Matiere matiere, Salle salle, Utilisateur utilisateur) throws TechnicalBusinessException {
		try{
			PropertyUtils.copyProperties(coursBean,cours);
		}catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
		}
		coursBean.setClasse_id(classe.getId());
		coursBean.setMatiere_id(matiere.getId());
		coursBean.setSalle_id(salle.getId());
		coursBean.setUtilisateur_id(utilisateur.getId());
		return coursBean;
	}

}
