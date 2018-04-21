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
@Table(name = "retard")
public class Retard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_retard", nullable = false)
	private Date date_retard;

	@Column(name = "duree_retard", nullable = false)
	private int duree_retard;

	@Column(name = "motif", nullable = false)
	private String motif;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_retard() {
		return date_retard;
	}

	public void setDate_retard(Date date_retard) {
		this.date_retard = date_retard;
	}

	public int getDuree_retard() {
		return duree_retard;
	}

	public void setDuree_retard(int duree_retard) {
		this.duree_retard = duree_retard;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Retard() {
		super();
	}

	public Retard(Long id, Date date_retard, int duree_retard, String motif, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.date_retard = date_retard;
		this.duree_retard = duree_retard;
		this.motif = motif;
		this.utilisateur = utilisateur;
	}

	public Retard(Long id, Date date_retard, int duree_retard, String motif) {
		super();
		this.id = id;
		this.date_retard = date_retard;
		this.duree_retard = duree_retard;
		this.motif = motif;
	}
	
	
}
