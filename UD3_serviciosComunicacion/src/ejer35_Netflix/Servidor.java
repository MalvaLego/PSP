package ejer35_Netflix;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import ejer34_SocketsTCP.Alumno;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream obj=null;
		ArrayList<Contenido> listaContenido= new ArrayList<Contenido>();
		
		//Esperando Datagrama
		System.out.println("Servidor esperando...");
		ServerSocket server= new ServerSocket(6001);

		Socket socket=server.accept();
		
		while (true) {
			obj =new ObjectInputStream(socket.getInputStream());
			Object o_in= obj.readObject();
			
			if (o_in instanceof Pelicula) {
				Pelicula p= (Pelicula) o_in;
				listaContenido.add(p);
				System.out.println("Pelicula "+p.titulo+" dada de alta");	
			}
			
			if (o_in instanceof Serie) {
				Serie s= (Serie) o_in;
				listaContenido.add(s);
				System.out.println("Serie "+s.titulo+" dada de alta");	
			}
			
			if (o_in instanceof String) {
				String message= (String) o_in;
				if (message.equals("ver objeto")) {
					buscarObjeto(listaContenido);
				}else if (message.equals("ver lista")) {
					verLista(listaContenido);
				}else if (message.equals("ver lista pendiente")) {
					verListaPendiente(listaContenido);
				}else if (message.equals("salir")) {
					break;
				}
			}			
			
		}
		
		
		//Cerrar
		System.out.println("Gracias por utilizar Netflix *insertar sonido*!");
		obj.close();
		socket.close();
		server.close();
	}

	private static void buscarObjeto(ArrayList<Contenido> listaContenido) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Introduzca el titulo del contenido que quiere visualizar");
		String titulo= sc.nextLine();
		for (Contenido c : listaContenido) {
			if (c.titulo.equals(titulo)) {
				c.setVisto(true);
				System.out.println("El contendio "+titulo+" marcado como visto!");
			}
		}
	}

	private static void verLista(ArrayList<Contenido> listaContenido) {
		System.out.println("El contenido es este:");
		for (Contenido c : listaContenido) {
			System.out.println(c);
		}
	}

	private static void verListaPendiente(ArrayList<Contenido> listaContenido) {
		System.out.println("El contenido pendiente de ver es este:");
		for (Contenido c : listaContenido) {
			if (!c.visto) {
				System.out.println(c);
			}
		}
	}

}
