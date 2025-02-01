package v2_v1;

public class Coche extends Thread{
	private String marca;
	private int num;
	private int distancia;
	
	public Coche(String marca,int num) {
		this.marca=marca;
		this.num=num;
	}
	
	
	public void run() {
		while (true) {
			int numRandom = (int) (Math.floor(Math.random()*(100-0+1)+0));
			System.out.println(" Entra: "+numRandom);
			try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			System.out.println(marca+num+" lleva recorrido "+distancia+"km!");
			distancia=distancia+numRandom;
			
			if (distancia>=500) {
				System.out.println(marca+num+" ha terminado!");
				break;
			}
		}
		
		
	}
	
	

}
