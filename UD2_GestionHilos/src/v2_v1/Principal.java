package v2_v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Coche> listaCoches= new ArrayList<Coche>();
		
		System.out.println("Introduzca numero de coches a competir: ");
		int numCoches=sc.nextInt();
		
		sc.nextLine();
		int num=1;
		for (int i=0;i<numCoches;i++) {
			System.out.println("Introduzca marca del coche "+i+": ");
			
			String marca=sc.nextLine();
			
			Coche c=new Coche(marca,num);
			listaCoches.add(c);
			System.out.println("Coche creado: ");
			num++;
		}
		
		System.out.println("Empieza ");
		
		for (Coche c: listaCoches) {
			c.start();
		}
		
		

	}

}
