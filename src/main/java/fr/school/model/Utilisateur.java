package fr.school.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "profil_utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "	id", nullable = true)
	private Long id;

	@Column(name = "nom", nullable = true)
	private String nom;

	@Column(name = "prenom", nullable = true)
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_de_naissance", nullable = true)
	private Date date_de_naissance;

	@Column(name = "adresse", nullable = true)
	private String adresse;

	@Column(name = "telephone", nullable = true)
	private int telephone;

	@Column(name = "code_postal", nullable = true)
	private int code_postal;

	@Column(name = "ville", nullable = true)
	private String ville;

	@Column(name = "login", nullable = true)
	private String login;

	@Column(name = "password", nullable = true)
	private String password;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "photo_profile", nullable = true)
	private String photo_profile;

	@Column(name = "biographie", nullable = true)
	private String biographie;

	@Column(name = "nationalite", nullable = true)
	private String nationalite;

	@Column(name = "civilite", nullable = true)
	private String civilite;

	//@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "typeUtilisateur_id")
	private TypeUtilisateur typeUtilisateur;
	
	//@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formation_id")
	private Formation formation;
	
	//@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classe_id")
	private Classe classe;
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<Absence> absence;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utilisateur")
	private Set<Retard> retard;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	private Set<Note> note;
	
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	private Set<Cours> cours;
	
	

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

	public Set<Absence> getAbsence() {
		return absence;
	}

	public void setAbsence(Set<Absence> absence) {
		this.absence = absence;
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

	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public Set<Retard> getRetard() {
		return retard;
	}

	public void setRetard(Set<Retard> retard) {
		this.retard = retard;
	}

	

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	

	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	
	
	

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(Long id, String nom, String prenom, Date date_de_naissance, String adresse, int telephone,
			int code_postal, String ville, String login, String password, String email, String photo_profile,
			String biographie, String nationalite, String civilite, TypeUtilisateur typeUtilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.code_postal = code_postal;
		this.ville = ville;
		this.login = login;
		this.password = password;
		this.email = email;
		this.photo_profile = photo_profile;
		this.biographie = biographie;
		this.nationalite = nationalite;
		this.civilite = civilite;
		this.typeUtilisateur = typeUtilisateur;
	}

	public Utilisateur(Long id, String nom, String prenom, Date date_de_naissance, String adresse, int telephone,
			int code_postal, String ville, String login, String password, String email, String photo_profile,
			String biographie, String nationalite, String civilite, TypeUtilisateur typeUtilisateur,
			Set<Absence> absence) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.code_postal = code_postal;
		this.ville = ville;
		this.login = login;
		this.password = password;
		this.email = email;
		this.photo_profile = photo_profile;
		this.biographie = biographie;
		this.nationalite = nationalite;
		this.civilite = civilite;
		this.typeUtilisateur = typeUtilisateur;
		this.absence = absence;
	}

	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	

	public Utilisateur(String nom, String prenom, TypeUtilisateur typeUtilisateur) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.typeUtilisateur = typeUtilisateur;
	}

	public Utilisateur(Long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(String login) {
		super();
		this.login = login;
	}

	public Utilisateur(Long id) {
		super();
		this.id = id;
	}

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	public Utilisateur(Long id, String nom, String prenom, TypeUtilisateur typeUtilisateur, Classe classe) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		
		//recup du type de user
		TypeUtilisateur typeRecup= new  TypeUtilisateur();
		typeRecup.setId(typeUtilisateur.getId());
		typeRecup.setLibelle(typeUtilisateur.getLibelle());
		this.typeUtilisateur = typeRecup;
		
		//recup de la classe du user
		Classe classeRecup = new Classe();
			classeRecup.setId(classe.getId());
			classeRecup.setLibelle(classe.getLibelle());
			this.classe = classeRecup;
		
		
	}

	public Utilisateur(Long id, String nom, String prenom, TypeUtilisateur typeUtilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		//recup du type de user
		TypeUtilisateur typeRecup= new  TypeUtilisateur();
		typeRecup.setId(typeUtilisateur.getId());
		typeRecup.setLibelle(typeUtilisateur.getLibelle());
		this.typeUtilisateur = typeRecup;
	}
	
	

}
