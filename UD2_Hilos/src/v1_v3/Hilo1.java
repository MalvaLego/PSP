package v1_v3;

import java.util.*;

public class Hilo1 extends Thread{
	private int inf;
	private int sup;
	private ArrayList<Casilla> lista;
	
	public Hilo1(String nombre,int inf, int sup,ArrayList<Casilla> lista) {
		super(nombre);
		this.inf=inf;
		this.sup=sup;
		this.lista=lista;
	}

	public void run() {
			
		for (int i=0;i<lista.size();i++) {
			
			for (Casilla c: lista) {
				
				if (c.getIndice()==i) {
					int numRandom = (int) (Math.floor(Math.random()*(sup-inf+1)+inf));
					c.setValor(numRandom);		
				}
			}
			
			printar();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
		
	}
	
	public void printar() {
		for (Casilla c: lista) {
			System.out.print(c.getValor()+"\t");
		} 
		System.out.println();
	}
	
	
	
}
