package ar.edu.ungs.prog2.ticketek;


public class Entrada implements IEntrada {
	
	Usuario dueñoEntrada;
	Integer codigo;
	String nombreEspectaculo;
	Fecha fecha;
	Sede sede;
	String sector;
	double precio;
	Integer nroAsiento;
	int nroFila;
		

	public Entrada(Integer codigo, String nombreEspectaculo, Fecha fecha, Sede sede, double precio, Usuario dueño) {
		super();
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.sede = sede;
		this.precio = precio;
		this.dueñoEntrada = dueño;
	}

	public Entrada(Integer codigo, String nombreEspectaculo, Fecha fecha, Sede sede,String sector,int nroFila, int nroAsiento, double precio, Usuario dueño) {
		super();
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.sede = sede;
		this.sector = sector;
		this.nroAsiento = nroAsiento;
		this.precio = precio;
		this.nroFila = nroFila;
		this.dueñoEntrada = dueño;
	}
	

	@Override
	public double precio() {	
		
		return this.precio;
	}

	@Override
	public String ubicacion() {
		if(sede.getClass().getSimpleName().equals("Estadio"))
			return "CAMPO";
		else if(sede.getClass().getSimpleName().equals("Teatro"))
			return this.sector + "f: " + this.nroFila + "a: " + this.nroAsiento; 
			
		return null;
	}

	@Override
	public String toString() {
		
//		LocalDate hoy = LocalDate.now();
		if (fecha.esAnterior()) {
			return "- " + codigo + " - " + nombreEspectaculo + " - " + fecha.toString() + " P" + " - " + sede.nombre + " - " + this.ubicacion()  ;
		}
		return "- " + nombreEspectaculo + " - " + fecha.toString() + " - " + sede.nombre + " - " + this.ubicacion() ;			
	}
}
