package v3_v3;

public class Speed extends Thread{
	private Autobus autobus;
	
	
	
	public Speed(String nombre,Autobus autobus) {
		super(nombre);
		this.autobus = autobus;
	}

	
	public void run() {
		synchronized(autobus) {
			while (true) {
				int numRandom = (int) (Math.floor(Math.random()*(10-1+1)+1));
				
				if (Thread.currentThread().getName().equals("Hilo1")) {
					if (autobus.getVelocidad()+numRandom < 80) {
						autobus.volar(numRandom);
						System.out.println("Acelera "+numRandom+". Va a "+autobus.getVelocidad());	
					}else {
						autobus.notify();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							autobus.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (Thread.currentThread().getName().equals("Hilo1")) {
					if (autobus.getVelocidad()+numRandom >= 80) {
						autobus.frenar(numRandom);
						System.out.println("Acelera "+numRandom+". Va a "+autobus.getVelocidad());	
					}else {
						autobus.notify();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							autobus.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			
			
		}
		
		
		
		
	}

}
