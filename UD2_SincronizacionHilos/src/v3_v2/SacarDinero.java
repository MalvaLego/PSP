package v3_v2;

public class SacarDinero extends Thread{
	private Cuenta cuenta;
	private String nombre;
	
	public SacarDinero(String nombre,Cuenta cuenta) {
		this.nombre=nombre;
		this.cuenta=cuenta;
	}
	
	
	public void run() {
		synchronized(cuenta) {
			for (int i=0;i<3;i++) {
				System.out.println(nombre+": SE VA A RETIRAR SALDO. (Actual es: "+cuenta.getSaldo()+" €).");
				cuenta.restarSaldo();
				System.out.println(nombre+" retira 10€. Saldo actualizado es: ("+cuenta.getSaldo()+" €).");
			}
			
		}
		
	}

}
