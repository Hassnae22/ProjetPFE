package com.gprojet.ImpIServices;

import java.util.List;

import com.gprojet.IServices.IServiceMateriels;

import com.gprojet.dao.IDAOMateriels;
import com.gprojet.entities.Materiels;

import com.gprojet.impdao.DaoImpMateriels;

public class MaterielsImpService implements IServiceMateriels{
	
	// Create object depuis la classe DaoImpArticle A partir de l'interface IDaoMateriels
		  IDAOMateriels dao =  new DaoImpMateriels();
		  
	@Override
	public List<Materiels> getAll() throws Exception {
		
		return dao.getAll();
	}

	

	@Override
	public boolean save(Materiels obj) {
		
		return dao.save(obj);
	}

	@Override
	public boolean update(Materiels obj) {
		
		return dao.update(obj);
	}



	
	@Override
	public Materiels getOne(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Materiels obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Materiels FindById(int id) {
		return dao.FindById(id);
	}

}
