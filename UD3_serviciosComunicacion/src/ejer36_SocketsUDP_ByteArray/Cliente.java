package ejer36_SocketsUDP_ByteArray;

import java.io.*;
import java.net.*;
import java.util.*;



public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Scanner sc= new Scanner(System.in);
		
		//Datos del servidor al que enviar mensaje
		InetAddress IPServidor= InetAddress.getLocalHost();
		int puerto=12346;
		
		//Creación de un objeto
		System.out.println("Bienvenido al Burger King Xpress! HAga su pedido en 3 paso:");
		System.out.println("1-Introduzca el nombre de su Burger:");
		String burger= sc.nextLine();
		System.out.println("2-Introduzca el nombre del acompañamiento:");
		String company= sc.nextLine();
		System.out.println("3-Introduzca el nombre de su refresco:");
		String refresco= sc.nextLine();
		
		Pedido pedido= new Pedido(burger,company,refresco);
		
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		ObjectOutputStream out= new ObjectOutputStream(bs);
		out.writeObject(pedido);
		out.close();
		byte[] enviados= bs.toByteArray();
		
		//Creamos el datagrama que irá al servidor
		DatagramPacket envio= new DatagramPacket(enviados,enviados.length,IPServidor,puerto); 
		
		//Creamos el datagrama que irá al servidor
		DatagramSocket clienteSocket= new DatagramSocket(34567);
		clienteSocket.send(envio);
		
		//Recibiendo el datagrama del servidor
		byte[] recibidos=new byte[1024];
		DatagramPacket paqRecibido= new DatagramPacket(recibidos,recibidos.length);
		System.out.println("Esperando datagrama...");
		clienteSocket.receive(paqRecibido);
		
		//Obtener el numero de caracterres
		ByteArrayInputStream bais= new ByteArrayInputStream(recibidos);
		ObjectInputStream in= new ObjectInputStream(bais);
		Pedido pedido2= (Pedido)in.readObject();
		System.out.println("Recibo el pedido.."+pedido2.toString());
		in.close();
		clienteSocket.close();
	}

}
