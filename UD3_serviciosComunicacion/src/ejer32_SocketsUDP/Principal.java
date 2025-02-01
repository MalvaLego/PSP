package ejer32_SocketsUDP;

import java.net.*;

public class Principal {

	public static void main(String[] args) {
		DatagramSocket socket=null;
		DatagramPacket envio=null;
		
		//Esperando Datagrama
		System.out.println("Servidor esperando datagrama...");
		DatagramPacket recibo;
		
		byte[] buffer= new byte[1024];
		recibo= new DatagramPacket(buffer,buffer.length); 
		
		try {
			//Asocio el socket al puerto 12345 y me quedo esperando
			socket= new DatagramSocket(12345);
			socket.receive(recibo);	
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		String mensaje= new String(recibo.getData()).trim();
		System.out.println("Servidor recibe: "+mensaje);
		
		//Contar el numero de letras a
		int contador=0;
		for (int i=0;i<mensaje.length();i++) {
			if (mensaje.charAt(i)=='a') {
				contador++;
			}
		}
		
		//Direccion origen del mensaje
		InetAddress IPOrigen=recibo.getAddress();
		int puerto=recibo.getPort();
		
		//Enviando datagrama al cliente
		System.out.println("Enviando numero de aparaciones de la letra 'a':"+contador);
		byte b=(byte)contador;
		byte[] enviados= new byte[1024];
		enviados[0]=b;
		
		try {
			envio= new DatagramPacket(enviados,enviados.length,IPOrigen,puerto);
			socket.send(envio);
		}catch(Exception e) {
			
		}
		
		//Cerrar socket
		System.out.println("Cerrando conexión...");
		socket.close();
		
		
	}

}
