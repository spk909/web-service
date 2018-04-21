package fr.school.service;

import fr.school.bean.NoteBean;
import fr.school.exception.TechnicalBusinessException;

public interface NoteService {
	long saveNoteByIdMatiere(NoteBean noteBean) throws TechnicalBusinessException;
	
	

}
