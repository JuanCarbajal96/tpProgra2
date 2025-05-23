package ar.edu.ungs.prog2.ticketek;

import java.util.LinkedHashMap;
import java.util.Map;

public class Funcion {

	Fecha fecha;
	Sede sede;
	LinkedHashMap<String,Integer> entradasVendidas = new LinkedHashMap<>();
	double precioBase;

	Funcion(Fecha fecha,Sede sede,double precioBase) {

		this.fecha = fecha;
		this.sede = sede;
		this.precioBase = precioBase;

		if(sede.getClass().getSimpleName().equals("Estadio")){

			this.entradasVendidas.put("Campo", 0);
		}
		else {			
			this.entradasVendidas.put("VIP", 0);
			this.entradasVendidas.put("Comun", 0);
			this.entradasVendidas.put("Baja", 0);
			this.entradasVendidas.put("Alta", 0);
		}
	}


	@Override
	public String toString() {

		StringBuilder info = new StringBuilder(" - " +"(" + fecha.toString() + ") " + sede.nombre + " - ");

		//Si la sede es en un estadio devuelve fecha, nombre de sede, entradas vendidas y capacidad estadio.
		if ( sede.getClass().getSimpleName().equals("Estadio")) {

			info.append(entradasVendidas.get("Campo")).append(sede.capacidadMaxima);
			return info.toString();
		}
		//Si la sede es teatro o miniEstadio devuelve fecha, nombre de sede, sector, cantidad de entradas
		//vendidas por sector y capacidad del sector.
		else {
			for (Map.Entry<String, Integer> entrada : entradasVendidas.entrySet()) {

				String nombreSector = entrada.getKey();
				Integer cantidadVendida = entrada.getValue();
				int capacidad = sede.capacidadSector(nombreSector);
				info.append(nombreSector);
				info.append(": ");
				info.append(cantidadVendida);
				info.append("/");
				info.append(capacidad);
				if (!nombreSector.equals("Alta"))
					info.append(" | ");
			}
		}
		return info.toString();  
	}
	
 
	public double precio(String sector) {

		return this.precioBase * (1 + (this.sede.porcentajeAdicional(sector)/100));
	}

	
	public void agregarVenta(String nombreSector) {

		entradasVendidas.put(nombreSector, entradasVendidas.get(nombreSector) + 1);	
	}
	

	public void quitarVenta(String sector) {
		Integer cantidadActual = entradasVendidas.get(sector);
		if (cantidadActual > 0)
			entradasVendidas.put(sector, entradasVendidas.get(sector) - 1);
	}


	public double recaudacion() {
	    double recaudacion = 0;

	    for (Map.Entry<String, Integer> entrada : entradasVendidas.entrySet()) {
	        String sector = entrada.getKey();
	        int totalVendido = entrada.getValue();

	        if (sede instanceof Estadio) {
	            recaudacion += precioBase * totalVendido;
	        } 
	        else if (sede instanceof Teatro) {
	            double adicional = 1 + sede.porcentajeAdicional(sector) / 100.0;
	            recaudacion += totalVendido * (precioBase * ( adicional));
	        } 
	        else if (sede instanceof MiniEstadio) {
	            MiniEstadio mini = (MiniEstadio) sede;
	            double adicional = 1 + sede.porcentajeAdicional(sector) / 100.0;
	            recaudacion += totalVendido * ((precioBase * ( adicional)) + mini.getvalorFijoConsumicion());
	        }
	    }

	    return recaudacion;
	}
}