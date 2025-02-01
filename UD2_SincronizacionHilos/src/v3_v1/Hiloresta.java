package v3_v1;

public class Hiloresta extends Thread{
	private Contador c;
	private int restar;
	
	public Hiloresta(String nombre,Contador c,int restar) {
		super(nombre);
		this.c=c;
		this.restar=restar;
	}

	
	public void run() {
		synchronized(c) {
			for (int i=0;i<restar;i++) {
				c.decrementar();
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
