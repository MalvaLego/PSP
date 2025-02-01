package v3_v1;

public class Hilosuma extends Thread{
	private Contador c;
	private int sumar;
	
	public Hilosuma(String nombre,Contador c,int sumar) {
		super(nombre);
		this.c=c;
		this.sumar=sumar;
	}

	
	public void run() {
		synchronized(c) {
			for (int i=0;i<sumar;i++) {
				c.incrementar();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("HiloSuma contador vale "+c.getContador());
			}
		}
		
	}

}
