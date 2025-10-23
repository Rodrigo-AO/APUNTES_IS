package fp.tiposPerros.test;

import fp.tiposPerro.Color;
import fp.tiposPerro.Perro;

public class PerrosTest {

	public static void main(String[] args) { 
		
		// Todo entre los {} de esto es lo que se ejecutara
		
		System.out.println("Hola mundo");
		
		Perro p1 = new Perro		// Introducimos los argumentos que le habilitamos a perro
				("Husky", Color.BLANCO, 1); 
		
		System.out.println(p1);
		
		String raza = p1.getRaza();	// Definimos el String "raza" como la raza de p1 (con getRaza)
		System.out.println(raza);	// Imprimimos el String "raza"
		
		p1.setRaza("Labrador");		// Usamos el setRaza para cambiar la raza de p1
		System.out.println(p1); 	// Imprimimos p1
		System.out.println(p1.getRaza());	// Imprimimos la raza actual de p1
		
		System.out.println(p1.getEdad());	// Imprimimos la edad de p1
		
		
		
		Perro curro = new Perro
				("Maricon", Color.NEGRO, 18);
		
		System.out.println(curro);
		
		String racismo = curro.getRaza();
		System.out.println(racismo);
		
		curro.setRaza("Labrador");
		System.out.println(curro);
		System.out.println(curro.getRaza());
		
		System.out.println(curro.getEdad());
		
		
		
		// Bucles
		for(int i = 3; i<10; i++) { 	// Valor; condicion; accion cada vuelta
			System.out.println(i);
		}
	}
}
