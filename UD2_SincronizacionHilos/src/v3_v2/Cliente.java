package v3_v2;

public class Cliente {
	private String nombre;
	private int edad;
	private String español;
	

	public Cliente(String nombre, int edad, String español) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.español = español;
	}


	public String getNombre() {
		return nombre;
	}


	public int getEdad() {
		return edad;
	}


	public String getEspañol() {
		return español;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setEspañol(String español) {
		this.español = español;
	}
	
	
	

}
