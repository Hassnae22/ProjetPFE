package com.gprojet.impdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gprojet.dao.IDAOUtilisateur;
import com.gprojet.entities.Utilisateur;
import com.gprojet.util.HibernateUtil;

public class DaoImpUtilisateur implements IDAOUtilisateur {

	@Override
	public List<Utilisateur> getAll() throws Exception {
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		   try {
			   
		       Session session = HibernateUtil.getSessionFactory().openSession();
		       Transaction tr = session.beginTransaction();
		       
		       utilisateurs = session.createQuery("from Utilisateur").getResultList();
		       tr.commit();
               }
	     catch (Exception e) {
		      System.out.print(e.getMessage()); } 
		
		   return utilisateurs;   }
   
	@Override
	public Utilisateur getOne(String nom) {
		
		Utilisateur Users = null;
		try {
			
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tr = s.beginTransaction();
		    
            Users = (Utilisateur) s.createQuery("from Utilisateur where nom =:nom").setParameter("nom", nom).list().get(0);
			tr.commit();
		    } 
		catch (Exception e) {
			System.out.print(e.getMessage());}
		   
		return Users; }

	
	@Override
	public boolean delete(Utilisateur obj) {
        
		try {
		    System.out.println(obj.toString());
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        Transaction tr = session.beginTransaction();
		    
	        session.delete(obj);
	        tr.commit();
	        
		    return true;  
		    } 
	  catch (Exception e) { System.out.print(e.getMessage()); }

	   return false;

	}
	@Override
	public boolean save(Utilisateur obj) {
		 
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tr = session.beginTransaction();
		try { 
			   
			     session.save(obj);
		         tr.commit();
				 return true;
		}
		
		
		catch (Exception e) {  System.out.print(e.getMessage()); } 
		
		session.close();
		return false;
	}

	

@Override
	public int login(String username, String pwd) throws Exception {
		List<Utilisateur> utilisateur = getAll();

		for(Utilisateur u : utilisateur)
			if(u.getUsername().equals(username) && u.getPwd().equals(pwd))
				return u.getRole().getId_role();
		
		        return -1; 
	}




@Override
public boolean update(Utilisateur obj) {
	try {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tr = s.beginTransaction();

		s.update(obj);

		tr.commit();
		return true;
	} catch (Exception e) {
		return false;
	}
}

@Override
public Utilisateur FindById(int id) {
	Utilisateur user = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tr = session.beginTransaction();
	
	try {
		
		user = session.get(Utilisateur.class, id);
		
		tr.commit();
		
	} catch (Exception e) {
		System.out.print(e.getMessage());
		
	}
	
	session.close(); 
	return user;
}
}