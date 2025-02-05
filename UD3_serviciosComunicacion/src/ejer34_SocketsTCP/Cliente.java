package ejer34_SocketsTCP;

import java.net.ServerSocket;
import java.util.*;
import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Socket socket=null;
		String host="localhost";
		int puerto=6000;
		
		try {
			socket= new Socket(host,puerto);
			
			System.out.println("Introduzca nombre:");
			String nombre=sc.nextLine();
			
			System.out.println("Introduzca edad:");
			int edad=sc.nextInt();
			
			sc.nextLine();
			System.out.println("Introduzca si es repartidor(s/n):");
			String esRepartidor=sc.nextLine();

			Alumno a_out= new Alumno(nombre,edad,esRepartidor);
			
			ObjectOutputStream objOut =
					new ObjectOutputStream(socket.getOutputStream());
			objOut.writeObject(a_out);
			
			ObjectInputStream objIn =
					new ObjectInputStream(socket.getInputStream());
			
			Alumno a_in=(Alumno) objIn.readObject();
			
			System.out.println("Datos del alumno después de la matrícula: " + a_in);
			
			//Cerrar
			objOut.close();
			objIn.close();
			socket.close();			
		}catch(Exception e) {
			System.out.println("Error");
		}
		

	}

}
