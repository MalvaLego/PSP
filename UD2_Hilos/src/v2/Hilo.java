package v2;

import java.io.*;
import java.util.*;

public class Hilo extends Thread{
	FileWriter primeros;
	FileWriter segundos;
	FileWriter terceros;
	
	
	public Hilo(FileWriter primeros, FileWriter segundos,FileWriter terceros) {
		this.primeros=primeros;
		this.segundos=segundos;
		this.terceros=terceros;
	}
	
	public void run() {
		File menu= new File("menu.txt"); 
		Scanner sc=null;
		String cad;
		boolean prim_primeros = true;
		boolean prim_segundos = true;
		boolean prim_postres = true;
		
		try {
			sc=new Scanner(menu);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		while (sc.hasNext()) {
			cad=sc.nextLine();
			String[] separacion=cad.split("-");
		
			//Primeros
			if ((Thread.currentThread().getName().equals("Hilo 1")) && (separacion[0].equals("1"))) {			
				//if (prim_primeros) {
					//prim_primeros = false;
				//}else {
					try {
						primeros.write(separacion[1]+"\n");
						System.out.println("El hilo 1 escribe..."+separacion[1]);
					} catch (IOException e) {
						System.out.println("Error: "+e.getMessage());
					}
				//}	
			}
			//Segundos
			if ((Thread.currentThread().getName().equals("Hilo 2")) && (separacion[0].equals("2"))) {			
				if (prim_segundos) {
					prim_segundos = false;
				}else {
					try {
						segundos.write(separacion[1]+"\n");
						System.out.println("El hilo 2 escribe..."+separacion[1]);
					} catch (IOException e) {
						System.out.println("Error: "+e.getMessage());
					}
				}
			}
			//Postres
			if ((Thread.currentThread().getName().equals("Hilo 3")) && (separacion[0].equals("3"))) {			
				if (prim_postres) {
					prim_postres = false;
				}else {
					try {
						terceros.write(separacion[1]+"\n");
						System.out.println("El hilo 3 escribe..."+separacion[1]);
					} catch (IOException e) {
						System.out.println("Error: "+e.getMessage());
					}
				}
			}
		}
		
		try {
			primeros.close();
			segundos.close();
			terceros.close();
			System.out.println("entraste");
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}	
			
		
		
		
	}
	
	

}
