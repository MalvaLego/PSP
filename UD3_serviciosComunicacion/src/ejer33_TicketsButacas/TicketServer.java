package ejer33_TicketsButacas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;

public class TicketServer {

	public static void main(String[] args) throws IOException {		
		//DatagramPacket envio=null;
		String[] butacas=new String[4];
		for (int i=0;i<butacas.length;i++) {
			butacas[i]="LIBRE";
		}
		Queue<String> colaButacas = new LinkedList<>();
		
		//Esperando Datagrama
		System.out.println("Servidor esperando datagrama...");
		DatagramPacket recibo;
		DatagramSocket socket= new DatagramSocket(12345);
		
		while (true) {
			byte[] buffer= new byte[1024];
			recibo= new DatagramPacket(buffer,buffer.length); 
			socket.receive(recibo);	
			
			String mensaje= new String(recibo.getData()).trim();
			String[] recibido=mensaje.split(";");

			if (recibido[0].equals("1")) {
				mostrarButacas(butacas,colaButacas);
			}else
			if (recibido[0].equals("2")) {
				reservarButacas(butacas,colaButacas,recibido[1]);
			}else
			if (recibido[0].equals("3")) {
				anularButacas(butacas,colaButacas,recibido[1]);
			}else
			if (recibido[0].equals("4")) {
				break;
			}else {
				System.out.println("Opción incorrecta");
			}
		}
			
		//Cerrar socket
		System.out.println("Cerrando conexión...");
		socket.close();
		
	}

	private static void mostrarButacas(String[] butacas, Queue<String> colaButacas) {
		for (int i=0;i<butacas.length;i++) {
			System.out.println(i+1+"-"+butacas[i]);
		}
		
		if (!colaButacas.isEmpty()) {
			System.out.println("Reservas:");
			int contador=0;
			for (String cad: colaButacas) {
				contador++;
				System.out.println(contador+"."+cad);
			}
		}
	}

	private static void reservarButacas(String[] butacas, Queue<String> colaButacas,String nombre) {
		for (int i=0;i<butacas.length;i++) {
			if (butacas[i].equals("LIBRE")) {
				butacas[i]=nombre;
				System.out.println(nombre+" tiene asignada la butaca "+(i+1));
				return;
			}
		}
		
		System.out.println("Lo siento ya no quedan butacas libres, pasa a la lista de reservas");
		colaButacas.add(nombre);
	}

	private static void anularButacas(String[] butacas, Queue<String> colaButacas,String nombre) {
		for (int i=0;i<butacas.length;i++) {
			if (butacas[i].equals(nombre)) {				
				System.out.println(nombre+" tenia asignada la butaca "+(i+1));
				System.out.println("La butaca "+(i+1)+" queda libre.");
				System.out.println("Se adjudica a la primera persona de los reservados que es : "+colaButacas.peek());
				butacas[i]=colaButacas.poll();
				return;
			}
		}
		
		System.out.println(nombre+" no tiene comprada ninguna butaca");
	}


}
