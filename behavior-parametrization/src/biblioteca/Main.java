package biblioteca;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca("Biblioteca municipal de Bilbao");
		
		Estanteria e1A = new Estanteria("Piso 1", "A");
		Estanteria e1B = new Estanteria("Piso 1", "B");
		Estanteria e1C = new Estanteria("Piso 1", "C");
		
		Libro lib1 = new Libro("Emocionario. Di lo que sientes", "Cristina Ñuñez", 17);
		Libro lib2 = new Libro("El monstruo de colores", "Anna LLenas Serra", 15);
		Libro lib3 = new Libro("World of Warcraft Crónicas 1", "Vv.Aa.", 23);
		Libro lib4 = new Libro("La magia del orden", "Marie Kondo", 14);
		Libro lib5 = new Libro("Te quiero (casi siempre)", "Anna LLenas Serra", 13);
		Libro lib6 = new Libro("SPQR", "Mary Beard", 26);
		Libro lib7 = new Libro("Libros para colorear. Adultos 7.", "Elisabeth James", 5);
		Libro lib8 = new Libro("Ser feliz en Alaska", "Rafael Santandreu", 16);
		Libro lib9 = new Libro("El principito", "Antoine De Saint Exupery", 5);
		Libro lib10 = new Libro("A qué sabe la Luna?", "Michael Greniec", 14);
		Libro lib11 = new Libro("El secreto del bosque", "Alexandra Dannenmann", 4);
		Libro lib12 = new Libro("Cuando abras el paracaidas", "Defreds (José A. Gómez Iglesias)", 13);
		
		b.addEstanteria(e1A);
		b.addEstanteria(e1B);
		b.addEstanteria(e1C);
		
		e1A.addLibro(lib1);
		e1A.addLibro(lib2);
		e1A.addLibro(lib3);
		e1A.addLibro(lib4);
		
		e1B.addLibro(lib5);
		e1B.addLibro(lib6);
		e1B.addLibro(lib7);
		e1B.addLibro(lib8);
		
		e1C.addLibro(lib9);
		e1C.addLibro(lib10);
		e1C.addLibro(lib11);
		e1C.addLibro(lib12);
		
		System.out.println("\nMostrar los libros de cada estantería ordenados alfabéticamente por título del libro.");
		b.mostrarLibrosEstanterias();
		
		System.out.println("\nMostrar libros cuyo precio sea superior a 10 euros");
		b.mostrarMasCaros(10);
		
		System.out.println("\nMostrar libros cuyo precio sea superior a 15 euros");
		b.mostrarMasCaros(15);
		
		System.out.println("\nMostrar libros cuyo precio sea superior a 20 euros");
		b.mostrarMasCaros(20);
	}

}
