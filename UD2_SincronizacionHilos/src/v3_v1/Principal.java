package v3_v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Contador c=new Contador(100);
		System.out.println("Tenemo dado de alta un contador de 100");
		
		System.out.println("introduzca cantidad pa sumar");
		int sumar=sc.nextInt();
		System.out.println("introduzca cantidad pa restar");
		int restar=sc.nextInt();
		
		Hilosuma h1=new Hilosuma("Hilo1",c,sumar);
		Hiloresta h2=new Hiloresta("Hilo2",c,restar);
		
		h1.start();
		h2.start();
		
		

	}

}
