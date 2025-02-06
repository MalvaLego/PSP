package ejer35_Netflix;

import java.io.*;

public class Contenido implements Serializable{
	protected String titulo;
	protected String productora;
	protected int añoPublicacion;
	protected boolean visto;
	
	public Contenido(String titulo, String productora, int añoPublicacion, boolean visto) {		
		this.titulo = titulo;
		this.productora = productora;
		this.añoPublicacion = añoPublicacion;
		this.visto = visto;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getProductora() {
		return productora;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public boolean isVisto() {
		return visto;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	@Override
	public String toString() {
		return "Contenido [titulo=" + titulo + ", productora=" + productora + ", añoPublicacion=" + añoPublicacion
				+ ", visto=" + visto + "]";
	}
	
	
	
	

}
