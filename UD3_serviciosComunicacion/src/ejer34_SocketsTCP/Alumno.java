package ejer34_SocketsTCP;

import java.io.*;
import java.util.*;

public class Alumno implements Serializable{
	private String nombre;
	private int edad;
	private String esRepartidor;
	ArrayList<String> listaAsignaturas;

	public Alumno(String nombre, int edad, String esRepartidor,ArrayList<String> listaAsignaturas) {
		this.nombre = nombre;
		this.edad = edad;
		this.esRepartidor = esRepartidor;
		this.listaAsignaturas=null;
	}

	public void addAsignatura(String nombre) {
		listaAsignaturas.add(nombre);
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



	
	
	
}
