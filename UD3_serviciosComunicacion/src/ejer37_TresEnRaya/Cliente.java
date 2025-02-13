package ejer37_TresEnRaya;

import java.io.*;
import java.net.*;
import java.util.*;

import ejer36_SocketsUDP_ByteArray.Pedido;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc= new Scanner(System.in);

		DatagramSocket clienteSocket=null;
		//Datos del servidor al que enviar mensaje
		InetAddress IPServidor= InetAddress.getLocalHost();
		int puerto=12346;
		
		System.out.println("Introduzca su nombre: ");
		String nombre=sc.nextLine();
		
		System.out.println("Introduzca su simbolo: ");
		char simbolo=sc.next().charAt(0);
		
		while (true) {			
			Tirada tirada=new Tirada(nombre,simbolo);
			System.out.println("Introduzca su tirada: ");
			int x=sc.nextInt();
			int y=sc.nextInt();
			tirada.setX(x);
			tirada.setY(y);
			
			//pasa a datagrama
			ByteArrayOutputStream bs= new ByteArrayOutputStream();
			ObjectOutputStream out= new ObjectOutputStream(bs);
			out.writeObject(tirada);
			out.close();
			byte[] enviados= bs.toByteArray();
			
			//Creamos el datagrama que irá al servidor
			DatagramPacket envio= new DatagramPacket(enviados,enviados.length,IPServidor,puerto); 
			
			//Creamos el datagrama que irá al servidor
			clienteSocket= new DatagramSocket(34567);
			clienteSocket.send(envio);
			
			//Recibiendo el datagrama del servidor
			byte[] recibidos=new byte[1024];
			DatagramPacket paqRecibido= new DatagramPacket(recibidos,recibidos.length);
			System.out.println("Esperando datagrama...");
			clienteSocket.receive(paqRecibido);
			
			//Obtener el numero de caracterres
			ByteArrayInputStream bais= new ByteArrayInputStream(recibidos);
			ObjectInputStream in= new ObjectInputStream(bais);
			Tirada tirada2= (Tirada)in.readObject();
			System.out.println("Recibo la tirada.."+tirada2.toString());
			if (tirada2.getNombre().equals("llenado")) {
				System.out.println("EMPATE");
				in.close();
				break;
			}else if (tirada2.getNombre().equals("ganado")) {
				System.out.println("SE TERMINÓ");
				in.close();
				break;
			}
			
			in.close();
			
		}
		
		clienteSocket.close();
		
	}

}
