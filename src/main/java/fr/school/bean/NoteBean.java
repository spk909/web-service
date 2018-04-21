package fr.school.bean;

import java.io.Serializable;

public class NoteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private double note;
	
	private String appreciation;
	
	private String libelle_evaluation;
	
	private long matiere_id;
	
	private long utilisateur_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public String getLibelle_evaluation() {
		return libelle_evaluation;
	}

	public void setLibelle_evaluation(String libelle_evaluation) {
		this.libelle_evaluation = libelle_evaluation;
	}

	public long getMatiere_id() {
		return matiere_id;
	}

	public void setMatiere_id(long matiere_id) {
		this.matiere_id = matiere_id;
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

	public NoteBean() {
		super();
	}
	
	
	
	
}
