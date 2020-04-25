package com.gprojet.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.gprojet.entities.*;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		
		try {
			
			Configuration configuration =new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			
			
			configuration.addAnnotatedClass(Materiels.class);
			configuration.addAnnotatedClass(Projet.class);
			configuration.addAnnotatedClass(Mat_Quant_Proj.class);
			configuration.addAnnotatedClass(Role.class);
			configuration.addAnnotatedClass(Utilisateur.class);
			
			
			serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
         catch(Throwable th) {
			
			System.err.println("Initial SessionFactory creation failed"+ th);
			throw new ExceptionInInitializerError(th);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
