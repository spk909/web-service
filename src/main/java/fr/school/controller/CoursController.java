package fr.school.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.school.bean.CoursBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.Cours;
import fr.school.service.CoursService;

@RestController
public class CoursController {
	@Autowired
	private CoursService coursService;
	
	@CrossOrigin()
	@PostMapping("/cours")
	public ResponseEntity<?>saveCours(@RequestBody CoursBean coursBean){
		try{
			coursService.saveCoursByIdClasse(coursBean);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(coursBean.getId());
		}catch(TechnicalBusinessException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getException());
		}
	}
	
	@CrossOrigin()
	@PostMapping("/cours/admin/emploi_du_temps")
		public ResponseEntity<List<Cours>>searchCoursByDateAnd(@RequestBody CoursBean coursBean)	{
		long idClasse = coursBean.getClasse_id();
		
		Date dateDebutCours=coursBean.getDateDebutCours();
		Date dateFinCours = coursBean.getDateFinCours();
		try{
			List<Cours> cours = coursService.getCoursByDateAndByClasseId( dateDebutCours,dateFinCours,idClasse);
			
			return ResponseEntity.ok().body(cours);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@CrossOrigin()
	@PostMapping("/cours/prof/emploi_du_temps")
		public ResponseEntity<List<Cours>>searchCoursByDateAndIdProf(@RequestBody CoursBean coursBean)	{
		long idProf = coursBean.getUtilisateur_id();
		
		Date dateDebutCours=coursBean.getDateDebutCours();
		Date dateFinCours = coursBean.getDateFinCours();
		
		try{
			List<Cours> cours = coursService.getCoursByDateAndByProfId( dateDebutCours,dateFinCours,idProf);
			
			return ResponseEntity.ok().body(cours);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	/*
	
	@CrossOrigin()
	@PostMapping("/cours/emploi_du_temps")
	
		public ResponseEntity<List<CoursBean>>searchCoursByDateAnd(@RequestBody CoursBean coursBean)	{
		long idClasse = coursBean.getClasse_id();
		
		Date dateDebutCours=coursBean.getDateDebutCours();
		Date dateFinCours = coursBean.getDateFinCours();
		try{
			List<CoursBean> cours = coursService.getCoursByDateAndByClasseId( dateDebutCours,dateFinCours,idClasse);
			
			return ResponseEntity.ok().body(cours);
		}catch(Exception e){
			//List<Cours> cours =  new ArrayList<Cours>();
			List<Cours> cours = coursService.getCoursByDateAndByClasseId(dateDebutCours,dateFinCours,idClasse);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
}*/
	
	


}
