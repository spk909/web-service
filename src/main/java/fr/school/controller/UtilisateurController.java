package fr.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import fr.school.bean.UtilisateurBean;
import fr.school.exception.TechnicalBusinessException;
import fr.school.model.TypeUtilisateur;
import fr.school.model.Utilisateur;
import fr.school.service.UtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;

	/*---nouvel utilisateur---*/
	@CrossOrigin()
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody UtilisateurBean utilisateurBean) {
		try {
			utilisateurService.saveUserByIdType(utilisateurBean);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(utilisateurBean.getId());
		} catch (TechnicalBusinessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getException());
		}
	}

	@CrossOrigin()
	@GetMapping("/user/{id}")
	public ResponseEntity<Utilisateur> getUserById(@PathVariable("id") long id) {
		Utilisateur utilisateur = utilisateurService.getUserById(id);
		return ResponseEntity.ok().body(utilisateur);
	}
	
	//rechercher un user
	@CrossOrigin()
	@PostMapping("/user/eleve")
	public ResponseEntity<List<Utilisateur>>getUserByNameLike( @RequestBody UtilisateurBean utilisateurBean) {
	
		String nom = utilisateurBean.getNom();
		List<Utilisateur> utilisateur = utilisateurService.getUtilisateurByNameLike(nom);
		return ResponseEntity.ok().body(utilisateur);
	}

	@CrossOrigin()
	@GetMapping("/user/eleve")
	public ResponseEntity<List<Utilisateur>> getEleves(HttpServletRequest req) {
		if(!isUserLoged(req)){
			ResponseEntity.status(HttpStatus.UNAUTHORIZED);
		}
		List<Utilisateur> utilisateur = utilisateurService.getAllEleve();
		return ResponseEntity.ok().body(utilisateur);
	}

	@CrossOrigin()
	@GetMapping("/user/enseignant")
	public ResponseEntity<List<Utilisateur>> getEnseignant() {
		List<Utilisateur> utilisateur = utilisateurService.getAllEnseignant();
		return ResponseEntity.ok().body(utilisateur);
	}
	
	@CrossOrigin()
	@GetMapping("/user/classe/{id}")
	public ResponseEntity<List<Utilisateur>> getEleveByIdClasse(HttpServletRequest request,@PathVariable("id") long id){
		if(!isUserLoged(request)){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		List<Utilisateur> eleveInClasse = utilisateurService.getEleveByIdClasse(id);
		return ResponseEntity.ok().body(eleveInClasse);
		
	}

	@CrossOrigin()
	@PostMapping("/login/")
	public ResponseEntity<?> getAuthentification(HttpServletRequest request, @RequestBody UtilisateurBean utilisateurBean)  {
		String login = utilisateurBean.getLogin();
		String password = utilisateurBean.getPassword();
		try{
			TypeUtilisateur typeUtilisateur =utilisateurService.getRole(login, password);
			if(typeUtilisateur.getId()== 2 ||typeUtilisateur.getId()== 3){
				Utilisateur utilisateur =utilisateurService.startLogin(login, password);
				request.getSession().setAttribute("utilisateurId", utilisateur.getId());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(utilisateur);
			}
			    				Utilisateur utilisateur =utilisateurService.startLoginEleve(login, password);
			    				request.getSession().setAttribute("utilisateurId", utilisateur.getId());

			    				return ResponseEntity.status(HttpStatus.ACCEPTED).body(utilisateur);
			
			
		}catch(Exception e){
			
			Utilisateur utilisateur = new Utilisateur("Inconnu");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(utilisateur);
		}		
	}

	@CrossOrigin()
	@PostMapping("/logout/")
	public ResponseEntity<?> getAuthentificationlogout(HttpServletRequest request)  {
			request.getSession().setAttribute("utilisateurId", null);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			
			
			
	}
	
	// mise a jour du nom et prenom
	@CrossOrigin()
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUtilisateur(@PathVariable("id") long id, @RequestBody Utilisateur user) {
		utilisateurService.updateUser(id, user);
		return ResponseEntity.ok()
				.body("l'adresse la ville et lecode postal de cet utlisateur ont bien été mise à jour.");
	}



	/*---supprimer un eleve---*/
	@CrossOrigin()
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		utilisateurService.delete(id);
		return ResponseEntity.ok().body(id);
	}
	@CrossOrigin()
	 public Boolean isUserLoged (HttpServletRequest request){
		 String a = (String) request.getSession().getAttribute("utilisateurId");
		 if(request.getSession().getAttribute("utilisateurId")==null)
			 return false;
		 else 
			 return true;
	 }
	//inserer un eleve dans sa formation

}