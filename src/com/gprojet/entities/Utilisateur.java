package com.gprojet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@GeneratedValue
	@Column(name="ID_USER")
    private int id_user;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="CIN")
	private String cin;
	
	public Utilisateur(String nom, String prenom, String cin, String username) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		Username = username;
	}


	@Column(name="USERNAME")
	private String Username;
	
	@Column
	private String pwd;
	
	@ManyToMany
	@JoinTable(name="proj_users",
	           joinColumns = @JoinColumn(name="id_user"), 
	           inverseJoinColumns = @JoinColumn(name="id_projet"))
	private List<Projet> projets = new ArrayList<Projet>();
	
	
   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="id_role")
   private Role role;


public int getId_user() {
	return id_user;
}


public void setId_user(int id_user) {
	this.id_user = id_user;
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


public String getCin() {
	return cin;
}


public void setCin(String cin) {
	this.cin = cin;
}


public String getUsername() {
	return Username;
}


public void setUsername(String username) {
	Username = username;
}


public String getPwd() {
	return pwd;
}


public void setPwd(String pwd) {
	this.pwd = pwd;
}


public List<Projet> getProjets() {
	return projets;
}


public void setProjets(List<Projet> projets) {
	this.projets = projets;
}


public Role getRole() {
	return role;
}


public void setRole(Role role) {
	this.role = role;
}



public Utilisateur() {
	
}


public Utilisateur(int id_user, String nom, String prenom, String cin, String username, String pwd) {
	super();
	this.id_user = id_user;
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	Username = username;
	this.pwd = pwd;
}


public Utilisateur(int id_user, String nom, String prenom, String cin, String username, String pwd,
		List<Projet> projets, Role role) {
	super();
	this.id_user = id_user;
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	Username = username;
	this.pwd = pwd;
	this.projets = projets;
	this.role = role;
}


public Utilisateur(String nom, String prenom, String cin) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
}


@Override
public String toString() {
	return "Utilisateur [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", Username="
			+ Username + ", pwd=" + pwd + ", projets=" + projets + "]";
}



   
   
  

}