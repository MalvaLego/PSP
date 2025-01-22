package Examen;

public class Jugador {
	private int dorsal;
	private String juega;
	private static int id=1;
	
	
	public Jugador(String juega) {
		this.dorsal = id;
		this.juega = juega;
		id++;
	}


	public int getDorsal() {
		return dorsal;
	}


	public String getJuega() {
		return juega;
	}


	public static int getId() {
		return id;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public void setJuega(String juega) {
		this.juega = juega;
	}


	public static void setId(int id) {
		Jugador.id = id;
	}

	
	
	


}
