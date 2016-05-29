package biblioteca;

public class Libro {
	
	private String titulo;
	private String autor;
	private int precio;
	
	public Libro (String pTitulo, String pAutor, int pPrecio) {
		this.titulo = pTitulo;
		this.autor = pAutor;
		this.precio = pPrecio;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
}
