package v3_v2;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int opcion=0;
		ArrayList<Cuenta> listaCuentas= new ArrayList<Cuenta>();
		
		while (opcion!=4) {
			System.out.println("---------");
			System.out.println("1-Dar de alta una cuenta");
			System.out.println("2-Resumen de cuentas");
			System.out.println("3-Sacar dinero de una cuenta");
			System.out.println("4-Salir");
			System.out.println("---------");
			opcion=sc.nextInt();
			
			if (opcion==1) {
				darAlta(listaCuentas);
			}
			if (opcion==2) {
				verResumen(listaCuentas);
			}
			if (opcion==3) {
				sacarDinero(listaCuentas);
			}
			if (opcion==4) {
				System.out.println("Adiós");
			}
		}
		
	}

	private static void darAlta(ArrayList<Cuenta> listaCuentas) {
		Scanner sc= new Scanner(System.in);
		
		ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
		System.out.println("Vamos a dar de alta la cuenta: ?");
		
		
		System.out.println("Introduzca número de beneficiarios:");
		int numBenefic=sc.nextInt();

		sc.nextLine();
		for (int i=1;i<numBenefic+1;i++) {
			System.out.println("Introduzca nombre del beneficiario "+i+":");
			String nombre=sc.nextLine();
			System.out.println("Introduzca edad del beneficiario "+i+":");
			int edad=sc.nextInt();
			System.out.println("¿"+nombre+" tiene nacionalidad española (s/n)?");
			sc.nextLine();
			String español=sc.nextLine();
			
			Cliente c= new Cliente(nombre,edad,español);
			listaClientes.add(c);
		}
		
		Cuenta cuenta=new Cuenta(100,false,listaClientes);
		listaCuentas.add(cuenta);
	}

	private static void verResumen(ArrayList<Cuenta> listaCuentas) {
		for (Cuenta c: listaCuentas) {
			System.out.println(c);
		}
		
	}

	private static void sacarDinero(ArrayList<Cuenta> listaCuentas) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Introduzca Id de la cuenta de donde quiere sacar dinero:");
		int id= sc.nextInt();
		
		SacarDinero h1=null;
		for (Cuenta c: listaCuentas) {
			if (c.getId()==id) {
				for (Cliente cliente: c.getListaClientes()) {
					h1= new SacarDinero(cliente.getNombre(),c);
					h1.start();	
				}
				
			}
			try {
				h1.join();
			}catch(Exception e) {
				
			}
		}
		
	}

}
