package ejer34_SocketsTCP;

import java.io.*;
import java.util.*;

public class Alumno implements Serializable{
	private String nombre;
	private int edad;
	private String esRepartidor;
	ArrayList<String> listaAsignaturas=new ArrayList<String>();

	public Alumno(String nombre, int edad, String esRepartidor) {
		this.nombre = nombre;
		this.edad = edad;
		this.esRepartidor = esRepartidor;
		
	}

	public void addAsignatura() {
		listaAsignaturas.add("Mates");
		listaAsignaturas.add("Biología");
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public int getEdad() {
		return edad;
	}



	public String getEsRepartidor() {
		return esRepartidor;
	}



	public ArrayList<String> getListaAsignaturas() {
		return listaAsignaturas;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public void setEsRepartidor(String esRepartidor) {
		this.esRepartidor = esRepartidor;
	}



	public void setListaAsignaturas(ArrayList<String> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", esRepartidor=" + esRepartidor + ", listaAsignaturas="
				+ listaAsignaturas + "]";
	}



	
	
	
}