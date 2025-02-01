package v3_v3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Autobus a= new Autobus("AAA",50);
		
		Speed h1= new Speed("Hilo1",a);
		Speed h2= new Speed("Hilo1",a);
		
		h1.start();
		h2.start();
		
		
	}

}
