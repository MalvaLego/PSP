package v1_v3;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Casilla> listaCasillas= new ArrayList<Casilla>();
		
		System.out.println("Introduzca limite inferior: ");
		int inferior=sc.nextInt();
		System.out.println("Introduzca limite superior: ");
		int superior=sc.nextInt();
		
		for (int i=0;i<9;i++) {
			Casilla c=new Casilla();
			listaCasillas.add(c);
		}
		
		Hilo1 h1= new Hilo1("Hilo1",inferior,superior,listaCasillas);
		Hilo2 h2= new Hilo2("Hilo2",inferior,superior,listaCasillas);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		}catch(Exception e) {
			System.out.println("Error join ");
		}
		
		
	}

}
