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
@Table(name = "batiment")
public class Batiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;

	@Column(name = "etage", nullable = false)
	private int etage;

	@Column(name = "libelle", nullable = false)
	private String libelle;
	
	
	@OneToMany(mappedBy = "batiment",fetch = FetchType.LAZY)
	private Set<Salle> salle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Salle> getSalle() {
		return salle;
	}

	public void setSalle(Set<Salle> salle) {
		this.salle = salle;
	}

	public Batiment() {
		super();
	}

	public Batiment(Long id, int etage, String libelle) {
		super();
		this.id = id;
		this.etage = etage;
		this.libelle = libelle;
	}

	public Batiment(int etage, String libelle) {
		super();
		this.etage = etage;
		this.libelle = libelle;
	}
	
	
}
