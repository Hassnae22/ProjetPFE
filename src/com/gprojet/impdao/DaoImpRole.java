package com.gprojet.impdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gprojet.dao.IDAORole;

import com.gprojet.entities.Role;

import com.gprojet.util.HibernateUtil;

public class DaoImpRole implements IDAORole{
	// Methode 1 : get All Roles 

	@Override
	public List<Role> getAll() throws Exception {
		List<Role> roles = new ArrayList<Role>();
		   try {
		
		       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		       Transaction tr = session.beginTransaction();
		
		       roles = session.createQuery("from Role").getResultList();
		
        tr.commit();
        session.close();
		   }
		     catch (Exception e) {
			System.out.print(e.getMessage());
		      } 
			
			return roles;
		
	}

  // Methode 2 : save role 

	@Override
	public boolean save(Role obj) {
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
   
  // Methode 3 : update Role 
	@Override
	public boolean update(Role obj) {
		
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = s.beginTransaction();
       
        try {
			
		    s.update(obj);
            tr.commit();
			return true;
			
		}  catch (Exception e) { return false;} 
		
	
	}

  // Methode 4 : getOne Role 

	@Override
	public Role getOne(String nom) {
        Role role = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tr = s.beginTransaction();
		
		try {
			
			role = (Role) s.createQuery("from Role").list().get(0);

			/*Query q = s.createQuery("from Users where firstName = :name");
			   
            q.setString("name", name);
            
            List <Users> use = (List<Users>) q.list();
           
            Users = use.get(1);*/
            
			tr.commit();
		} catch (Exception e) { System.out.print(e.getMessage()); }
		s.close();
		return role;
	}

 //Methode 5 : delete Role 
	@Override
	public boolean delete(Role obj) {
	   
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
	  
	try {
		    session.delete(obj);
	        tr.commit();
	        
		    return true;  
		    } 
	  catch (Exception e) { System.out.print(e.getMessage()); }
	  session.close();
	   return false;
	}


  //Methode 6 : Find Role By Id 
	@Override
	public Role FindById(int id) {
		Role role = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		try {
			
			role = session.get(Role.class, id);
			
			tr.commit();
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			}
		
		session.close(); 
		return role;
	}

	
}
