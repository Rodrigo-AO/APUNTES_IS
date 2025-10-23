package fp.lexico.test;

import java.nio.charset.StandardCharsets;
import java.util.Set;

import fp.lexico.LectorTexto;

public class TestLexico {

	public static void main(String[] args) {
		LectorTexto lector1 = new LectorTexto();
		lector1.agregaFichero("./res/lazarillo.txt", StandardCharsets.UTF_8);
		System.out.println("LECTOR 1");
		System.out.println(lector1.getPalabras().subList(0, 100));
	
		LectorTexto lector2 = new LectorTexto();
		System.out.println("LECTOR 2");
		lector2.agregaFichero("./res/platero.txt", StandardCharsets.UTF_8);
		System.out.println(lector2.getPalabras().subList(0,100));
		
		//TODO Probar aquí el tipo Lexico
		
	}

}
