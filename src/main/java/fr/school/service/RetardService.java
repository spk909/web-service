package fr.school.service;

import java.util.List;

import fr.school.bean.RetardBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Retard;

public interface RetardService {
	long saveRetard(RetardBean retardBean)throws TechnicalBusinessException;
	List<Retard> getRetardByIdUser(long id);
	void delete(long id);
	void  updateRetard(long id, Retard retard);

}
