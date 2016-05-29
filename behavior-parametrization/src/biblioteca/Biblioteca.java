package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	@SuppressWarnings("unused")
	private String nombre;
	private List<Estanteria> coleccionEstanterias;
	
	public Biblioteca (String pNombre) {
		this.nombre = pNombre;
		coleccionEstanterias = new ArrayList<>();
	}
	
	public void addEstanteria(Estanteria pEstanteria) {
		coleccionEstanterias.add(pEstanteria);
	}
	
	/*
	 * Este método muestra los libros de cada estantería ordenados alfabéticamente
	 * por título del libro. Se mostrarán primero los primera estantería, luego los
	 * de la siguiente y así hasta mostrarlas todas.
	 */
	public void mostrarLibrosEstanterias() {
		coleccionEstanterias.stream()
			.forEach(Estanteria::mostrarLibrosOrdenados);
	}
	
	/*
	 * Muestra los libros cuyo precio es superior al indicado en su parámetro.
	 */
	public void mostrarMasCaros(int pPrecio) {
		coleccionEstanterias.stream()
			.forEach( e -> e.mostrarMasCaros(pPrecio));
	}
}
