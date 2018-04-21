package fr.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.bean.RetardBean;
import fr.school.converter.RetardConverter;
import fr.school.dao.RetardDao;
import fr.school.dao.UtilisateurDao;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Retard;
import fr.school.model.Utilisateur;
import fr.school.service.RetardService;

@Service
@Transactional(readOnly = true)
public class RetardServiceImpl implements RetardService {
	
	@Autowired
	private RetardDao retardDao;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	
	
	
	@Transactional
	@Override
	public long saveRetard(RetardBean retardBean) throws TechnicalBusinessException {
		long idUser = retardBean.getUtilisateur_id();
		Utilisateur utilisateur = utilisateurDao.getById(idUser);
		Retard retard = retardDao.getById(retardBean.getId());
		retard = RetardConverter.retardBeanToRetardModel(retardBean, retard, utilisateur);
		retardDao.save(retard);
		return retard.getId();
	}

	@Override
	public List<Retard> getRetardByIdUser(long id) {
		return retardDao.listRetardById(id);
	}
	
	@Transactional
	@Override
	public void delete(long id) {
		retardDao.delete(id);

	}

	@Transactional
	@Override
	public void updateRetard(long id, Retard retard) {
		retardDao.updateRetard(id, retard);
	}
}
