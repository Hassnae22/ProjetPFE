package com.gprojet.IServices;

import java.util.List;

import com.gprojet.entities.Utilisateur;

public interface IServiceUtilisateur{
List<Utilisateur> getAll() throws Exception;
	
Utilisateur FindById(int id);

Utilisateur getOne(String nom);
	
	boolean save(Utilisateur obj);
	
	boolean update(Utilisateur obj);
	
	boolean delete(Utilisateur obj);

	public int login(String username,String pwd) throws Exception;
	
}
