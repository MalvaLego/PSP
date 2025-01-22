package v1;

import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Coche> listaCoches= new ArrayList<Coche>();
		
		System.out.println("Escribe numero de coches que competirán: ");
		int numCoches=sc.nextInt();
		
		sc.nextLine();
		for (int i=1;i<numCoches+1;i++) {
			System.out.println("Escriba marca del coche numero "+i+":");
			String marca=sc.nextLine();
			Coche c=new Coche(marca,i);
			listaCoches.add(c);
		}
		
		System.out.println("Que empiece la carrera!");
		for (Coche c : listaCoches) {
			c.start();
		}
		
		
	}

}
