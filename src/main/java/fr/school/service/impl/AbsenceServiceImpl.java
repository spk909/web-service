package fr.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.bean.AbsenceBean;
import fr.school.converter.AbsenceConverter;
import fr.school.dao.AbsenceDao;
import fr.school.dao.UtilisateurDao;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Absence;
import fr.school.model.Utilisateur;
import fr.school.service.AbsenceService;

@Service
@Transactional(readOnly = true)
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceDao absenceDao;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Transactional
	@Override
	public long saveAbsence(AbsenceBean absenceBean) throws TechnicalBusinessException {
		long userId = absenceBean.getUtilisateur_id();
		Utilisateur utilisateur = utilisateurDao.getById(userId);
		Absence absence = absenceDao.getById(absenceBean.getId());
		absence = AbsenceConverter.absenceBeanToAbsenceModel(absenceBean, absence, utilisateur);
		absenceDao.save(absence);
		return absence.getId();
	}

	@Override
	public List<Absence> getAbsenceByIdUser(long id) {
		return absenceDao.listAbsenceEleveById(id);
	}

	@Transactional
	@Override
	public void delete(long id) {
		absenceDao.delete(id);
		
	}

	@Transactional
	@Override
	public void updateAbsence(long id, Absence absence) {
		absenceDao.updateRetard(id, absence);
		
	}

}
