package ejer37_TresEnRaya;

public class Tirada {
	private String nombre;
	private int x;
	private int y;
	private char caracter;
	
	public Tirada(String nombre, char caracter) {
		this.nombre = nombre;
		this.caracter = caracter;
	}

	public String getNombre() {
		return nombre;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre+" tira en la posicion ["+x+","+y+"] :";
	}
	
	
}
