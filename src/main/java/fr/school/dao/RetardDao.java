package fr.school.dao;

import java.util.List;

import fr.school.model.Retard;

public interface RetardDao extends GenericDao<Retard>{
	List<Retard> listRetardById(long id);
	void updateRetard(long id, Retard retard);

}
