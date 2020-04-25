package com.gprojet.impdao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gprojet.dao.IDAOMateriels;
import com.gprojet.entities.Materiels;
import com.gprojet.util.HibernateUtil;

public class DaoImpMateriels implements IDAOMateriels {

	@Override
	public List<Materiels> getAll() throws Exception {
		List<Materiels> materiels = new ArrayList<Materiels>();
		   try {
		
		       Session session = HibernateUtil.getSessionFactory().openSession() ;
		       Transaction tr = session.beginTransaction();
		       
		       materiels = session.createQuery("from Materiels").getResultList();
		
           tr.commit();
           
		
		     }
	     catch (Exception e) {
		System.out.print(e.getMessage());
	      } 
		
		return materiels;
	}

	
	@Override
	public boolean save(Materiels obj) {
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
	public boolean update( Materiels obj) {
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
	public Materiels getOne(String nom) {
		Materiels materiel = null;
		try {
			
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tr = s.beginTransaction();
		    
            materiel = (Materiels) s.createQuery("from Materiels where nom =:nom").setParameter("nom", nom).list().get(0);
			tr.commit();
		    } 
		catch (Exception e) {
			System.out.print(e.getMessage());}
		   
		return materiel;
	}


	@Override
	public boolean delete(Materiels obj) {
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
	public Materiels FindById(int id) {
		Materiels materiele = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			
			materiele = session.get(Materiels.class, id);
			
			tr.commit();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		
		session.close(); 
		return materiele;
	}

	
}
