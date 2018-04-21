package fr.school.bean;

import java.io.Serializable;
import java.util.Date;

public class CoursBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String libelle;
	
	private String commentaire;
	
	private Date dateDebutCours;
	
	private Date dateFinCours;
	
	private int tranche_horaire;
	
	private int examen;
	
	private String jour;
	
	private long classe_id;
	
	private long matiere_id;
	
	private long salle_id;
	
	private long utilisateur_id;

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

	public long getClasse_id() {
		return classe_id;
	}

	public void setClasse_id(long classe_id) {
		this.classe_id = classe_id;
	}

	public long getMatiere_id() {
		return matiere_id;
	}

	public void setMatiere_id(long matiere_id) {
		this.matiere_id = matiere_id;
	}

	public long getSalle_id() {
		return salle_id;
	}

	public void setSalle_id(long salle_id) {
		this.salle_id = salle_id;
	}

	public long getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CoursBean(Long id, String libelle, String commentaire, Date dateDebutCours, Date dateFinCours,
			int tranche_horaire, int examen, long matiere_id, long utilisateur_id) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.commentaire = commentaire;
		this.dateDebutCours = dateDebutCours;
		this.dateFinCours = dateFinCours;
		this.tranche_horaire = tranche_horaire;
		this.examen = examen;
		this.matiere_id = matiere_id;
		this.utilisateur_id = utilisateur_id;
	}

	public CoursBean() {
		super();
	}



	
}
