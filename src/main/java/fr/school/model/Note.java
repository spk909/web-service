package fr.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;

	@Column(name = "note", nullable = false)
	private double note;

	@Column(name = "appreciation", nullable = false)
	private String appreciation;

	@Column(name = "libelle_evaluation", nullable = false)
	private String libelle_evaluation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	//@JsonBackReference
	private Utilisateur utilisateur ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matiere_id")
	//@JsonBackReference
	private Matiere matiere ;

	public Note() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public String getLibelle_evaluation() {
		return libelle_evaluation;
	}

	public void setLibelle_evaluation(String libelle_evaluation) {
		this.libelle_evaluation = libelle_evaluation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Note(Long id, double note, String appreciation, String libelle_evaluation, Utilisateur utilisateur,
			Matiere matiere) {
		super();
		this.id = id;
		this.note = note;
		this.appreciation = appreciation;
		this.libelle_evaluation = libelle_evaluation;
		this.utilisateur = utilisateur;
		this.matiere = matiere;
	}

	public Note(double note) {
		super();
		this.note = note;
	}

	


}
