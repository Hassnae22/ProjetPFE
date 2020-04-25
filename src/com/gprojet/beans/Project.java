package com.gprojet.beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gprojet.IServices.IServiceProjet;
import com.gprojet.ImpIServices.ProjetImpService;
import com.gprojet.entities.Projet;
import com.gprojet.entities.Utilisateur;

@ManagedBean
@SessionScoped
public class Project {
	// Attributs 
	  IServiceProjet service = new ProjetImpService();
      private Projet projet;
    // Getters and Setters :   
	public IServiceProjet getService() {
		return service;
	}
	public void setService(IServiceProjet service) {
		this.service = service;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
    
	// Methode 1 : get all chefs
    public String chef(Projet projet) throws Exception{
		List<Utilisateur> all = projet.getUtilisateur();
		Utilisateur chef = new Utilisateur();
		for(Utilisateur U : all) {
		    
			if(U.getRole().getId_role()==2)
				chef = U; }
		
		return chef.getNom()+""+chef.getPrenom();
		}
    
    
    
    //Methode 2 : get all projets
    
    public List<Projet> getAllProj() throws Exception{
    	
    	return service.getAll();
    }
	}
	
	 




