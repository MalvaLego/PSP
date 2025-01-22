package v1;

public class Hilo extends Thread {
	private String nombre;
	
	public Hilo(String nombre) {
		this.nombre=nombre;
	}	

	
	public void run() {
		for (int i=0;i<4;i++) {
			System.out.println(nombre+" con valor = "+i);
		}
	}
		
		
	

}
