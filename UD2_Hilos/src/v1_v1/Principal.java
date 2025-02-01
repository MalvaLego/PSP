package v1_v1;

public class Principal {

	public static void main(String[] args) {
		Hilo h1= new Hilo("Hilo1");
		Hilo h2= new Hilo("Hilo2");
		Hilo h3= new Hilo("Hilo3");
		
		h1.start();
		h2.start();
		h3.start();
		
		

	}

}
