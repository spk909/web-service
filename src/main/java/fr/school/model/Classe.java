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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "classe")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;
	
	@Column(name = "libelle", nullable = false)
	private String libelle;
	
	
	@OneToMany(mappedBy = "classe", fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value = "utilisateur")
	private Set<Utilisateur> utilisateur ;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "classe")
	private Set<Cours> cours;

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

	public Set<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Set<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Classe() {
		super();
	}

	public Classe(Long id, String libelle, Set<Utilisateur> utilisateur, Set<Cours> cours) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.utilisateur = utilisateur;
		this.cours = cours;
	}

	public Classe(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Classe(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}


	
	
	
}
