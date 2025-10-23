package fp.iterables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class MainSortedSet {

	public static void main(String[] args) {
		
		SortedSet<Integer> fb1 = new TreeSet<Integer>();
		SortedSet<Integer> fb2 = new TreeSet<Integer>();
		
		/*
		int i1 = 1;
		int num1 = 1;
		fb1.add(num1);
		int num2 = 1;
		fb1.add(num2);
		int numPrev = num1;
		int numProx = num2;
		while(i1<10) {
			numProx = numPrev + numProx;
			fb1.add(numProx);
			numProx = numPrev;
			numPrev = fb1.getLast();
			i1++;
		}
		*/
		
		int a = 0, b = 1;
		for(int i = 0; i < 10; i++) {
			fb1.add(b);
			int next = a + b;
			a = b;
			b = next;
		}
		
		for(Integer e: fb1) {
			fb2.add(e + 1);
		}
		
		System.out.println(fb1);
		System.out.println(fb2);
		
		System.out.println(fb1.getFirst());
		System.out.println(fb1.getLast());
		SortedSet<Integer> subFb1 = fb1.subSet(0, 20);
		System.out.println(subFb1);
		SortedSet<Integer> subFb2 = fb1.subSet(5, 34);
		System.out.println(subFb2);
		
		SortedSet<Integer> union = new TreeSet<Integer>(fb1);
		union.addAll(fb2);
		System.out.println(union);
		
		SortedSet<Integer> interseccion = new TreeSet<Integer>(fb1);
		interseccion.retainAll(fb2);
		System.out.println(interseccion);
		
		SortedSet<Integer> diferencia = new TreeSet<Integer>(fb1);
		diferencia.removeAll(fb2);
		System.out.println(diferencia);
		
		ArrayList <Persona> pl1 = new ArrayList<Persona>();
		pl1.clear();
		Persona p1 = new Persona("Pepe", 92);
		Persona p2 = new Persona("Juan", 104);
		Persona p3 = new Persona("Francisco", 85);
		
		pl1.add(p1);
		pl1.add(p2);
		pl1.add(p3);
		
		ArrayList <Persona> pl2 = new ArrayList<Persona>();
		pl2.addAll(pl1);
		
		Comparator<Persona> cmp = Comparator.comparingInt(Persona::edad);
		
		Collections.sort(pl2, cmp);
		
		System.out.println(pl1);
		System.out.println(pl2);
		
	}
	
}
