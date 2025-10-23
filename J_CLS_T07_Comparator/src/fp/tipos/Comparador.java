package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparador {
	
	/*
	Comparador: se emplea para hacer ordenaciones de lista a través de su interfaz Collections
	
	Comparator<Persona> cmp = Comparator.comparintInt(Persona::getEdad());
	
	cmp permitirá ordenar una lista de objetos de tipo persona según el método getEdad() -> dado que devuelve
	un número, se ordenarán por el orden natural numérico
	
	Empleo: Collections.sort(lista1, cmp);		-> Ordena lista1 con el criterio establecido en cmp
	*/

	public static void main(String[] args) {
		
		Persona pers1 = new Persona("12345678Z", "Juan", "Lopez Garcia", LocalDate.of(1998, 7, 20));
		Persona pers2 = new Persona("12345679Y", "Antonio", "Lopez Lopez", LocalDate.of(1997, 11, 3));
		Persona pers3 = new Persona("12345670Q", "Sonia Estefania", "Amor Gena", LocalDate.of(1988, 12, 10));
		Persona pers4 = new Persona("12345677B", "Maria", "Lora Santa", LocalDate.of(2002, 7, 26));
		Persona pers5 = new Persona("12345671A", "Luis", "Fernández Pérez", LocalDate.of(1999, 6, 5));
		
		List<Persona> list1 = new ArrayList<Persona>(List.of(pers1, pers2, pers3, pers4, pers5));
		System.out.println(list1);
		
		Comparator<Persona> cmp1 = Comparator.comparingInt(Persona::getEdad1);
		Collections.sort(list1, cmp1);
		System.out.println(list1);
		
		Collections.sort(list1, cmp1.reversed());
		System.out.println(list1); System.out.println("");
		
		/*
		Hay 3 formas de implementar comparadores:
		1º: creación de una clase que implemente Comparator (archivo ComparadorPersonaEdad.java)
		2º: Definición del método comparing (justo lo de arriba)
		3º: Definición mediante expresiones lambda (justo lo de abajo) (muy comun en los stream)
		*/
		
		List<Persona> list2 = new ArrayList<Persona>(List.of(pers1, pers2, pers3, pers4, pers5));
		System.out.println(list2);
		
		Comparator<Persona> cmp2 = (x, y) -> x.getEdad1().compareTo(y.getEdad1());
		Collections.sort(list2, cmp2);
		System.out.println(list2);
		
		Collections.sort(list2, cmp2.reversed());
		System.out.println(list2);
		
		/*
		La interfaz Comparator tiene varios métodos:
		- .thenComparing(): permite concadenar comparaciones
		- .reversed(): invierte el orden de ordenacion
		*/
		
	}

}