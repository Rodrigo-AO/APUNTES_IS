package fp.iterables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetRetry {

	public static void main(String[] args) {
		
		// Crearemos 2 series de fibonacci con los primeros 10 terminos de la misma
			// Series vacias
		SortedSet<Integer> fb1 = new TreeSet<Integer>();		// SortedSet pertenece a TreeSet
		SortedSet<Integer> fb2 = new TreeSet<Integer>();		// No tienen índice, tienen criterio de ordenación y no hay elementos repetidos
		
		// Bucle para generar los numeros
		int a = 0, b = 1;
		for(int i = 0; i < 10; i++) {
			int proxNum = a + b;
			fb1.add(proxNum);
			a = b;
			b = proxNum;
		}
		
		// Bucle para añadir a fb2 valores +1
		for(Integer num: fb1) {
			fb2.add(num + 1);
		}
		
		System.out.println(fb1);
		System.out.println(fb2);
		
		// Funciones con los SortedSet
		System.out.println(fb1.getFirst());
		System.out.println(fb2.getLast());
		System.out.println(fb1.contains(5));
		System.out.println(fb2.remove(2)); System.out.println(fb2);
		System.out.println(fb2.add(2)); System.out.println(fb2);
		
		// addAll para agregar todos los elementos de un conjunto a otro
		SortedSet<Integer> union = new TreeSet<Integer>(); union.addAll(fb1);
		union.addAll(fb2); System.out.println(union);
		
		// retainAll compara 'a' con otro 'b', borrando todos los que no estén en 'b' (mantiene la interseccion)
		SortedSet<Integer> interseccion = new TreeSet<Integer>(); interseccion.addAll(fb1);
		interseccion.retainAll(fb2); System.out.println(fb2);
		
		// removeAll borra todos los elementos del conjunto 'a' que aparezcan en 'b'
		SortedSet<Integer> diferencia = new TreeSet<Integer>(); diferencia.addAll(fb1);
		diferencia.removeAll(fb2); System.out.println(diferencia);
		
		// subSet genera un subconjunto que contenga de un nº a otro
		SortedSet<Integer> subSetfb1 = fb1.subSet(0, 6); System.out.println(subSetfb1);
		SortedSet<Integer> subSetfb2 = fb2.subSet(4, 25); System.out.println(subSetfb2);
		
		
		// ArrayList de objetos de clase Persona
		ArrayList<Persona> pl1 = new ArrayList<Persona>();
		Persona pers1 = new Persona("Pepe", 64);
		Persona pers2 = new Persona("Juan", 15);
		Persona pers3 = new Persona("Alberto", 45);
		pl1.add(pers1); pl1.add(pers2); pl1.add(pers3);
		
		ArrayList<Persona> pl2 = new ArrayList<Persona>();
		pl2.addAll(pl1);
		
		// Creamos un comparador para objetos de clase Persona (por edad)
		Comparator<Persona> cmp = Comparator.comparingInt(Persona::edad);
		
		Collections.sort(pl2, cmp);			// Ordenamos pl2 con el criterior de cmp
		
		System.out.println(pl1);
		System.out.println(pl2);
		
		SortedSet<Persona> p28 = new TreeSet<Persona> ();
		p28.add(pers3); p28.add(pers2); p28.add(pers1);
	}

}
