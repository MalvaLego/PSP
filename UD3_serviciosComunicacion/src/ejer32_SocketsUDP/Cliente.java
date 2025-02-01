package ejer32_SocketsUDP;

import java.net.*;
import java.util.*;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DatagramSocket clienteSocket=null;
		DatagramPacket recibo=null;
		int puerto=123456;
		InetAddress IPServidor=null;
		
		//Datos del servidor al que enviar mensaje
		
		try {
			IPServidor = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		//Introducir datos por teclado
		System.out.println("INtroduce mensaje: ");
		String cadena=sc.nextLine();
		
		byte[] enviados= new byte[1024];
		enviados=cadena.getBytes();
		
		//Creamos el datagrama que irá al servidor 
		DatagramPacket envio=new DatagramPacket(enviados,enviados.length,IPServidor,puerto);
		
		try {
			//Realizamos el envio
			clienteSocket= new DatagramSocket(34567);
			clienteSocket.send(envio);	
		}catch(Exception e) {
			
		}
		
		//Recibiendo datagrama del servidor
		byte[] recibidos= new byte[2];
		
		try {
			recibo= new DatagramPacket(recibidos,recibidos.length);
			System.out.println("Esperando datagrama...");
			clienteSocket.receive(recibo);	
		}catch(Exception e) {
			
		}
		
		//Obtener el numero de caracteres
		byte[] vector_bytes=recibo.getData();
		int numero=vector_bytes[0];
		System.out.println("Recibo numero de caracteres 'a' que son: "+numero);
		
		clienteSocket.close();
		
		
	}

}
