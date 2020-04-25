package com.gprojet.entities;

import javax.persistence.*;

@Entity
@Table(name="materiels")
public class Materiels {

	@Id
	@GeneratedValue
	@Column(name="ID_MATERIEL")
	private int id_materiel;
	
	@Column(name="NOM")
	private String Nom;
	
	@Column(name="UNITE")
	private String Unite;
	
	@Column(name="PRIX")
	private double Prix;
	
	@Column(name="FOURNISSEUR")
	private String Fournisseur;
	
	@Column(name="QUANTITE")
	private int Quant;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_materiel")
	private Mat_Quant_Proj quan;

	public int getId_materiel() {
		return id_materiel;
	}

	public void setId_materiel(int id_materiel) {
		this.id_materiel = id_materiel;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getUnite() {
		return Unite;
	}

	public void setUnite(String unite) {
		Unite = unite;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public String getFournisseur() {
		return Fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}

	public int getQuant() {
		return Quant;
	}

	public void setQuant(int quant) {
		Quant = quant;
	}

	public Mat_Quant_Proj getQuan() {
		return quan;
	}

	public void setQuan(Mat_Quant_Proj quan) {
		this.quan = quan;
	}

	public Materiels(int id_materiel, String nom, String unite, double prix, String fournisseur, int quant,
			Mat_Quant_Proj quan) {
		super();
		this.id_materiel = id_materiel;
		Nom = nom;
		Unite = unite;
		Prix = prix;
		Fournisseur = fournisseur;
		Quant = quant;
		this.quan = quan;
	}

	public Materiels() {
		super();
	}
	
	

	

}
