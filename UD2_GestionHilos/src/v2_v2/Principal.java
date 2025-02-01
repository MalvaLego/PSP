package v2_v2;

import java.io.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Bienvenido al Titanic!");
		
		ArrayList<Pasajero> lista= new ArrayList<Pasajero>(); 
		File file= new File("Titanic.csv");
		Scanner sc=null;
		String cad;
		boolean firstLine=true;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			while(sc.hasNext()) {
				if (firstLine) {
					firstLine=false;
					sc.nextLine();
				}else {
					cad=sc.nextLine();
					String[] datos=cad.split(",");
					
					Pasajero p=new Pasajero(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]),datos[4],datos[5]);
					lista.add(p);
				}
			}
			
		}catch(Exception e) {
			
		}
			
		Hilo h1= new Hilo("Hilo1",lista);
		Hilo h2= new Hilo("Hilo2",lista);
		Hilo h3= new Hilo("Hilo3",lista);
		
		h1.setPriority(Thread.MAX_PRIORITY);
		h2.setPriority(Thread.NORM_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		
		
		
		try {
			h1.join();
			h2.join();
			h3.join();
		}catch(Exception e) {
			
		}
		
		
	}

}
