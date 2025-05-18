package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Teatro extends Sede {
	
	int asientosPorFila;
	
	ArrayList<Sector> sectores;

	public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		
		this.asientosPorFila = asientosPorFila;
		
		this.sectores = new ArrayList<Sector>();
		
		int cantidadSectores = sectores.length;
		
		for (int i = 0; i < cantidadSectores; i++) {
			
			Sector sector = new Sector(sectores[i],capacidad[i],porcentajeAdicional[i]);
			
			this.sectores.add(sector);
		} 
		
		
				
		
		
		
	}
	
	
	

}
