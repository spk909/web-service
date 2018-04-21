package fr.school.dao;

import java.util.List;

import fr.school.model.Absence;

public interface AbsenceDao extends GenericDao<Absence> {
	List<Absence> listAbsenceByDateOfTheDay();
	List<Absence> listAbsenceEleveById(long id);
	void updateRetard(long id, Absence absence);
	
	
}
