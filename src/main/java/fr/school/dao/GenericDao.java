package fr.school.dao;

import java.util.List;

public interface GenericDao<T> {
	
	T getById(Long id);
	List<T> getAll();
	void delete(long id);
	long save(T t);
	
}
