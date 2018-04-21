package fr.school.service;

import java.util.Date;
import java.util.List;

import fr.school.bean.CoursBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Cours;

public interface CoursService {
	long saveCoursByIdClasse(CoursBean coursBean) throws TechnicalBusinessException;
	void delete(long id);
	void updateCours(long id, Cours cours);
	List<Cours>getCoursBydate(Date date);
	List<Cours>getListCoursById(long id);
	List<Cours> getCoursByDateAndByClasseId(Date debut, Date fin, long id);
	List<Cours>getCoursByDateAndByProfId(Date debut, Date fin, long id);
	
}
