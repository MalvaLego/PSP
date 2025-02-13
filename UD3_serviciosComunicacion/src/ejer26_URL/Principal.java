package ejer26_URL;

import java.net.*;

public class Principal {

	public static void main(String[] args) {
		URL url=null;

		try {
			url= new URL("http://docs.oracle.com/");
			mostrarInfo(url);
			
			System.out.println("-----------------------------");
			url= new URL("http://docs.oracle.com/javase/10");
			mostrarInfo(url);
			
			System.out.println("-----------------------------");
			url= new URL("http://docs.oracle.com:123/javase/10");
			mostrarInfo(url);
			
			
		}catch(MalformedURLException e) {
			
		}
		
		
		
	}

	private static void mostrarInfo(URL url) {
		
		System.out.println("URL completa  :"+url);
		System.out.println("  :"+url.getProtocol());
		System.out.println("  :"+url.getHost());
		System.out.println("  :"+url.getPort());
		System.out.println("  :"+url.getFile());
		System.out.println("  :"+url.getUserInfo());
		System.out.println("  :"+url.getPath());
		System.out.println("  :"+url.getAuthority());
		System.out.println("  :"+url.getQuery());
		System.out.println("  :"+url.getDefaultPort());
	}
	
	
}
