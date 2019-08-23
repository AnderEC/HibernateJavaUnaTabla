package com.example.demo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.example.demo.entidad.Usuario;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactoria()
	{
		if(sessionFactory == null)
		{
			try
			{
				Configuration configuration = new Configuration();
				
				Properties ajustes = new Properties();
				
				ajustes.put(Environment.SHOW_SQL, "true");
				ajustes.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?useSSL=false");
				ajustes.put(Environment.USER, "root");
				ajustes.put(Environment.PASS, "coronel1194");
				ajustes.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				
				ajustes.put(Environment.SHOW_SQL, "true");
                ajustes.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                ajustes.put(Environment.HBM2DDL_AUTO, "create-drop");
                
                configuration.setProperties(ajustes);
                configuration.addAnnotatedClass(Usuario.class);
                
                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}
}
