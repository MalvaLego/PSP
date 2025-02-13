package ejer28_SocketsTCP;

import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		String Host="localhost";
		int puerto=6000;
		Socket cliente=null;
		DataInputStream flujoEntrada=null;
		DataOutputStream flujoSalida=null;
		
		System.out.println("Progrma cliente iniciado");		
		try {
			cliente=new Socket(Host,puerto);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		try {
			//creo flujo de salida al servidor
			flujoSalida= new DataOutputStream(cliente.getOutputStream());
			
			//Envío un saludo al servidor		
			flujoSalida.writeUTF("Saludos al servidor de parte del cliente");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try {
			//Creo flujo de entrada al servidor
			flujoEntrada= new DataInputStream(cliente.getInputStream());
			
			//El servidor me envía un mensaje
			System.out.println("Recibiendo del servidro: "+flujoEntrada.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
				
		//Cerrar
		try {			
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
