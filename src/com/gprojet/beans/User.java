package com.gprojet.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.gprojet.IServices.IServiceRole;
import com.gprojet.IServices.IServiceUtilisateur;
import com.gprojet.ImpIServices.RoleImpService;
import com.gprojet.ImpIServices.UtilisateurImpService;
import com.gprojet.entities.Role;
import com.gprojet.entities.Utilisateur;

@ManagedBean
@SessionScoped
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
	IServiceUtilisateur service = new UtilisateurImpService();
	IServiceRole service1 = new RoleImpService();
     
	private Utilisateur users = new Utilisateur();
	private int id_user;
	private String username;
	private String pwd;
	
   
	//getter and setters des attributes : 
	public IServiceUtilisateur getService() {
		return service;
	}
	public void setService(IServiceUtilisateur service) {
		this.service = service;
	}
	public Utilisateur getUsers() {
		return users;
	}

	public void setUsers(Utilisateur users) {
		this.users = users;
	}
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//Methode 1 :  verification 

	public String VerifAuth() throws Exception {
		if(service.login(username , pwd)==1)
			  return "projets.xhtml";
			else
				 if(service.login(username , pwd)==2)
			  
		    	   return "exp2.xhtml";
				 else
		            if(service.login(username , pwd)==3)
		        
			         return "exp3.xhtml";
		            else
			 return "login.xhtml";
		}

	//Methode 2 : get all ingenieurs 
    
	public List<Utilisateur> getAllUsers() throws Exception{
		 
		List<Utilisateur> ingn = new ArrayList<Utilisateur>();
		List<Utilisateur> all=service.getAll();
	for(Utilisateur U : all )
	  { 
		 if(U.getRole().getId_role()==2)
		      ingn.add(U);
     }
		return ingn;    }
	//Methode 3 : Delete user
	  
	public void deleteUser(String nom) {
		 users=service.getOne(nom);
		 service.delete(users);
	 }
	 
	//Methode 4 : Update user
	public String FindUser(int id_user) {
		
	     users=service.FindById(id_user);
		 
		 return "update.xhtml";
	 }
	
	public String updateU() {
		service.update(users);
		 return "users";
	 }
	 // Methode 4 : Save user
	
	public String saveA(){
	   
		if(users.getUsername()==null) 
		  {
			users.setUsername(users.getNom()+"_"+users.getPrenom());
		    users.setPwd("1234");   }
		
		 service.save(users);
		 return "users";
	}
	
	//Methode 5 : get all roles 
	public List<Role> getAllRoles() throws Exception{
		
		List<Role> TechInge = new ArrayList<Role>();
		List<Role> all = service1.getAll();
		for(Role r : all) {
		   if(r.getId_role()!=1)
			   TechInge.add(r); }
		return TechInge;
	}
	public User() {  users.setRole(new Role());}
	
}// fin beans	

	
	
	
	
   
  



  
   
 
 
 
 


