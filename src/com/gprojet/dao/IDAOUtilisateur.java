package com.gprojet.dao;



import com.gprojet.entities.Utilisateur;

public interface IDAOUtilisateur  extends IDAO<Utilisateur>{
	
	public int login(String username,String pwd) throws Exception;
	
}
