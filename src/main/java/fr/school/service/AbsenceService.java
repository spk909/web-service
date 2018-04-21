package fr.school.service;

import java.util.List;

import fr.school.bean.AbsenceBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Absence;

public interface AbsenceService {
	long saveAbsence(AbsenceBean absenceBean) throws TechnicalBusinessException;
	List<Absence> getAbsenceByIdUser(long id);
	void delete(long id);
	void updateAbsence(long id, Absence absence);
	

}
