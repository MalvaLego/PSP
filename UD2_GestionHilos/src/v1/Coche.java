package v1;

public class Coche extends Thread{
	private String marca;
	private int num;
	private boolean parar;
	private int total; 
	
	public Coche(String marca,int num) {
		this.marca=marca;
		this.num=num;
		total=0;
		parar=false;
	}

	public void run() {
		
		while (!parar) {
			int distancia= (int)Math.floor(Math.random()*100+0);
			total=total+distancia;
			
			if (total>=500) {
				parar=true;
			}else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Error: "+e.getMessage());
				}
				System.out.println(getMarca()+"("+getNum()+") lleva recorrido "+total+"km!");
			}
		}
		
		System.out.println();
		System.out.println("El "+getMarca()+"("+getNum()+") ha finalizado al recorrer "+total+"km.");
		
		
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getNum() {
		return num;
	}
	
	
}
