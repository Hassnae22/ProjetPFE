package com.gprojet.IServices;

import java.util.List;

import com.gprojet.entities.Materiels;

public interface IServiceMateriels{
List<Materiels> getAll() throws Exception;
	
Materiels FindById(int id);

Materiels getOne(String nom);
	
	boolean save(Materiels obj);
	
	boolean update(Materiels obj);
	
	boolean delete(Materiels obj);

}
