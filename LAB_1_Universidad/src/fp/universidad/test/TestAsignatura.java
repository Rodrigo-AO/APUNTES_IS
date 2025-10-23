package fp.universidad.test;

import fp.universidad.tipos.*;

public class TestAsignatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Asignatura as1 = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
		System.out.println(as1);
		
		try {
			// Creditos negativos
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0000230", -1., TipoAsignatura.ANUAL, 1);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}
		
		// Asignatura valida
		Asignatura as2 = new Asignatura("AE", "0000233", 6., TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		System.out.println(as2);
		
		try {
			// Código inválido (corto)
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0230", 12., TipoAsignatura.ANUAL, 1);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}
		
		try {
			// Código inválido (letras)
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0A00230", 12., TipoAsignatura.ANUAL, 1);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}
		
		try {
			// Código inválido (ambas)
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0A230", 12., TipoAsignatura.ANUAL, 1);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}		// Prevalece longitud de codigo
		
		try {
			// Curso inválido
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 7);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}
		
		try {
			// Objeto válido
			Asignatura ase = new Asignatura("Fundamentos de Programación", "0000230", 12., TipoAsignatura.ANUAL, 1);
			System.out.println(ase);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado:" + e.getMessage());
		}
		
		System.out.println(as1.acronimo());
	}

}
