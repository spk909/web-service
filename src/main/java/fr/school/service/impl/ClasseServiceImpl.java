package fr.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.dao.ClasseDao;
import fr.school.model.Classe;
import fr.school.service.ClasseService;
@Service
@Transactional(readOnly = true)
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseDao classeDao;
	
	@Override
	public List<Classe> getAllClasse() {
		
		return classeDao.getAll();
	}

}
