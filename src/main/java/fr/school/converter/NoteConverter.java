package fr.school.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import fr.school.bean.NoteBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Matiere;
import fr.school.model.Note;
import fr.school.model.Utilisateur;

public class NoteConverter {
	
	public static Note noteBeanToNoteModel(NoteBean noteBean, Note note, Matiere matiere, Utilisateur utilisateur) throws TechnicalBusinessException {
		try{
			PropertyUtils.copyProperties(note, noteBean);
		}catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new TechnicalBusinessException(e);
		}
		note.setMatiere(matiere);
		note.setUtilisateur(utilisateur);
		
		return note;
	}

}
