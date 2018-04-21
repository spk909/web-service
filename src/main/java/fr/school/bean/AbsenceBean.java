package fr.school.bean;

import java.io.Serializable;
import java.util.Date;

public class AbsenceBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Date date_debut_absence;

	private Date date_fin_absence;

	private String motif;

	private long utilisateur_id;

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

	public long getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AbsenceBean() {
		super();
	}

	
}
