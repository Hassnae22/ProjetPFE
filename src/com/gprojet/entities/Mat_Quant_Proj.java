package com.gprojet.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="mat_quant_proj")
public class Mat_Quant_Proj {
	    @Id
		@GeneratedValue
		@Column(name="ID")
	    private int id;
		
		@Column(name="QUANTITE")
		private int quantite;
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="id_projet")
		private Projet projet;
        
		@OneToMany(mappedBy="quan",fetch=FetchType.EAGER)
		private List<Materiels> materiels = new ArrayList<Materiels>();

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}

		public Projet getProjet() {
			return projet;
		}

		public void setProjet(Projet projet) {
			this.projet = projet;
		}

		public List<Materiels> getMateriels() {
			return materiels;
		}

		public void setMateriels(List<Materiels> materiels) {
			this.materiels = materiels;
		}

		

		
		
		
		

}
