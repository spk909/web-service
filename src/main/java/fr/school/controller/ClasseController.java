package fr.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.school.model.Classe;
import fr.school.service.ClasseService;

@RestController
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	
	@CrossOrigin()
	@GetMapping("/classe")
	private ResponseEntity<List<Classe>> getAllClasse() {
		List<Classe>classeList = classeService.getAllClasse();
		return ResponseEntity.ok().body(classeList);

	}

}
