package com.example.demo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.demo.entidad.Usuario;
import com.example.demo.servicio.UsuarioServicio;
import com.example.demo.util.HibernateUtil;

public class UsuarioDao 
{
	public void guardarUsuario(Usuario usuario) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Guarda el objeto Usuario
            session.save(usuario);
            
            // Realizar transaccion
            transaction.commit();
            
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
                transaction.rollback();
            
            e.printStackTrace();
        }
    }
    public List<Usuario> mostrarUsuarios() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) 
        {
            return session.createQuery("from Usuario", Usuario.class).list();
        }
    }
    
    public void actualizarUsuarios(int id, Usuario usuario)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.update(convertir, usuario);
            
            // Realizar transaccion
            transaction.commit();
            
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
                transaction.rollback();
            
            e.printStackTrace();
        }
    	
    }
    
    public void eliminarUsuario(int id, Usuario usuario)
    {
    	String convertir = String.valueOf(id);
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            
        	// Inicia la transaccion
            transaction = session.beginTransaction();
            
            // Modifica el objeto Usuario
            session.delete(usuario);
            
            // Realizar transaccion
            transaction.commit();
            
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
                transaction.rollback();
            
            e.printStackTrace();
        }
    }
}
