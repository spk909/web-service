package fr.school.dao;


import java.util.Date;
import java.util.List;

import fr.school.model.Cours;

public interface CoursDao extends GenericDao<Cours>{
	List<Cours> getCoursByClasseId(long id);
	List<Cours> getCoursByDate(Date date);
	List<Cours> getCoursByDateAndByClasseId(Date debut, Date fin,long id);
	List<Cours> getCoursByDateAndByProfId(Date debut, Date fin,long id);
	void updateCours(long id, Cours cours);
}
