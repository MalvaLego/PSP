package v3_v3;

public class Autobus {
	private String matricula;
	private int velocidad=50;
	

	public Autobus(String matricula, int velocidad) {
		super();
		this.matricula = matricula;
		this.velocidad = velocidad;
	}

	public void volar(int num) {
		velocidad=velocidad+num;
	}
	
	public void frenar(int num) {
		velocidad=velocidad-num;
	}
	
	
	public String getMatricula() {
		return matricula;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	

}
