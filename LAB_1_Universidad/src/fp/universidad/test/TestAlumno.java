package fp.universidad.test;

import java.time.LocalDate;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.TipoConvocatoria;

public class TestAlumno {

	public static void main(String[] args) {
		
		Asignatura as1 = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
		Asignatura as2 = new Asignatura("Administración de Empresas", "0000233", 6., TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		Asignatura as3 = new Asignatura("Calculo Infinitesimal y Numerico", "0000234", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura as4 = new Asignatura("Estructura de Computadores", "0000234", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		
		Nota no1 = new Nota(as1, 2025, TipoConvocatoria.PRIMERA, 1.);
		Nota no2 = new Nota(as2, 2025, TipoConvocatoria.PRIMERA, 7.);
		Expediente expediente = new Expediente();
		expediente.nuevaNota(no1);
		expediente.nuevaNota(no2);
		
		Alumno alu1 = new Alumno("84569327B", "Ruben", "Santiago Guerra", LocalDate.of(2006, 4, 16), "rubsangue@alum.us.es");
		alu1.matriculaAsignatura(as1);
		alu1.matriculaAsignatura(as2);
		alu1.setExpediente(expediente);
		System.out.println(alu1);
		System.out.println(alu1.getExpediente());
		System.out.println(alu1.getAsignaturas());
		System.out.println(alu1.estaMatriculado(as1));
		System.out.println(alu1.estaMatriculado(as4));
		System.out.println(alu1.getEdad1()); System.out.println(alu1.getEdad2());
		System.out.println(alu1.getCalificacionPorAsignatura());
		System.out.println(alu1.getNumAsignaturasPorCurso());

		try {
			alu1.setDni("Mi pollote .com");;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			alu1.eliminaAsignatura(as4);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			alu1.evaluaAsignatura(as4, 1, TipoConvocatoria.PRIMERA, 5.0);;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			alu1.evaluaAsignatura(as3, 1, TipoConvocatoria.PRIMERA, 5.0);;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			alu1.matriculaAsignatura(as1);;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			alu1.setEmail("rubsangue@alumn.us.es");;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
