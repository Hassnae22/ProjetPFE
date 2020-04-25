package com.gprojet.impdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gprojet.dao.IDAOProjet;
import com.gprojet.entities.Projet;
import com.gprojet.util.HibernateUtil;

public class DaoImpProjet implements IDAOProjet{

	@Override
	public List<Projet> getAll() throws Exception {
		List<Projet> projets = new ArrayList<Projet>();
		 Session session = HibernateUtil.getSessionFactory().openSession() ;
	       Transaction tr = session.beginTransaction(); 
		
		try {
		
		 projets = session.createQuery("from Projet").getResultList();
		 tr.commit();
         }
		     catch (Exception e) {
			System.out.print(e.getMessage());
		      } 
		   session.close();
			return projets;
		
	}

	
	@Override
	public boolean save(Projet obj) {
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
	public boolean update(Projet obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.beginTransaction();
          try {
	            session.update(obj);
			    tr.commit();
			    return true;
          }
          catch (Exception e) { System.out.print(e.getMessage()); }
          session.close();
          return false;
	}

	
	@Override
	public Projet getOne(String nom) {
		Projet projet = null;
		try {
			
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tr = s.beginTransaction();
		    
            projet = (Projet) s.createQuery("from Projet where nom =:nom").setParameter("nom", nom).list().get(0);
			tr.commit();
		    } 
		catch (Exception e) {
			System.out.print(e.getMessage());}
		   
		return projet; }
	

	@Override
	public boolean delete(Projet obj) {
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
	public Projet FindById(int id) {
		Projet projet = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			
			projet = session.get(Projet.class, id);
			
			tr.commit();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		
		session.close(); 
		return projet;
	}

	
}
