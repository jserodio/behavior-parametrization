package personas;

import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

		Persona p1 = new Persona("Jose", 25);
		Persona p2 = new Persona("Laura", 23);
		Persona p3 = new Persona("Mikel", 26);
		Persona p4 = new Persona("Alba", 22);
		Persona p5 = new Persona("Gerard", 23);
		Persona p6 = new Persona("Albert", 23);
		Persona p7 = new Persona("Nestor", 23);
		Persona p8 = new Persona("Guille", 24);
		
		ListaPersonas lista = new ListaPersonas();
		
		lista.anadir(p1);
		lista.anadir(p2);
		lista.anadir(p3);
		lista.anadir(p4);
		lista.anadir(p5);
		lista.anadir(p6);
		lista.anadir(p7);
		lista.anadir(p8);				
		
		/**
		 * Muestra la lista de personas ordenadas por edad
		 */
		System.out.println("\nLista de personas ordenadas por edad:");
		lista.mostrarPersonas();
		
		/**
		 * Obtener la edad media de la lista de personas.
		 * @return	edadMedia	edad media entre todas las personas de la lista
		 */
		double edadMedia = lista.obtenerEdadMedia();
		System.out.println("\nLa edad media es: " + edadMedia);
		
		/**
		 * Muestra la lista de personas filtrando por un predicado.
		 */
		System.out.println("\nLista de personas mayores que la media:");
		lista.mostrarPersonasFiltradas(new Predicate<Persona>() {
			@Override
			public boolean test(Persona pPersona) {
				return pPersona.getEdad()>edadMedia;
			}
		});
	}

}
