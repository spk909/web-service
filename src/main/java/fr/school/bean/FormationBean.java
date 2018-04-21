package fr.school.bean;

import java.io.Serializable;
import java.util.Date;

public class FormationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date promotion;
	private Long utilisateur_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPromotion() {
		return promotion;
	}
	public void setPromotion(Date promotion) {
		this.promotion = promotion;
	}
	public Long getUtilisateur_id() {
		return utilisateur_id;
	}
	public void setUtilisateur_id(Long utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
