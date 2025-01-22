package v1;

public class Contador {
	int contador;
	
	public Contador() {
		contador=100;
	}
	
	public void sumar() {
		contador=contador+1;
	}
	
	public void restar() {
		contador=contador-1;
	}

	public int getContador() {
		return contador;
	}
	
	
}
