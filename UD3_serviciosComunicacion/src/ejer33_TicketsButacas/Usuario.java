package ejer33_TicketsButacas;

import java.net.*;
import java.util.*;

public class Usuario {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DatagramSocket clienteSocket=null;
		DatagramPacket recibo=null;
		int puerto=12345;
		InetAddress IPServidor=null;
		int opcion=0;
		
		try {
			//Datos del servidor al que enviar mensaje
			IPServidor = InetAddress.getLocalHost();
			
			clienteSocket= new DatagramSocket(34567);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Introducir datos por teclado
		while (opcion!=4) {
			System.out.println("==TICKETSERVER== ");
			System.out.println("Introduce opcion: ");
			opcion=sc.nextInt();
			
			if (opcion==1) {
				enviarAccion(1,"mostrar",clienteSocket);
			}
			if (opcion==2) {
				sc.nextLine();
				System.out.println("Introduzca nombre para la reserva: ");
				String nombre=sc.nextLine();
				enviarAccion(2,nombre,clienteSocket);
			}
			if (opcion==3) {
				sc.nextLine();
				System.out.println("Introduzca nombre para anular reserva: ");
				String nombre=sc.nextLine();
				enviarAccion(3,nombre,clienteSocket);
			}
			if (opcion==4) {
				enviarAccion(4,"salir",clienteSocket);
			}
		}
		

		clienteSocket.close();
		
		
	}

	private static void enviarAccion(int num,String nombre,DatagramSocket clienteSocket) {
		String cadena=num+";"+nombre;
		
		//Convertir cadena en bytes
		byte[] enviados= new byte[1024];
		enviados=cadena.getBytes();
		
		try {
			//Datos del servidor al que enviar mensaje y creamos el datagrama que irá al servidor 
			int puerto=12345;
			InetAddress IPServidor= InetAddress.getLocalHost();
			//Creamos el datagrama que irá al servidor
			DatagramPacket envio=new DatagramPacket(enviados,enviados.length,IPServidor,puerto);
			//Realizamos el envio
			clienteSocket.send(envio);	
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());	
		}
		 
	}

}
