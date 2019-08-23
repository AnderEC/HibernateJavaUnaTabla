package com.example.demo;

import java.util.Scanner;

import com.example.demo.servicio.UsuarioServicio;;

public class DemoApplication {

	public static void main(String[] args) 
	{
		UsuarioServicio usuarioServicio = new UsuarioServicio();
		
		Scanner leer = new Scanner(System.in);
		
		int opcion;
		
		
		while(true)
		{
			System.out.println("Elija la Opcion: -----------------------------");
			System.out.println("1. Ingresar Usuario");
			System.out.println("2. Mostrar Usuario");
			System.out.println("3. Modificar Usuario");
			System.out.println("4. Eliminar Usuario");
			opcion = leer.nextInt();
			
			switch(opcion)
			{
				case 1:
					usuarioServicio.IngresarUsuario();
					break;
					
				case 2:
					usuarioServicio.MostrarUsuarios();
					break;
					
				case 3:					
					usuarioServicio.ModificarUsuario();
					break;
					
				case 4:
					usuarioServicio.BorrarUsuario();
					break;
			}
			
			
			
		}
		
		
	}

}
