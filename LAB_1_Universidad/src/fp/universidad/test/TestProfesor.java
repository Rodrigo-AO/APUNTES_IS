package fp.universidad.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.Tutoria;

public class TestProfesor {

	public static void main(String[] args) {
		
		Profesor pro1 = new Profesor("28864657W", "Pascual", "García Verrero", LocalDate.of(1998,  9, 15), "pascual.garcial@alum.us.es", Categoria.TITULAR);
		Asignatura as1 = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
		Asignatura as2 = new Asignatura("AE", "0000233", 6., TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura as3 = new Asignatura("ALN", "0100230", 13., TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		
		pro1.imparteAsignatura(as1, 12.);
		pro1.imparteAsignatura(as2, 6.);
		try {
			pro1.imparteAsignatura(as3, 13.);
			pro1.imparteAsignatura(as3, 13.);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		Tutoria tut1 = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(10, 40));
		pro1.nuevaTutoria(tut1);
		System.out.println(pro1.getTutorias());
	}

}
