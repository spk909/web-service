package fr.school.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "absence")
public class Absence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut_absence", nullable = false)
	private Date date_debut_absence;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin_absence", nullable = false)
	private Date date_fin_absence;

	@Column(name = "motif", nullable = false)
	private String motif;

	@ManyToOne(fetch = FetchType.LAZY)
	private Utilisateur utilisateur;

	public Absence(Long id, Date date_debut_absence, Date date_fin_absence, String motif, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.date_debut_absence = date_debut_absence;
		this.date_fin_absence = date_fin_absence;
		this.motif = motif;
		this.utilisateur = utilisateur;
	}

	public Absence(Date date_debut_absence, Date date_fin_absence, String motif) {
		super();
		this.date_debut_absence = date_debut_absence;
		this.date_fin_absence = date_fin_absence;
		this.motif = motif;
	}

	public Absence() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_debut_absence() {
		return date_debut_absence;
	}

	public void setDate_debut_absence(Date date_debut_absence) {
		this.date_debut_absence = date_debut_absence;
	}

	public Date getDate_fin_absence() {
		return date_fin_absence;
	}

	public void setDate_fin_absence(Date date_fin_absence) {
		this.date_fin_absence = date_fin_absence;
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

	public Absence(Long id, Date date_debut_absence, Date date_fin_absence, String motif) {
		super();
		this.id = id;
		this.date_debut_absence = date_debut_absence;
		this.date_fin_absence = date_fin_absence;
		this.motif = motif;
	}

	

}
