package Examen;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Jugador> listaJugadores= new ArrayList<Jugador>();

		for (int i=0;i<456;i++) {
			Jugador jugador=new Jugador("s");
			listaJugadores.add(jugador);
		}
		
		Juego juego=new Juego(listaJugadores);
		
		//Ejecucución de hilos
		Hilo h1= new Hilo(juego,"ninya");
		Hilo h2= new Hilo(juego,"eliminar");
		
		h1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h2.start();
		
		try {
			h1.join();
			h2.join();
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		//Información de los jugadores sobrevividos
		System.out.println("-----------------------------");
		System.out.println("Han sobrevivido los concursantes...");
		for (Jugador j: listaJugadores) {
			System.out.print(j.getDorsal()+" ");
		}
		
		
	}

}
