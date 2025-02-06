package ejer36_SocketsUDP_ByteArray;

import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] burgers= {"Cheeseburger","Whopper","Long Chicken"};
		String[] company= {"Patatas clasicas","Patatas supreme","Aros de cebolla"};
		String[] refresco= {"Cocacola","Nestea","Monster"};
		String burger_def="";
		String company_def="";
		String refresco_def="";
		boolean burgerok=false;
		boolean companyok=false;
		boolean refrescook=false;

		//Esperando Datagrama
		System.out.println("Servidor esperando datagrama...");
		
		byte[] recibidos= new byte[1024];
		DatagramPacket paqrecibido= new DatagramPacket(recibidos,recibidos.length);
		
		//Asocio el socket al puerto 12345 y me quedo esperando
		DatagramSocket socket=new DatagramSocket(12346);
		socket.receive(paqrecibido);
		ByteArrayInputStream bais= new ByteArrayInputStream(recibidos); 
		ObjectInputStream in= new ObjectInputStream(bais);
		Pedido pedido= (Pedido)in.readObject();
		
		//validar burger
		for (int i=0;i<burgers.length;i++) {
			if (pedido.getBurger().equalsIgnoreCase(burgers[i])) {
				burgerok=true;
				burger_def=pedido.getBurger();
			}			
		}
		if (burgerok==false) {
			System.out.println("ERROR! La hamburgesa "+pedido.getBurger()+" no existe!");
		}
		
		//validar company
		for (int i=0;i<company.length;i++) {
			if (pedido.getCompany().equalsIgnoreCase(company[i])) {
				companyok=true;
				company_def=pedido.getBurger();
			}			
		}
		if (companyok==false) {
			System.out.println("ERROR! La hamburgesa "+pedido.getCompany()+" no existe!");
		}
		
		//validar refresco
		for (int i=0;i<refresco.length;i++) {
			if (pedido.getRefresco().equalsIgnoreCase(refresco[i])) {
				refrescook=true;
				refresco_def=pedido.getBurger();
			}			
		}
		if (refrescook==false) {
			System.out.println("ERROR! La hamburgesa "+pedido.getRefresco()+" no existe!");
		}
		
		//Direccion origen del mensaje
		InetAddress IPOrigen= paqrecibido.getAddress();
		int puerto= paqrecibido.getPort();
		
		//Enviando datagram al cliente
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		ObjectOutputStream out= new ObjectOutputStream(bs);
		Pedido pedido_out= new Pedido(burger_def,company_def,refresco_def);
		out.writeObject(pedido_out);
		out.close();
		byte[] enviados=bs.toByteArray();
		
		DatagramPacket envio= new DatagramPacket(enviados,enviados.length,IPOrigen,puerto);
		socket.send(envio);
		
		//Cerrar socket
		System.out.println("Cerrando conexión...");
		socket.close();
	}

}

