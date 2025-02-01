package v2_v2;

import java.io.*;
import java.util.*;

public class Hilo extends Thread {
	ArrayList<Pasajero> lista;
	
	
	public Hilo(String nombre, ArrayList<Pasajero> lista) {
		super(nombre);
		this.lista=lista;
	}
	
	
	public void run() {
		int numPrimera=0;
		int numPrimeraVivos=0;
		int numSegunda=0;
		int numSegundaVivos=0;
		int numTercera=0;
		int numTerceraVivos=0;
		//System.out.println("Entra");
		
		for (Pasajero p: lista) {
		
			if ((Thread.currentThread().getName().equals("Hilo1")) && (p.getClase()==1)) {
				numPrimera++;
				if (p.getVivio().equals("S")) {
					numPrimeraVivos++;
				}
			}
			if ((Thread.currentThread().getName().equals("Hilo2")) && (p.getClase()==2)) {
				numSegunda++;
				if (p.getVivio().equals("S")) {
					numSegundaVivos++;
				}
			}
			if ((Thread.currentThread().getName().equals("Hilo3")) && (p.getClase()==3)) {
				numTercera++;
				if (p.getVivio().equals("S")) {
					numTerceraVivos++;
				}
			}
		}
		
		if ((Thread.currentThread().getName().equals("Hilo1"))){
			System.out.println("+En primera calse viajaban "+numPrimera+" apsajeros. Sobrevivieron "+numPrimeraVivos);
		}
		if ((Thread.currentThread().getName().equals("Hilo2"))){
			System.out.println("+En segun calse viajaban "+numSegunda+" apsajeros. Sobrevivieron "+numSegundaVivos);
		}
		if ((Thread.currentThread().getName().equals("Hilo3"))){
			System.out.println("+En tercer calse viajaban "+numTercera+" apsajeros. Sobrevivieron "+numTerceraVivos);
		}
		
		
		
		
		
		
	}
	

}
