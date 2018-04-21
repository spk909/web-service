package fr.school.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import fr.school.bean.RetardBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Retard;
import fr.school.model.Utilisateur;

public class RetardConverter {
	
	public static Retard retardBeanToRetardModel(RetardBean retardBean, Retard retard, Utilisateur utilisateur) throws TechnicalBusinessException {
	
		try{
			PropertyUtils.copyProperties(retard, retardBean);
		}catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
	}
		retard.setUtilisateur(utilisateur);
		return retard;
	}
}
