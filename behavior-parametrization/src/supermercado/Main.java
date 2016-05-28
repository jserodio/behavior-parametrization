package supermercado;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
				
		// Instanciar productos
		Producto p1 = new Producto("Sal 100gr",  LocalDate.of(2016, 9, 01), 0.5f, 1);
		Producto p2 = new Producto("Pimienta 25gr",  LocalDate.of(2014, 9, 01), 0.2f, 1);
		Producto p3 = new Producto("Sal 1kg",  LocalDate.of(2014, 9, 01), 2, 1);
		Producto p4 = new Producto("Te limón", LocalDate.of(2017, 9, 01), 3.5f, 1);
		Producto p5 = new Producto("Azucar 1kg", LocalDate.of(2016, 5, 28), 2, 1);
		Producto p6 = new Producto("Azucar 5kg", LocalDate.of(2016, 5, 24), 10, 1);
		Producto p7 = new Producto("Xilitol 1kg", LocalDate.of(2017, 1, 1), 15, 1);
		Producto p8 = new Producto("Xilitol 1kg", LocalDate.of(2017, 1, 1), 15, 1);
		Producto p9 = new Producto("Yogurt nat.x30", LocalDate.of(2016, 1, 1), 15, 2);
		Producto p10 = new Producto("Frutas .x20", LocalDate.of(2016, 1, 1), 15, 2);
		Producto p11 = new Producto("Leche 1,5L", LocalDate.of(2014, 5, 5), 15, 2);
		
		// Añadir productos a la lista del super
		Supermercado.getSupermercado().addProducto(p1);
		Supermercado.getSupermercado().addProducto(p2);
		Supermercado.getSupermercado().addProducto(p3);
		Supermercado.getSupermercado().addProducto(p4);
		Supermercado.getSupermercado().addProducto(p5);
		Supermercado.getSupermercado().addProducto(p6);
		Supermercado.getSupermercado().addProducto(p7);
		Supermercado.getSupermercado().addProducto(p8);
		Supermercado.getSupermercado().addProducto(p9);
		Supermercado.getSupermercado().addProducto(p10);
		Supermercado.getSupermercado().addProducto(p11);
		
		// Imprimir la lista del super
		System.out.println("\nLista productos.");
		Supermercado.getSupermercado().printListaProductos();
		
		// Filtrar los productos por debajo de 2 euros
		System.out.println("\nLista productos por debajo de 2 euros.");
		Supermercado.getSupermercado().filtrarPrecioCollection(2).stream().forEach(item -> System.out.println("Producto " + item));
		
		// Filtrar los productos por debajo de 10 euros
		System.out.println("\nLista productos por debajo de 10 euros.");
		Supermercado.getSupermercado().filtrarPrecioStream(10).stream().forEach(item -> System.out.println("Producto " + item));
		
		// Calcular la media de precio
		System.out.println("\nMedia del precio de todos los productos.");
		System.out.println("Media " + Supermercado.getSupermercado().mediaProductos() + "€");;
		
		// Imprimir la lista del super sin productos repetidos ;)
		System.out.println("\nLista de productos sin repetir.");
		Supermercado.getSupermercado().printListaProductosSinRepetir();
		
		System.out.println("\nLista de los primeros 5 productos.");
		Supermercado.getSupermercado().printListaPrimerosProductos(5);
		
		System.out.println("\nLista de productos ignorando los 5 primeros.");
		Supermercado.getSupermercado().printListaIgnorarPrimerosProductos(5);
		
		System.out.println("\nLongitud de los nombres de los productos.");
		Supermercado.getSupermercado().printListaLongitudPalabras();
		
		System.out.println("\nLista de productos no caducados.");
		Supermercado.getSupermercado().printListProductosNoCaducados();
		
		System.out.println("\nLista filtrada con behaviour parameterisation:");
		System.out.println(" -Productos de la seccion 2.");
		System.out.println(" -Productos que caducan despues de 15/12/2014.");
		System.out.println(" -Productos que cuestan más de 12 €.");
		Supermercado.getSupermercado().filtrarConPredicado(new Predicate<Producto>(){
			@Override
			public boolean test(Producto pProd) {		// especificar las condiciones del test
					return pProd.getSeccion() == 2 &&
							pProd.getFechaCaducidad().isAfter(LocalDate.of(2014, 12, 15)) &&
								pProd.getPrecio() > 12;
			}		
		}).forEach(item -> System.out.println("Producto " + item));
		
		System.out.println("\nLista ordenada con comparators por precio:");
		Supermercado.getSupermercado().ordenarConCondicion(new Comparator<Producto>() {
			public int compare(Producto pP1, Producto pP2){
				return Float.valueOf(pP1.getPrecio()).compareTo(pP2.getPrecio());
			}
		});
	}

}
