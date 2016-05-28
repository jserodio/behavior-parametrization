package supermercado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Supermercado {
	private List<Producto> listaProducto = new ArrayList<>();
	private static Supermercado mSupermercado;
	
	private Supermercado() {}
	
	public static Supermercado getSupermercado() {
		if (mSupermercado == null) {
			mSupermercado = new Supermercado();
		}
		return mSupermercado;
	}
	
	public void addProducto(Producto pProducto) {
		listaProducto.add(pProducto);
	}
	
	/**
	 * Devuelve una lista con los nombre de los precios más bajos
	 * dado un precio límite.
	 * 
	 * Método hecho en Java 7.
	 *
	 * @param  pEuros	Euros por los que filtrara cada producto.
	 * @return 			Lista con los nombres de precios por debajo
	 * 					del límite establecido.
	 * 
	 */
	public List<String> filtrarPrecioCollection(int pEuros) {	
		List<Producto> precioBajo = new ArrayList<>();				// Filtrar los elementos y usar add para ir creando el resultado	
		for (Producto p: this.listaProducto) {
			if(p.getPrecio() < pEuros) {
				precioBajo.add(p);
			}
		}
		Collections.sort(precioBajo, new Comparator<Producto>() {	// Ordenar los productos usando una clase anónima
			public int compare(Producto pP1, Producto pP2) {
				return Float.valueOf(pP1.getPrecio()).compareTo(pP2.getPrecio());			
			}
		});
		List<String> nombrePrecioBajo = new ArrayList<>();			// Procesar la lista ordenada para seleccionar los nombres de los platos
		for (Producto p: precioBajo) {
			nombrePrecioBajo.add(p.getNombre());
		}
		return nombrePrecioBajo;
	}
	
	/**
	 * Devuelve una lista con los nombre de los precios más bajos
	 * dado un precio límite.
	 * 
	 * Método hecho en Java 8.
	 *
	 * @param  pEuros	Euros por los que filtrara cada producto.
	 * @return 			Lista con los nombres de precios por debajo
	 * 					del límite establecido.
	 * 
	 */
	public List<String> filtrarPrecioStream(int pEuros) {
		return listaProducto.stream()								// Para aprovechar architectura multicore, utilizar parallelStream() (en vez de stream)
				.filter( p -> p.getPrecio() < pEuros)				// Filtrar los productos de precio inferior a 6 euros
				.sorted(Comparator.comparing(Producto::getPrecio))	// Ordenarlos por precio
				.map(Producto::getNombre)							// Extraer los nombres de los productos filtrados
				.collect(Collectors.toList());						// Almacenar los nombres en una lista
	}

	/**
	 * Mostrar todos los elementos de una coleccion.
	 */
	public void printListaProductos() {
		listaProducto.stream()
			.forEach(p -> System.out.println("Producto " +p.getNombre() 
				+ '\t' + "Precio " + p.getPrecio() + "€"
				+ '\t' + "Caducidad " + p.getFechaCaducidad()));
	}
	
	/**
	 * Devuelve la media del precio de todos los productos.
	 * @return 
	 * 
	 */
	public float mediaProductos() {
		return (float) listaProducto.stream()
				.mapToDouble(Producto::getPrecio)	// seleccionar el atributo
				.average().getAsDouble();			// aplicar media
	}
	
	/**
	 * Mostrar todos los elementos de una coleccion, sin elementos repetidos.
	 */
	public void printListaProductosSinRepetir() {
		listaProducto.stream()
			.distinct()								// ignorar repetidos
			.forEach(p -> System.out.println("Producto " +p.getNombre() 
				+ '\t' + "Precio " + p.getPrecio() + "€"
				+ '\t' + "Caducidad " + p.getFechaCaducidad()));
	}

	/**
	 * Mostrar los n primeros elementos de una coleccion, sin elementos repetidos.
	 */
	public void printListaPrimerosProductos(int number) {
		listaProducto.stream()
		.distinct()									// ignorar repetidos
		.limit(number)								// limitar el numero de elementos
		.forEach(p -> System.out.println("Producto " +p.getNombre() 
			+ '\t' + "Precio " + p.getPrecio() + "€"
			+ '\t' + "Caducidad " + p.getFechaCaducidad()));
	}

	/**
	 * Ignorar los primeros n elementos de la lista y mostrar la lista, sin elementos repetidos.
	 */
	public void printListaIgnorarPrimerosProductos(int number) {
		listaProducto.stream()
		.distinct()									// ignorar repetidos
		.skip(number)								// saltarse los elementos
		.forEach(p -> System.out.println("Producto " +p.getNombre() 
			+ '\t' + "Precio " + p.getPrecio() + "€"
			+ '\t' + "Caducidad " + p.getFechaCaducidad()));
	}

	/**
	 * Imprime una lista de numeros. Cada numero representa la longitud de caracteres
	 * del nombre de cada producto en la lista.
	 */
	public void printListaLongitudPalabras() {
		listaProducto.stream()
		.distinct()									// ignorar repetidos
		.map(Producto::getNombre)
		.mapToInt(String::length)
		.forEach(System.out::println);
	}

	/**
	 * Imprime la lista de productos no caducados.
	 */
	public void printListProductosNoCaducados() {
		listaProducto.stream()
			.filter(p -> p.getFechaCaducidad().isAfter(LocalDate.now()))
			.forEach(p -> System.out.println("Producto " + p.getNombre() + "\tCaducidad " + p.getFechaCaducidad()));
	}
	
	
	/**
	 * Filtrar con predicado
	 */
	public List<String> filtrarConPredicado(Predicate<Producto> pPred) {
		List<String> seleccionados = new ArrayList<>();
		
		listaProducto.stream()
			.filter( p -> pPred.test(p))
			.forEach( p -> seleccionados.add(p.getNombre()) );
		
		return seleccionados;
	}
	
	/*
	 * Ordenar con comparator
	 * 
	 */
	public void ordenarConCondicion(Comparator<Producto> pComp) {
		List<Producto> lista = listaProducto;
		lista.sort(pComp);
		lista.stream().forEach( p -> System.out.println("Producto " + p.getNombre() + "\tPrecio " + p.getPrecio()) );
	}
	
}
