package ejer37_TresEnRaya;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import ejer36_SocketsUDP_ByteArray.Pedido;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DatagramSocket socket=new DatagramSocket(12346);
		
		boolean lleno = false;
		boolean fin = false;
		String ultimo = "";
		char[][] tablero= new char[3][3];
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				tablero[i][j]='-';
			}
		}
		
		//Esperando Datagrama
		System.out.println("Arranca el servidor con el tablero vacío...");
			
		muestraTablero(tablero);
		while ((!lleno) && (!fin)) {
			byte[] recibidos= new byte[1024];
			DatagramPacket paqrecibido= new DatagramPacket(recibidos,recibidos.length);
					
			//Asocio el socket al puerto 12345 y me quedo esperando			
			socket.receive(paqrecibido);
			ByteArrayInputStream bais= new ByteArrayInputStream(recibidos); 
			ObjectInputStream in= new ObjectInputStream(bais);
			Tirada tirada= (Tirada)in.readObject();
			
			if (tirada.getNombre().equals(ultimo)){
				System.out.println("Lo siento, "+ultimo+" no es tu turno!");
			}else {
				System.out.println(tirada);
				if (tablero[tirada.getX()][tirada.getY()] == '-') {
					tablero[tirada.getX()][tirada.getX()] = tirada.getCaracter();
				}else {
					System.out.println("Esa casilla ya estaba ocupada. Has perdido el turno!");
				}
				lleno = muestraTablero(tablero);
				fin = condiciones(tablero);
				ultimo = tirada.getNombre();
			}
			
			//Direccion origen del mensaje
			InetAddress IPOrigen= paqrecibido.getAddress();
			int puerto= paqrecibido.getPort();
			
			//Enviando datagram al cliente
			ByteArrayOutputStream bs= new ByteArrayOutputStream();
			ObjectOutputStream out= new ObjectOutputStream(bs);
			Tirada tirada_out= null;
			if ((!lleno) && (!fin)) {
				tirada_out = new Tirada("OK",' ');
			}
			if (lleno) {
				tirada_out = new Tirada("llenado",' ');
			}
			if (fin) {
				tirada_out = new Tirada("ganado",' ');
			}
			out.writeObject(tirada_out);
			out.close();
			byte[] enviados=bs.toByteArray();
			
						
			DatagramPacket envio= new DatagramPacket(enviados,enviados.length,IPOrigen,puerto);
			socket.send(envio);
		}
		

				//Cerrar socket
				System.out.println("Cerrando conexión...");
				socket.close();
		
		
		
		
		
	}
	
	private static boolean condiciones(char[][] tablero) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean muestraTablero(char[][] tablero){
		boolean estaLleno=true;
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.println(tablero[i][j]+" ");
				if (tablero[i][j] == '-') {
					estaLleno = false;
				}
			}
			System.out.println();
		}
		return estaLleno;
	}
	
	

}
