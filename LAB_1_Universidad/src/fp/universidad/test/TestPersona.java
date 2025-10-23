package fp.universidad.test;

import java.time.LocalDate;

import fp.universidad.tipos.Persona;

public class TestPersona {

	public static void main(String[] args) {
		
		// Persona con email
		Persona pe1 = new Persona("28864657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garcia@example.com");
		System.out.println(pe1);
		// Persona sin email
		Persona pe2 = new Persona("28864657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15));
		System.out.println(pe2);
		
		try {
			// Longitud DNI invalida
			Persona pee = new Persona("2857W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garcia@example.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// Letras en dígitos DNI
			Persona pee = new Persona("288AB657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garcia@example.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// Solo numeros
			Persona pee = new Persona("288646571", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garcia@example.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// email sin @
			Persona pee = new Persona("28864657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garciaexample.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// mas de un @
			Persona pee = new Persona("28864657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "pascual.garcia@ex@am@ple.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
		try {
			// empieza por @
			Persona pee = new Persona("28864657W", "Pascual", "García Vaquero", LocalDate.of(1998, 9, 15), "@pascual.garciaexample.com");
			System.out.println(pee);
		} catch (IllegalArgumentException e) {
			System.out.println("Error capturado: " + e.getMessage());
		}
		
	}
}
