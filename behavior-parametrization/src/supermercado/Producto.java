package supermercado;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	private String nombre;
	private int seccion;
	private LocalDate fechaCaducidad;
	private float precio;
	
	public Producto(String pNombre, LocalDate pFechaCaducidad, float pPrecio, int pSeccion) {
		this.nombre = pNombre;
		this.fechaCaducidad = pFechaCaducidad;
		this.precio = pPrecio;
		this.seccion = pSeccion;
	}
	
	public LocalDate getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public float getPrecio() {
		return this.precio;
	}
	
	public int getSeccion() {
		return this.seccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int hashCode() { 
		return 31+Objects.hashCode(nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || obj!=null && getClass()==obj.getClass() && Objects.equals(nombre, ((Producto)obj).nombre);
	}
}
