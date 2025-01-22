package Examen;

public class Hilo extends Thread{
	private Juego o;
	private String operacion;
	
	public Hilo(Juego o, String operacion) {
		this.o = o;
		this.operacion = operacion;
	}


	public void run() {
		synchronized(o) {
			for (int i=1;i<5+1;i++) {
	
				//Primer hilo para la canción
				if (operacion.equals("ninya")) {
					o.ninya(i);
						
					o.notify();	
					try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					
				//Segundo hilo para la eliminación
				if (operacion.equals("eliminar")) {
					o.eliminar();
						
					o.notify();
					try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			o.notifyAll();
		}
	}
	

}
