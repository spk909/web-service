package fr.school.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import fr.school.bean.AbsenceBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Absence;
import fr.school.model.Utilisateur;

public class AbsenceConverter {
	public static Absence absenceBeanToAbsenceModel(AbsenceBean absenceBean, Absence absence, Utilisateur utilisateur) throws TechnicalBusinessException {
		
		try{
			PropertyUtils.copyProperties(absence, absenceBean);
		}catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
		}
		absence.setUtilisateur(utilisateur);
		return absence;
		
	}

}
