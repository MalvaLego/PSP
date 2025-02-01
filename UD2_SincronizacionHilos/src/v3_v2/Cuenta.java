package v3_v2;

import java.util.*;

public class Cuenta {
	private static int id=0;
	private int saldo;
	private boolean deudora;
	ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
	

	public Cuenta(int saldo, boolean deudora, ArrayList<Cliente> listaClientes) {
		id++;
		this.saldo = saldo;
		this.deudora = deudora;
		this.listaClientes = listaClientes;
		
	}

	public void restarSaldo() {
		saldo=saldo-10;
	}




	public static int getId() {
		return id;
	}






	public int getSaldo() {
		return saldo;
	}






	public boolean isDeudora() {
		return deudora;
	}






	public static void setId(int id) {
		Cuenta.id = id;
	}






	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}






	public void setDeudora(boolean deudora) {
		this.deudora = deudora;
	}






	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}






	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}





	@Override
	public String toString() {
		return "Cuenta [id= "+id+",saldo=" + saldo + ", deudora=" + deudora + ", listaClientes=" + listaClientes + "]";
	}
	
	
	
	
	

	
}
