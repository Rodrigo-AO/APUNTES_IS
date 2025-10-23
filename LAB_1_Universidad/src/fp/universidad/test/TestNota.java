package fp.universidad.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.TipoConvocatoria;

public class TestNota {

	public static void main(String[] args) {
		
		Asignatura as1 = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
		Asignatura as2 = new Asignatura("AE", "0000233", 6., TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		
		// Con mencion de honor
		Nota no1 = new Nota(as2, 2014, TipoConvocatoria.SEGUNDA, 9.2, true);
		System.out.println(no1);
		// Sin mencion de honor
		Nota no2 = new Nota(as1, 2014, TipoConvocatoria.PRIMERA, 6.2);
		System.out.println(no2);
		// Mencion de honor en false
		Nota no3 = new Nota(as2, 2014, TipoConvocatoria.SEGUNDA, 9.2, false);
		System.out.println(no3);
		
		try {
			// Nota negativa
			Nota noe = new Nota(as1, 2014, TipoConvocatoria.PRIMERA, -6.2);
			System.out.println(noe);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// Mencion de honor con nota < 9
			Nota noe = new Nota(as1, 2014, TipoConvocatoria.PRIMERA, 6.2, true);
			System.out.println(noe);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
	}

}
