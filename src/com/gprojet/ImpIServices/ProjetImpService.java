package com.gprojet.ImpIServices;

import java.util.List;

import com.gprojet.IServices.IServiceProjet;

import com.gprojet.dao.IDAOProjet;
import com.gprojet.entities.Projet;

import com.gprojet.impdao.DaoImpProjet;

public class ProjetImpService implements IServiceProjet{
	
	// Create object depuis la classe DaoImpProjet A partir de l'interface IDaoProjet
	  IDAOProjet dao =  new DaoImpProjet();

	@Override
	public List<Projet> getAll() throws Exception {
		
		return dao.getAll();
	}

	

	@Override
	public boolean save(Projet obj) {
		
		return dao.save(obj);
	}

	@Override
	public boolean update(Projet obj) {
		
		return dao.update(obj);
	}

	

	@Override
	public Projet getOne(String nom) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean delete(Projet obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Projet FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
