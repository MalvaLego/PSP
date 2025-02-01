package v1_v2;

import java.io.*;

public class Principal {

	public static void main(String[] args) {
		File file1=new File("primeros.txt");
		File file2=new File("segundos.txt");
		File file3=new File("terceros.txt");
		FileWriter fw1=null;
		FileWriter fw2=null;
		FileWriter fw3=null;
		
		try {
			file1.createNewFile();
			fw1=new FileWriter(file1);
			file2.createNewFile();
			fw2=new FileWriter(file2);
			file3.createNewFile();
			fw3=new FileWriter(file3);
		}catch(IOException e) {
			System.out.println("Eror alc rear laos archivpas");
		}
		
		ThreadGroup grupo= new ThreadGroup("Menu diario");
		Hilo h= new Hilo(fw1,fw2,fw3);
		Thread h1=new Thread(grupo,h,"Hilo1");
		Thread h2=new Thread(grupo,h,"Hilo2");
		Thread h3=new Thread(grupo,h,"Hilo3");
		
		h1.start();
		h2.start();
		h3.start();
		
	}

}
