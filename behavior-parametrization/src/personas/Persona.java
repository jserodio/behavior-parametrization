package personas;

public class Persona {
	
	private String nombre;
	private int edad;
	
	public Persona (String pNombre, int pEdad) {
		this.nombre = pNombre;
		this.edad = pEdad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
}
