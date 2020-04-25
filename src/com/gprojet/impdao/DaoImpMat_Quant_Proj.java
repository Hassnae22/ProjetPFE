package com.gprojet.impdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gprojet.dao.IDAOMat_Quant_Proj;
import com.gprojet.entities.Mat_Quant_Proj;

import com.gprojet.util.HibernateUtil;

public class DaoImpMat_Quant_Proj  implements IDAOMat_Quant_Proj{
	@Override
	public List<Mat_Quant_Proj> getAll() throws Exception {
		List<Mat_Quant_Proj> proj_quantites = new ArrayList<Mat_Quant_Proj>();
		   try {
		
		       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		       Transaction tr = session.beginTransaction();
		
		       proj_quantites = session.createQuery("from Mat_Quant_Proj").getResultList();
		
     tr.commit();
     session.close();
		   }
		     catch (Exception e) {
			System.out.print(e.getMessage());
		      } 
			
			return proj_quantites;
		
	}

	
	@Override
	public boolean save(Mat_Quant_Proj obj) {
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
	public boolean update(Mat_Quant_Proj obj) {
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
	public Mat_Quant_Proj getOne(String nom) {
		Mat_Quant_Proj quant = null;
		try {
			
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tr = s.beginTransaction();
		    
            quant = (Mat_Quant_Proj) s.createQuery("from Mat_Quant_Proj where nom =:nom").setParameter("nom", nom).list().get(0);
			tr.commit();
		    } 
		catch (Exception e) {
			System.out.print(e.getMessage());}
		   
		return quant;
	}

	

	@Override
	public boolean delete(Mat_Quant_Proj obj) {
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
	public Mat_Quant_Proj FindById(int id) {
		Mat_Quant_Proj quant = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			
			quant = session.get(Mat_Quant_Proj.class, id);
			
			tr.commit();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		
		session.close(); 
		return quant;
	}

	
}



