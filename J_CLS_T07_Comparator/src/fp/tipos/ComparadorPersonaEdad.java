package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparadorPersonaEdad implements Comparator<Persona>{
	
	public int compare(Persona pers1, Persona pers2) {
		return pers1.getEdad1().compareTo(pers2.getEdad1());
	}
	
	//-------------------------------------------------------------------------------------------------------------------------\\
	
	public static void main(String[] args) {
		
		Persona pers1 = new Persona("12345678Z", "Juan", "Lopez Garcia", LocalDate.of(1998, 7, 20));
		Persona pers2 = new Persona("12345679Y", "Antonio", "Lopez Lopez", LocalDate.of(1997, 11, 3));
		Persona pers3 = new Persona("12345670Q", "Sonia Estefania", "Amor Gena", LocalDate.of(1988, 12, 10));
		Persona pers4 = new Persona("12345677B", "Maria", "Lora Santa", LocalDate.of(2002, 7, 26));
		Persona pers5 = new Persona("12345671A", "Luis", "Fernández Pérez", LocalDate.of(1999, 6, 5));
		
		List<Persona> list3 = new ArrayList<Persona>(List.of(pers1, pers2, pers3, pers4, pers5));
		System.out.println(list3);
		
		Comparator<Persona> comparadorPersonaEdad = new ComparadorPersonaEdad();
		
		Collections.sort(list3, comparadorPersonaEdad);
		System.out.println(list3);
		
		Collections.sort(list3, comparadorPersonaEdad.reversed());
		System.out.println(list3);
		
	}
}
