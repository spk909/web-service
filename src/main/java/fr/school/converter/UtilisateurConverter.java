package fr.school.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import fr.school.bean.UtilisateurBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Classe;
import fr.school.model.Formation;
import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;

public class UtilisateurConverter {

	public static Utilisateur utilisateurBeanToUtilisateurModel(UtilisateurBean utilisateurBean, Utilisateur utilisateur,TypeUtilisateur typeUtilisateur,Classe classe, Formation formation )
			throws TechnicalBusinessException {

		try {
			PropertyUtils.copyProperties(utilisateur, utilisateurBean);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
		}
		utilisateur.setTypeUtilisateur(typeUtilisateur);
		utilisateur.setClasse(classe);
		utilisateur.setFormation(formation);
		return utilisateur;
	}
}