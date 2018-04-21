package fr.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.school.bean.NoteBean;
import fr.school.converter.NoteConverter;
import fr.school.dao.MatiereDao;
import fr.school.dao.NoteDao;
import fr.school.dao.UtilisateurDao;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Matiere;
import fr.school.model.Note;
import fr.school.model.Utilisateur;
import fr.school.service.NoteService;


@Service
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private MatiereDao matiereDao;
	
	@Transactional
	@Override
	public long saveNoteByIdMatiere(NoteBean noteBean) throws TechnicalBusinessException {
		long matiereId = noteBean.getMatiere_id();
		long userId = noteBean.getUtilisateur_id();
		Utilisateur utilisateur = utilisateurDao.getById(userId);
		Matiere matiere = matiereDao.getById(matiereId);
		Note note = noteDao.getById(noteBean.getId());
		note = NoteConverter.noteBeanToNoteModel(noteBean, note, matiere, utilisateur);
		noteDao.save(note);
		
		return note.getId();
	}

}
