package fr.school.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "matiere")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "matiere")
	private Set<Note> note;
	
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "matiere")
	private Set<Cours> cours;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Matiere() {
		super();
	}

	public Matiere(Long id, String nom, String type, Set<Note> note, Set<Cours> cours) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.note = note;
		this.cours = cours;
	}

	public Matiere(Long id, String nom, String type) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
	}

	public Matiere(String nom) {
		super();
		this.nom = nom;
	}

	public Matiere(String nom, String type) {
		super();
		this.nom = nom;
		this.type = type;
	}



}
