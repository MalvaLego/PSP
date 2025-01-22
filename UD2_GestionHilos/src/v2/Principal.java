package v2;

import java.io.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Pasajero> listaPasajeros= new ArrayList<Pasajero>();
		File file= new File("Titanic.csv");
		Scanner sc=null;
		String cad;
		boolean firstLine=false;
		
		try {
			sc=new Scanner(file);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		while (sc.hasNext()) {
			cad=sc.nextLine();
			if (!firstLine) {
				firstLine=true;
			}else {
				String [] datos=cad.split(",");
				for (int i=0;i<datos.length;i++) {
				}
				for (int i=0;i<datos.length;i++) {
					Pasajero p= new Pasajero(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]),datos[4],datos[5]);
					listaPasajeros.add(p);
				}
				
			}
		}
		
		
		System.out.println("BIENVENIDO AL TITANIC");
		
		Hilo h1=new Hilo("Hilo1",listaPasajeros);
		Hilo h2=new Hilo("Hilo2",listaPasajeros);
		Hilo h3=new Hilo("Hilo3",listaPasajeros);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("FIN DEL PROGRAMA");

	}

}
