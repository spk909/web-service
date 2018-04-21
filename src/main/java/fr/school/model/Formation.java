package fr.school.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="formation")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "promotion", nullable = false)
	private Date promotion;
	
	@OneToMany(mappedBy = "formation", fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value = "utilisateur")
	private Set<Utilisateur> utilisateur ;

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

	public Date getPromotion() {
		return promotion;
	}

	public void setPromotion(Date promotion) {
		this.promotion = promotion;
	}

	public Set<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Set<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Formation() {
		super();
	}

	
}
