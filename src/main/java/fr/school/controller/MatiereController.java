package fr.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.school.model.Matiere;
import fr.school.service.MatiereService;

@RestController
public class MatiereController {
	
	@Autowired
	private MatiereService matiereService;




	@CrossOrigin()
	@GetMapping("/matiere")
	public ResponseEntity<List<Matiere>> getAllMatiere() {
		List<Matiere> matiere = matiereService.getAllMatiere();
		return ResponseEntity.ok().body(matiere);
	}
}
