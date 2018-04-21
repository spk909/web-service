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
@Table(name = "type_utilisateur")
public class TypeUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;
	
	//@JsonIgnore 
	@OneToMany(mappedBy = "typeUtilisateur",fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value = "utilisateur")
	private Set<Utilisateur> utilisateur ;

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

	public TypeUtilisateur() {
		super();
	}

	public TypeUtilisateur(String libelle, Set<Utilisateur> utilisateur) {
		super();
		this.libelle = libelle;
		this.utilisateur = utilisateur;
	}

	public TypeUtilisateur(Long id) {
		super();
		this.id = id;
	}

	public TypeUtilisateur(String libelle) {
		super();
		this.libelle = libelle;
	}

	public TypeUtilisateur(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	

}
