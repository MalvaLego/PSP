package v1_v2;

import java.io.*;
import java.util.*;

public class Hilo extends Thread{
	private FileWriter fw1;
	private FileWriter fw2;
	private FileWriter fw3;
	
	
	public Hilo(FileWriter fw1,FileWriter fw2,FileWriter fw3) {
		this.fw1=fw1;
		this.fw2=fw2;
		this.fw3=fw3;
	}
	
	public void run() {
		File menu=new File("menu.txt");
		Scanner sc=null;
		boolean cabPrimeros=true;
		boolean cabSegundos=true;
		boolean cabTerceros=true;
		String cad;
		
		try {
			sc = new Scanner(menu);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			while(sc.hasNext()) {
				cad=sc.nextLine();
				String[] datos=cad.split("-");
				if (Thread.currentThread().getName().equals("Hilo1")) {					
					if (cabPrimeros) {
						cabPrimeros=false;
					}else if (datos[0].equals("1")) {
						fw1.write(datos[1]+"\n");
						System.out.println("Entra en 1");
					}
				}
				if (Thread.currentThread().getName().equals("Hilo2")) {
					if (cabSegundos) {
						cabSegundos=false;
					}else if (datos[0].equals("2")) {
						fw2.write(datos[1]+"\n");
						System.out.println("Entra en 2");
					}
				}
				if (Thread.currentThread().getName().equals("Hilo3")) {
					if (cabTerceros) {
						cabTerceros=false;
					}else if (datos[0].equals("3")) {
						fw3.write(datos[1]+"\n");
						System.out.println("Entra en 3");
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Error ");
		}
		
		try {
			fw1.close();
			fw2.close();
			fw3.close();
		}catch(Exception e) {
			System.out.println("Cerrado");
		}
		
	}

}
