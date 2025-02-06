package ejer35_Netflix;

import java.io.Serializable;

public class Pelicula extends Contenido implements Serializable{
	private int numNominaciones;
	private int numOscars;
	
	public Pelicula(String titulo, String productora, int añoPublicacion, boolean visto,int numNominaciones, int numOscars) {
		super(titulo, productora, numOscars, visto);
		this.numNominaciones = numNominaciones;
		this.numOscars = numOscars;
	}

	public String getTitulo() {
		return productora;
	}
	
	public int getNumNominaciones() {
		return numNominaciones;
	}

	public int getNumOscars() {
		return numOscars;
	}

	public void setNumNominaciones(int numNominaciones) {
		this.numNominaciones = numNominaciones;
	}

	public void setNumOscars(int numOscars) {
		this.numOscars = numOscars;
	}

	@Override
	public String toString() {
		return super.toString()+" Pelicula [numNominaciones=" + numNominaciones + ", numOscars=" + numOscars + "]";
	}

	

	
	
	
	
	
	
	
}
