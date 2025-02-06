package ejer35_Netflix;

import java.io.Serializable;

public class Serie extends Contenido implements Serializable{
	private int numTemporadas;
	private boolean finalizada;
	
	public Serie(String titulo, String productora, int añoPublicacion, boolean visto,int numTemporadas, boolean finalizada) {
		super(titulo,productora,añoPublicacion,visto);
		this.numTemporadas = numTemporadas;
		this.finalizada = finalizada;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	@Override
	public String toString() {
		return super.toString()+" Serie [numTemporadas=" + numTemporadas + ", finalizada=" + finalizada + "]";
	}
	
	
	
}
