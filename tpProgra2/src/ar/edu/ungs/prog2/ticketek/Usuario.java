package ar.edu.ungs.prog2.ticketek;

import java.util.LinkedHashMap;

public class Usuario {
	
	String email;
	String nombre;
	String apellido;
	String contraseña;
	LinkedHashMap <Integer,IEntrada> entradas = new LinkedHashMap<>();
	
	Usuario(String email,String nombre,String apellido,String contraseña){
		
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
	}

	public IEntrada entradasFuturas() {
		
		return null;
	}
}
