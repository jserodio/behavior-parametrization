package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Estanteria {
	
	private String lugar;
	private String area;
	private List<Libro> coleccionLibros;
	
	public Estanteria(String pLugar, String pArea) {
		this.lugar = pLugar;
		this.area = pArea;
		coleccionLibros = new ArrayList<>();
	}
	
	public void addLibro(Libro pLibro) {
		coleccionLibros.add(pLibro);
	}
	
	/*
	 * Este método muestra los libros ordenados alfabéticamente
	 * por título del libro.
	 */
	public void mostrarLibrosOrdenados() {
		System.out.println("\n" + lugar + " " + area + ":");
		coleccionLibros.stream()
			.sorted(Comparator.comparing(Libro::getTitulo))
			.forEach(l -> System.out.println("Nombre del libro: " + l.getTitulo()));;
	}
	
	/*
	 * Muestra los libros cuyo precio es superior al indicado en su parámetro.
	 */
	public void mostrarMasCaros(int pPrecio) {
		coleccionLibros.stream()
			.filter( l -> l.getPrecio() > pPrecio)
			.forEach( l -> System.out.println("Libro: " + l.getTitulo() + " Precio: " + l.getPrecio()));
	}
}
