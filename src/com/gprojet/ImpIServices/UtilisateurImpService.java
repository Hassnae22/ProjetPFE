package com.gprojet.ImpIServices;

import java.util.List;

import com.gprojet.IServices.IServiceUtilisateur;

import com.gprojet.dao.IDAOUtilisateur;
import com.gprojet.entities.Utilisateur;

import com.gprojet.impdao.DaoImpUtilisateur;

public class UtilisateurImpService implements IServiceUtilisateur{
     
	// Create object depuis la classe DaoImpUtilisateur A partir de l'interface IDaoUtilisateur
		  IDAOUtilisateur dao =  new DaoImpUtilisateur();
	@Override
	public List<Utilisateur> getAll() throws Exception {
		
		return dao.getAll();
	}
	

	@Override
	public boolean save(Utilisateur obj) {
		
		return dao.save(obj);
	}

	@Override
	public boolean update(Utilisateur obj) {
		
		return dao.update(obj);
	}

	
    
	
	
	@Override
	public int login(String username, String pwd) throws Exception {
		
		 return dao.login(username, pwd);
	}

	@Override
	public Utilisateur getOne(String nom) {
		
		return dao.getOne(nom);
	}

	

	@Override
	public boolean delete(Utilisateur obj) {
		return dao.delete(obj);
	}


	@Override
	public Utilisateur FindById(int id) {
		
		return dao.FindById(id);
	}

	

	
	
}
