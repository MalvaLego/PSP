package Examen;

import java.util.*;


public class Juego {
	ArrayList<Jugador> listaJugadores= new ArrayList<Jugador>();
	
	public Juego(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	
	//Canción del juego 
	public void ninya(int numjuego) {
		System.out.println("Juego "+numjuego+" de 5...");
		System.out.println("Luz verde,");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ya puedes correr");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("y parar!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Eliminar Jugadores
	public void eliminar() {
		if (listaJugadores.size()!=0) {
			int numRandom = (int) (Math.floor(Math.random()*(listaJugadores.size()-1+1)+1));
			
			System.out.println("De "+listaJugadores.size()+", vamos a eliminar a.."+numRandom+" concursantes.");
			
			for (int i=0;i<numRandom;i++) {
				verificarEliminacion();
			}
			
			System.out.println("Quedan vivos "+listaJugadores.size()+": concursantes");
		}
	}
	
	public void verificarEliminacion() {
		int numJugador = (int) (Math.floor(Math.random()*(listaJugadores.size()-1+1)+1));
		
		for (Jugador j: listaJugadores) {
			if (j.getDorsal()==numJugador) {
				if (j.getJuega().equals("s")) {
					j.setJuega("n");
					listaJugadores.remove(j);
					System.out.println("Jugador "+numJugador+": ELIMINADO");
					break;
				}else {
					System.out.println("Una sonrisa siempre alegra a la gente :)");
					verificarEliminacion();
				}
			}
		}
	}
	
	
	
	

}
