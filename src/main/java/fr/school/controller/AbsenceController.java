package fr.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.school.bean.AbsenceBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Absence;
import fr.school.service.AbsenceService;

@RestController
public class AbsenceController {

	@Autowired
	private AbsenceService absenceService;
	
	@CrossOrigin()
	@PostMapping("/absence")
	public ResponseEntity<?> saveAbsence(@RequestBody AbsenceBean absenceBean){
		try{
			absenceService.saveAbsence(absenceBean);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(absenceBean.getId());
		}catch (TechnicalBusinessException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getException());
		}
	}

	@CrossOrigin()
	@GetMapping("/absence/{id}")
	public ResponseEntity<List<Absence>> getAllAbsenceByUser(@PathVariable("id") long id){
		List<Absence> absence = absenceService.getAbsenceByIdUser(id);
		return ResponseEntity.ok().body(absence);
	}
	@CrossOrigin()
	@PutMapping("/absence/{id}")
	private ResponseEntity<?> updateRetard(@PathVariable("id") long id, @RequestBody Absence absence ) {
		absenceService.updateAbsence(id, absence);
		return ResponseEntity.ok()
		.body("mise a jour réussi");
	}
	
	@CrossOrigin()
	@DeleteMapping("/absence/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		absenceService.delete(id);
		return ResponseEntity.ok().body(id);
	}
	
}
