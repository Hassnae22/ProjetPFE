package com.gprojet.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="PROJET")
public class Projet {
	@Id
	@GeneratedValue
	@Column(name="ID_PROJET")
	private int id_projet;
	@Column(name="NOM")
	private String Nom;
	@Column(name="DATE_DEBUT")
	private Date date_debut ;
	@Column(name="DATE_FIN")
	private Date date_fin;
	
   @ManyToMany(mappedBy="projets")
   private List<Utilisateur> utilisateurs = new ArrayList<>();

    @OneToMany(mappedBy="projet", fetch=FetchType.EAGER)
    private List<Mat_Quant_Proj> quantites=new ArrayList<Mat_Quant_Proj>();

	public int getId_projet() {
		return id_projet;
	}

	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	
	public List<Utilisateur> getUtilisateur() {
		return utilisateurs;
	}

	public void setUtilisateur(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Mat_Quant_Proj> getQuantites() {
		return quantites;
	}

	public void setQuantites(List<Mat_Quant_Proj> quantites) {
		this.quantites = quantites;
	}

	public Projet() {
		super();
	}
   
	public Projet(String nom, Date date_debut, Date date_fin) {
		super();
		Nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	@Override
	public String toString() {
		return "Projet [id_projet=" + id_projet + ", Nom=" + Nom + ", date_debut=" + date_debut + ", date_fin="
				+ date_fin + ", utilisateurs=" + utilisateurs + "]";
	}

	
	
    
	

}
