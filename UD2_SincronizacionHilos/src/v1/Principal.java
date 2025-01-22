package v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Tenemos algo");
		System.out.println("Introduzca cantidad a sumar: ");
		int sumar=sc.nextInt();
		System.out.println("Introduzca cantidad a restar: ");
		int restar=sc.nextInt();
		
		Contador con=new Contador();
		Hilosuma hs= new Hilosuma(con,sumar);
		Hiloresta hr= new Hiloresta(con,restar);
		
		hs.start();
		hr.start();
		
		try {
			hs.join();
			hr.join();
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}

}
