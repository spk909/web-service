package fr.school.bean;

import java.io.Serializable;
import java.util.Date;

public class UtilisateurBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nom;

	private String prenom;

	private Date date_de_naissance;

	private String adresse;

	private int telephone;

	private int code_postal;

	private String ville;

	private String login;

	private String password;

	private String email;

	private String photo_profile;

	private String biographie;

	private String nationalite;

	private String civilite;

	private long typeUtilisateur_id;
	
	private long formation_id;
	
	private long classe_id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public long getFormation_id() {
		return formation_id;
	}

	public void setFormation_id(long formation_id) {
		this.formation_id = formation_id;
	}

	public long getClasse_id() {
		return classe_id;
	}

	public void setClasse_id(long classe_id) {
		this.classe_id = classe_id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto_profile() {
		return photo_profile;
	}

	public void setPhoto_profile(String photo_profile) {
		this.photo_profile = photo_profile;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public long getTypeUtilisateur_id() {
		return typeUtilisateur_id;
	}

	public void setTypeUtilisateur_id(long typeUtilisateur_id) {
		this.typeUtilisateur_id = typeUtilisateur_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UtilisateurBean() {
		super();
	}

	
	
}
