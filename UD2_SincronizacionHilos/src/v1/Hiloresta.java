package v1;

public class Hiloresta extends Thread{
	private Contador con;
	private int veces;
	
	public Hiloresta(Contador con, int veces){
		this.con=con;
		this.veces=veces;
	}

	public void run() {
		synchronized(con) {
			for (int i=0;i<veces;i++) {
				con.restar();
				System.out.println("Hiloresta contador vale "+con.contador);
				try {
					Thread.sleep(500);
				}catch(Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
			}
		}
		
	}

}
