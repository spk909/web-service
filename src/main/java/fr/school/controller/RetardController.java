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

import fr.school.bean.RetardBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Retard;
import fr.school.service.RetardService;

@RestController
public class RetardController {
	@Autowired
	private RetardService retardService;
	
	@CrossOrigin()
	@PostMapping("/retard")
	public ResponseEntity<?>saveRetard(@RequestBody RetardBean retardBean){
		try{
			retardService.saveRetard(retardBean);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(retardBean.getId());
		}catch (TechnicalBusinessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getException());
		}
	}
	

	@CrossOrigin()
	@GetMapping("/retard/{id}")
	public ResponseEntity<List<Retard>> getAllRetardByUser(@PathVariable("id") long id) {
		List<Retard> retard = retardService.getRetardByIdUser(id);
		return ResponseEntity.ok().body(retard);
	}
	
	@CrossOrigin()
	@DeleteMapping("/retard/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		retardService.delete(id);
		return ResponseEntity.ok().body(id);
	}
	
	@CrossOrigin()
	@PutMapping("/retard/{id}")
	private ResponseEntity<?> updateRetard(@PathVariable("id") long id, @RequestBody Retard retard) {
		retardService.updateRetard(id, retard);
		return ResponseEntity.ok()
		.body("mise a jour réussi");
	}
}

	
	





