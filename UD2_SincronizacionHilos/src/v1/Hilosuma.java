package v1;

public class Hilosuma extends Thread{
	private Contador con;
	private int sumar;
	
	public Hilosuma(Contador con, int sumar){
		this.con=con;
		this.sumar=sumar;
	}

	public void run() {
		synchronized(con) {
			for (int i=0;i<sumar;i++) {
				con.sumar();
				System.out.println("Hilosuma contador vale "+con.contador);
				try {
					Thread.sleep(500);
				}catch(Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
			}
		}
		
	}
	
}
