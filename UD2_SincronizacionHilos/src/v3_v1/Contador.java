package v3_v1;

public class Contador {
	private int contador;
	
	
	public Contador(int contador) {
		this.contador=contador;
	}
	
	
	public void incrementar() {
		contador=contador+1;
	}
	
	public void decrementar() {
		contador=contador-1;
	}
	
	public int getContador(){
		return contador;
	}
	

}
