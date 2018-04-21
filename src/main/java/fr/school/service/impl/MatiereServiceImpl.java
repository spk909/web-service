package fr.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.dao.MatiereDao;
import fr.school.model.Matiere;
import fr.school.service.MatiereService;

@Service
@Transactional(readOnly = true)
public class MatiereServiceImpl implements MatiereService {
	
	@Autowired
	private MatiereDao matiereDao;

	@Override
	public Matiere getId(long id) {
		return matiereDao.getById(id);
	}

	@Override
	public List<Matiere> getAllMatiere() {
		return matiereDao.getAll();
	}

}
