package personas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListaPersonas {
	
	List<Persona> listaPersonas;
	
	public ListaPersonas() {
		listaPersonas = new ArrayList<>();
	}
	
	public void anadir(Persona pPersona) {
		this.listaPersonas.add(pPersona);
	}
	
	/**
	 * Obtener la edad media de la lista de personas.
	 * @return	edadMedia	edad media entre todas las personas de la lista
	 */
	public double obtenerEdadMedia() {
		return listaPersonas.stream()
				.mapToDouble(Persona::getEdad)
				.average().getAsDouble();
	}

	/**
	 * Muestra la lista de personas ordenadas por edad
	 */
	public void mostrarPersonas() {
		listaPersonas.stream()
			.sorted(Comparator.comparing(Persona::getEdad))
			.forEach( p -> System.out.println("Nombre: " + p.getNombre() + "\tEdad: " + p.getEdad()));
	}

	/**
	 * Muestra la lista de personas filtrando por un predicado.
	 */
	public void mostrarPersonasFiltradas(Predicate<Persona> pPred) {
		listaPersonas.stream()
			.filter( p -> pPred.test(p))
			.forEach( p -> System.out.println("Nombre: " + p.getNombre() + "\tEdad: " + p.getEdad()));;
	}
}
