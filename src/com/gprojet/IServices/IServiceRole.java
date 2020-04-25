package com.gprojet.IServices;

import java.util.List;

import com.gprojet.entities.Role;

public interface IServiceRole{
    
	List<Role> getAll() throws Exception;
	
	Role FindById(int id);

	Role getOne(String nom);
	
	boolean save(Role obj);
	
	boolean update(Role obj);
	
	boolean delete(Role obj);
}
