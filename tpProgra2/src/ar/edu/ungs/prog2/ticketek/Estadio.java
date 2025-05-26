package ar.edu.ungs.prog2.ticketek;

import java.util.Objects;

public class Estadio extends Sede {

	
	
	public Estadio(String nombre, String direccion, int capacidadMaxima) {
		super(nombre, direccion, capacidadMaxima);

	}

	@Override
	public String toString() {
		return " capacidadMaxima: " + capacidadMaxima + ", direccion: " + direccion + ", nombre: " + nombre ;
	}
	
	
	@Override
	public int hashCode() {
		
		return Objects.hash(nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadio other = (Estadio) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
