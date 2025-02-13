package ejer25_InetAddress;

import java.net.*;

public class Principal {
	public static void main(String[] args) {
		InetAddress direc=null;
		
		
		try {
			//localhost
			System.out.println("SALIDA PARA LOCALHOST");
			direc=InetAddress.getByName("localhost");
			mostrarInfo(direc);
			
			//url
			System.out.println("SALIDA PARA URL");
			direc=InetAddress.getByName("www.google.es");
			mostrarInfo(direc);
						
			System.out.println("DIRECCIONES IP DE URL:");
			InetAddress[] direcciones=InetAddress.getAllByName(direc.getHostName());
			for (int i=0;i<direcciones.length;i++) {
				System.out.println(direcciones[i]);
			}
			
		} catch (UnknownHostException e) {		
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void mostrarInfo(InetAddress direc) {
		try {
			System.out.println("\tMetodo localhost :"+direc.getLocalHost());
			System.out.println("\tMetodo hostname :"+direc.getHostName());
			System.out.println("\tMetodo hostaddress :"+direc.getHostAddress());
			System.out.println("\tMetodo toString :"+direc.toString());
			System.out.println("\tMetodo canonical :"+direc.getCanonicalHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
	

}
