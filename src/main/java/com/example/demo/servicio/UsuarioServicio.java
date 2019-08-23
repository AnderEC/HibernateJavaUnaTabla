package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entidad.Usuario;

public class UsuarioServicio 
{
	public static List<Usuario> usuariosLista = new ArrayList<Usuario>();
	
	Usuario usuarioObjeto;
	UsuarioDao usuariosDao = new UsuarioDao();
	
	Scanner leer = new Scanner(System.in);
	
	//POST
	public Usuario IngresarUsuario()
	{
		String nombreUsuario;
		int edadUsuario;
		
		System.out.println("Ingrese nombre");
		nombreUsuario = leer.next();
		System.out.println("Ingrese edad");
		edadUsuario = leer.nextInt();
		
		usuarioObjeto = new Usuario(nombreUsuario, edadUsuario);
		
		usuariosLista.add(usuarioObjeto);
		usuariosDao.guardarUsuario(usuarioObjeto);
		
		
		return usuarioObjeto;		
	}
	
	//GET
	public void MostrarUsuarios()
	{
		List<Usuario> usuarios = usuariosDao.mostrarUsuarios();
		usuarios.forEach(s -> System.out.println(s.toString()));
	}
	
	//PUT
	public Usuario ModificarUsuario()
	{
		int idModificar;
		String nombreModificar; 
		int edadModificar;
		
		System.out.println("Ingrese el id a modificar");
		idModificar = leer.nextInt();
		System.out.println("Ingrese el Nombre a modificar");
		nombreModificar = leer.next();
		System.out.println("Ingrese la Edad a modificar");
		edadModificar = leer.nextInt();
		
		usuarioObjeto.setNombre(nombreModificar);
		usuarioObjeto.setEdad(edadModificar);
		usuarioObjeto.setId(idModificar);
		
		usuariosDao.actualizarUsuarios(idModificar, usuarioObjeto);
		
		
		return usuarioObjeto;
	}
	
	//DELETE
	public Usuario BorrarUsuario()
	{
		int idEliminar;
		System.out.println("Ingrese el id a eliminar");
		idEliminar = leer.nextInt();
		
		usuariosDao.eliminarUsuario(idEliminar, usuarioObjeto);
		
		return usuarioObjeto;
	}
}
