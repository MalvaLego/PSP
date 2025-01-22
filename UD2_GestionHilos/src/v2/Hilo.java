package v2;

import java.util.*;

public class Hilo extends Thread{
	private String nombre;
	private ArrayList<Pasajero> lista;
	
	public Hilo(String nombre, ArrayList<Pasajero> lista) {
		this.nombre=nombre;
		this.lista=lista;
	}

	public void run() {
		int numPasajeros=0;
		int numSupervivientes=0;
		int numFallecidos=0;
		if (nombre.equals("Hilo1")) {
			for (Pasajero p : lista) {
				if (p.getClase()==1) {
					numPasajeros++;
					if (p.getSuperviviente().equalsIgnoreCase("S")) {
						numSupervivientes++;
					}else {
						numFallecidos++;
					}
				}
			}
			
			System.out.println("En Primera Clase viajaron "+numPasajeros+" pasajeros. Sobrevivieron "
					+ ""+numSupervivientes+" y fallecieron "+numFallecidos+" pasajeros");
		}	
			
		if (nombre.equals("Hilo2")) {
			for (Pasajero p : lista) {
				if (p.getClase()==2) {
					numPasajeros++;
					if (p.getSuperviviente().equalsIgnoreCase("S")) {
						numSupervivientes++;
					}else {
						numFallecidos++;
					}
				}
			}
			System.out.println("En Segunda Clase viajaron "+numPasajeros+" pasajeros. Sobrevivieron "
					+ ""+numSupervivientes+" y fallecieron "+numFallecidos+" pasajeros");
		}	
		
		if (nombre.equals("Hilo3")) {
			for (Pasajero p : lista) {
				if (p.getClase()==3) {
					numPasajeros++;
					if (p.getSuperviviente().equalsIgnoreCase("S")) {
						numSupervivientes++;
					}else {
						numFallecidos++;
					}
				}
			}
			System.out.println("En Tercera Clase viajaron "+numPasajeros+" pasajeros. Sobrevivieron "
					+ ""+numSupervivientes+" y fallecieron "+numFallecidos+" pasajeros");
			//Porcentaje supervivientes: numSupervivientes/total pasajeros de la clase * 100
		}	
		
	}
		
		
	
	
}
