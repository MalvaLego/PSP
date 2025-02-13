package ejer28_SocketsTCP;

import java.net.ServerSocket;
import java.io.IOException;
import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto=6000;
		ServerSocket servidor= new ServerSocket(puerto);
		
		Socket clienteConectado=null;
		System.out.println("Esperando cliente...");
		clienteConectado=servidor.accept();

		//Creo flujo de entrada del cliente
		InputStream entrada=null;
		entrada=clienteConectado.getInputStream();
		DataInputStream flujoEntrada= new DataInputStream(entrada);
		
		//El cliente me envía un mensaje
		System.out.println("Recibiendo del cliente: "+flujoEntrada.readUTF());
		
		//Creo flujo de salida al cliente
		OutputStream salida=null;
		salida=clienteConectado.getOutputStream();
		DataOutputStream flujoSalida= new DataOutputStream(salida);
		
		//envío saludo al cliente
		flujoSalida.writeUTF("Saludos al cliente de parte del servidor");
		
		//Cerrar
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
		
	}

}
