package fr.school.bean;

import java.io.Serializable;
import java.sql.Date;

public class RetardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Date date_retard;
	
	private int duree_retard;
	
	private String motif;
	
	private long utilisateur_id;

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

	public long getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RetardBean() {
		super();
	}
	
	
}
