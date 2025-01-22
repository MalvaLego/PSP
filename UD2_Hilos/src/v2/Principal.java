package v2;

import java.io.*;

public class Principal {

	public static void main(String[] args) {
		File primeros=new File("primeros.txt");
		File segundos=new File("segundos.txt");
		File terceros=new File("terceros.txt");
		FileWriter fw1=null;
		FileWriter fw2=null;
		FileWriter fw3=null;
		
		try {
			primeros.createNewFile();	
			segundos.createNewFile();
			terceros.createNewFile();
			fw1=new FileWriter(primeros);
			fw2=new FileWriter(segundos);
			fw3=new FileWriter(terceros);
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		ThreadGroup grupo= new ThreadGroup("Menu diario");

		Hilo h= new Hilo(fw1,fw2,fw3);
		Thread h1= new Thread(grupo,h,"Hilo 1");
		Thread h2= new Thread(grupo,h,"Hilo 2");
		Thread h3= new Thread(grupo,h,"Hilo 3");
		
		h1.start();
		h2.start();
		h3.start();
		
		
		
	}

}
