package v1_v3;

public class Casilla {
	private int valor;
	private int indice;
	static int id=0;
	
	public Casilla() {
		indice=id;
		id++;
	}
	
	
	public int getValor() {
		return valor;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setValor(int valor) {
		this.valor=valor;
	}
	

}
