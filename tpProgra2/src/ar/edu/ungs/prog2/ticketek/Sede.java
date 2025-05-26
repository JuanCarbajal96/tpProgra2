package ar.edu.ungs.prog2.ticketek;

public abstract class Sede {
	
	protected int capacidadMaxima;
	protected String direccion;
	protected final String nombre;
	
	public Sede(String nombre, String direccion, int capacidadMaxima ) {
		this.capacidadMaxima = capacidadMaxima;
		this.nombre = nombre;
		this.direccion = direccion;
		
	}
	
	@Override
	public abstract String toString();
		
	@Override
	public abstract int hashCode() ;
	

	@Override
	public abstract boolean equals(Object obj);		
}
