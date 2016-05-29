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
	 * Este m�todo muestra los libros de cada estanter�a ordenados alfab�ticamente
	 * por t�tulo del libro. Se mostrar�n primero los primera estanter�a, luego los
	 * de la siguiente y as� hasta mostrarlas todas.
	 */
	public void mostrarLibrosEstanterias() {
		coleccionEstanterias.stream()
			.forEach(Estanteria::mostrarLibrosOrdenados);
	}
	
	/*
	 * Muestra los libros cuyo precio es superior al indicado en su par�metro.
	 */
	public void mostrarMasCaros(int pPrecio) {
		coleccionEstanterias.stream()
			.forEach( e -> e.mostrarMasCaros(pPrecio));
	}
}
