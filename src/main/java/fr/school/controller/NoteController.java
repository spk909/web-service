package fr.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.school.bean.NoteBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;

	@CrossOrigin()
	@PostMapping("/note")
	public ResponseEntity<?>saveNote(@RequestBody NoteBean noteBean){
		try{
			noteService.saveNoteByIdMatiere(noteBean);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(noteBean.getId());
		}catch (TechnicalBusinessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getException());
		}
	}

}
