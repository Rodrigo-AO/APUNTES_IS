package fp.universidad.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Departamento;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.Tutoria;

public class TestDepartamento {

	public static void main(String[] args) {
		
		Departamento dep1 = new Departamento("Departamento 1");
		Profesor pro1 = new Profesor("28864657W", "Pascual", "García Verrero", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro2 = new Profesor("28876657W", "Juan", "García Verrero", LocalDate.of(1998,  9, 15), "Juan.garcia@example.com", Categoria.TITULAR);
		Profesor pro3 = new Profesor("28486257W", "Jesus", "García Exfoliente", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro4 = new Profesor("28848657W", "Ruben", "Santiago Derrapante", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		dep1.nuevoProfesor(pro1);
		dep1.nuevoProfesor(pro2);
		dep1.nuevoProfesor(pro3);
		dep1.nuevoProfesor(pro4);
		
		Tutoria tut1 = new Tutoria(DayOfWeek.TUESDAY, LocalTime.of(18, 6), 14);
		Tutoria tut2 = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(18, 6), 14);
		Tutoria tut3 = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(19, 6), 14);
		Tutoria tut4 = new Tutoria(DayOfWeek.WEDNESDAY, LocalTime.of(18, 6), 14);
		Tutoria tut5 = new Tutoria(DayOfWeek.WEDNESDAY, LocalTime.of(19, 6), 14);
		Tutoria tut6 = new Tutoria(DayOfWeek.THURSDAY, LocalTime.of(18, 6), 14);
		pro1.nuevaTutoria(tut1);
		pro1.nuevaTutoria(tut2);
		pro2.nuevaTutoria(tut3);
		pro3.nuevaTutoria(tut4);
		pro3.nuevaTutoria(tut5);
		pro4.nuevaTutoria(tut6);
		
		Asignatura as1 = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
		Asignatura as2 = new Asignatura("AE", "0000233", 5.2, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura as3 = new Asignatura("EdC", "0000230", 12., TipoAsignatura.ANUAL, 2);
		Asignatura as4 = new Asignatura("Calculo Infinitesimal y Numerico", "0000233", 3.1, TipoAsignatura.ANUAL, 1);
		Asignatura as6 = new Asignatura("Introduccion a la Matematica Discreta", "0000233", 3.1, TipoAsignatura.ANUAL, 1);
		dep1.nuevaAsignatura(as1);
		dep1.nuevaAsignatura(as2);
		dep1.nuevaAsignatura(as3);
		dep1.nuevaAsignatura(as4);
		
		pro1.imparteAsignatura(as1, 12.);
		pro1.imparteAsignatura(as3, 2.);
		pro1.imparteAsignatura(as6, 3.1);
		
		System.out.println(dep1);
		System.out.println(dep1.getProfesores());
		System.out.println(dep1.getProfesoresPorAsignatura());
		System.out.println(dep1.getTutoriasPorProfesor());
	}

}
