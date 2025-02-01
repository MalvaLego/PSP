package v2_v2;

public class Pasajero {
	private int clase;
	private String apellido;
	private String nombre;
	private int edad;
	private String embarque;
	private String vivio;
	
	public Pasajero(int clase, String apellido, String nombre, int edad, String embarque, String vivio) {
		this.clase = clase;
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.embarque = embarque;
		this.vivio = vivio;
	}

	public int getClase() {
		return clase;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getEmbarque() {
		return embarque;
	}

	public String getVivio() {
		return vivio;
	}
	
	
	
	
	

}
