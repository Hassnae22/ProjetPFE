package com.gprojet.IServices;

import java.util.List;

import com.gprojet.entities.Projet;

public interface IServiceProjet{
List<Projet> getAll() throws Exception;
	
   Projet FindById(int id);

   Projet getOne(String nom);
	
	boolean save(Projet obj);
	
	boolean update(Projet obj);
	
	boolean delete(Projet obj);

}
