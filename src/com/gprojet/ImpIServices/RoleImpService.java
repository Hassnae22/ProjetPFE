package com.gprojet.ImpIServices;

import java.util.List;

import com.gprojet.IServices.IServiceRole;

import com.gprojet.dao.IDAORole;
import com.gprojet.entities.Role;

import com.gprojet.impdao.DaoImpRole;

public class RoleImpService implements IServiceRole {
 
	// Create object depuis la classe DaoImpRole A partir de l'interface IDaoRole
	  IDAORole dao =  new DaoImpRole();

	@Override
	public List<Role> getAll() throws Exception {
		
		return dao.getAll();
	}

	@Override
	public Role FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getOne(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
