package fr.school.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cours")
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;
	
	@Column(name = "libelle", nullable = false)
	private String libelle;
	
	@Column(name = "commentaire", nullable = false)
	private String commentaire;

	@Temporal(TemporalType.DATE)
	@Column(name = "debut", nullable = false)
	private Date dateDebutCours;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fin", nullable = false)
	private Date dateFinCours;
	
	@Column(name = "tranche_horaire", nullable = false)
	private int tranche_horaire;

	
	@Column(name = "examen", nullable = false)
	private int examen;
	
	@Column(name = "jour", nullable = false)
	private String jour;
	
	//@JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	
	//@JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	//@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "salle_id")
	private Salle salle;
	
	//@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateDebutCours() {
		return dateDebutCours;
	}

	public void setDateDebutCours(Date dateDebutCours) {
		this.dateDebutCours = dateDebutCours;
	}

	public Date getDateFinCours() {
		return dateFinCours;
	}

	public void setDateFinCours(Date dateFinCours) {
		this.dateFinCours = dateFinCours;
	}

	public int getTranche_horaire() {
		return tranche_horaire;
	}

	public void setTranche_horaire(int tranche_horaire) {
		this.tranche_horaire = tranche_horaire;
	}

	public int getExamen() {
		return examen;
	}

	public void setExamen(int examen) {
		this.examen = examen;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Cours() {
		super();
	}

	public Cours(Long id, String libelle, String commentaire, Date dateDebutCours, Date dateFinCours,
			int tranche_horaire, int examen, Matiere matiere, Utilisateur utilisateur, Salle salle) {
		super();
		
		this.id = id;
		this.libelle = libelle;
		this.commentaire = commentaire;
		this.dateDebutCours = dateDebutCours;
		this.dateFinCours = dateFinCours;
		this.tranche_horaire = tranche_horaire;
		this.examen = examen;
		
		//Recupere les donnés des matieres 
		Matiere mat = new Matiere();
		mat.setNom(matiere.getNom());
		mat.setType(matiere.getType());
		this.matiere = mat;
		
		//recupere les données user
		Utilisateur usr = new Utilisateur();
		usr.setPrenom(utilisateur.getPrenom());
		usr.setNom(utilisateur.getNom());
		this.utilisateur = usr;
		
		
		//recupere la salle
		Salle salleRecup = new Salle();
		salleRecup.setNumero(salle.getNumero());
		salleRecup.setId(salle.getId());
		this.salle = salleRecup;
		
	}

	public Cours(Long id, String libelle, String commentaire, Date dateDebutCours, Date dateFinCours,
			int tranche_horaire, int examen, Classe classe, Salle salle) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.commentaire = commentaire;
		this.dateDebutCours = dateDebutCours;
		this.dateFinCours = dateFinCours;
		this.tranche_horaire = tranche_horaire;
		this.examen = examen;
		
		//recup de la formation
		Classe classeRecup = new Classe();
		classeRecup.setId(classe.getId());
		classeRecup.setLibelle(classe.getLibelle());
		this.classe = classeRecup;
		
		//recup de la salle
		Salle salleRecup = new Salle();
		salleRecup.setId(salle.getId());
		salleRecup.setNumero(salle.getNumero());
		this.salle = salleRecup;
	}

	

	
	
	
	
	
	
}
