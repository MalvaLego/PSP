package ejer34_SocketsTCP;

import java.io.*;
import java.net.*;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {


		//Esperando Datagrama
		System.out.println("Servidor esperando...");
		ServerSocket server= new ServerSocket(6000);
				
		Socket socket=server.accept();
		
		ObjectInputStream obj =
				new ObjectInputStream(socket.getInputStream());
		Alumno a_in=(Alumno) obj.readObject();
		
		a_in.addAsignatura();
		
		ObjectOutputStream objOut =
				new ObjectOutputStream(socket.getOutputStream());
		objOut.writeObject(a_in);
		
		
		//Cerrar
		objOut.close();
		obj.close();
		socket.close();
		server.close();
	}

}
