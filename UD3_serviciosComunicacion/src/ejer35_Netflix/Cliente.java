package ejer35_Netflix;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

import ejer34_SocketsTCP.Alumno;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Socket socket=null;
		String host="localhost";
		ObjectOutputStream objOut=null;
		int puerto=6001;
		int opcion=0;
		
		try {
			socket= new Socket(host,puerto);
		}catch(Exception e) {
			System.out.println("Error");
		}
		
		while (opcion!=6) {
			System.out.println("NEtflix");
			System.out.println("Elija opción: ");
			opcion=sc.nextInt();
				
			//OPCIÓN 1
			if (opcion==1) {
				Pelicula p_out=opcion1(socket);
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject(p_out);
				}catch(Exception e) {
					System.out.println("Error");
				}				
			}
			
			//OPCIÓN 2
			if (opcion==2) {
				Serie p_out=opcion2(socket);
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject(p_out);
				}catch(Exception e) {
					System.out.println("Error");
				}				
			}
			
			//OPCIÓN 3
			if (opcion==3) {
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject("ver objeto");
				}catch(Exception e) {
					System.out.println("Error");
				}				
			}
			
			//OPCIÓN 4
			if (opcion==4) {
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject("ver lista");
				}catch(Exception e) {
					System.out.println("Error");
				}				
			}
			
			//OPCIÓN 5
			if (opcion==5) {
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject("ver lista pendiente");
				}catch(Exception e) {
					System.out.println("Error");
				}				
			}
			
			//OPCIÓN 6
			if (opcion==6) {
				try {
					objOut = new ObjectOutputStream(socket.getOutputStream());
					objOut.writeObject("salir");
				}catch(Exception e) {
					System.out.println("Error");
				}
				break;
			}
				
		}
						
		//Cerrar
		System.out.println("Desconectando...");
		try {
			objOut.close();
			socket.close();	
		}catch(Exception e) {
			
		}
				
		
		

	}

	private static Pelicula opcion1(Socket socket) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Introduzca titulo de la pelicula:");
		String titulo=sc.nextLine();
		
		System.out.println("Introduzca productora:");
		String productora=sc.nextLine();
				
		System.out.println("Introduzca año de publicación:");
		int año=sc.nextInt();

		System.out.println("Introduzca Num de nominaciones:");
		int nominaciones=sc.nextInt();

		System.out.println("Introduzca num Oscars:");
		int oscars=sc.nextInt();
		
		Pelicula p_out= new Pelicula(titulo,productora,año,false,nominaciones,oscars);
		
		return p_out;
	}
	
	private static Serie opcion2(Socket socket) {
		Scanner sc= new Scanner(System.in);
		Serie s_out=null;
		
		System.out.println("Introduzca titulo de la serie:");
		String titulo=sc.nextLine();
		
		System.out.println("Introduzca productora:");
		String productora=sc.nextLine();
				
		System.out.println("Introduzca año de publicación:");
		int año=sc.nextInt();

		System.out.println("Introduzca Num de temporadas:");
		int temporadas=sc.nextInt();

		sc.nextLine();
		System.out.println("Introduzca si está finalizada o no(s/n):");
		String finalizada=sc.nextLine();
		
		if (finalizada.equals("s")) {
			s_out= new Serie(titulo,productora,año,false,temporadas,true);	
		}else {
			s_out= new Serie(titulo,productora,año,false,temporadas,false);
		}		
		
		return s_out;
	}

}
