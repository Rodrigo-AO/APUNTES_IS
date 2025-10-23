package fp.universidad.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fp.universidad.tipos.*;

public class TestFactoriaUniversidad {

	public static void main(String[] args) {
		
		List<Espacio> espacios = new ArrayList<Espacio>();
		espacios.addAll(FactoriaUniversidad.leeEspacios("C:\\Users\\usuario\\OneDrive - UNIVERSIDAD DE SEVILLA\\Escritorio\\General\\Fundamentos de la programación\\Java\\Laboratorios\\LAB_1_Universidad\\data\\espacios.csv"));
		System.out.println(espacios);
		
		List<Despacho> despachos = new ArrayList<Despacho>();
		despachos.addAll(FactoriaUniversidad.leeDespachos("C:\\Users\\usuario\\OneDrive - UNIVERSIDAD DE SEVILLA\\Escritorio\\General\\Fundamentos de la programación\\Java\\Laboratorios\\LAB_1_Universidad\\data\\despachos.csv"));
		Profesor pro1 = new Profesor("28864657W", "Pascual", "García Verrero", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro2 = new Profesor("28876657W", "Juan", "García Verrero", LocalDate.of(1998,  9, 15), "Juan.garcia@example.com", Categoria.TITULAR);
		Profesor pro3 = new Profesor("28486257W", "Jesus", "García Exfoliente", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro4 = new Profesor("28848657W", "Ruben", "Santiago Derrapante", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		try{
			for(Despacho despacho: despachos) despacho.setProfesores(Set.of(pro1, pro2, pro3, pro4));
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		System.out.println(despachos);
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.addAll(FactoriaUniversidad.leeAlumnos("C:\\Users\\usuario\\OneDrive - UNIVERSIDAD DE SEVILLA\\Escritorio\\General\\Fundamentos de la programación\\Java\\Laboratorios\\LAB_1_Universidad\\data\\alumnos.csv"));
		System.out.println(alumnos);
		
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		asignaturas.addAll(FactoriaUniversidad.leeAsignaturas("C:\\Users\\usuario\\OneDrive - UNIVERSIDAD DE SEVILLA\\Escritorio\\General\\Fundamentos de la programación\\Java\\Laboratorios\\LAB_1_Universidad\\data\\asignaturas.txt"));
		System.out.println(asignaturas);
		
		List<Nota> notas = new ArrayList<Nota>();
		notas.addAll(FactoriaUniversidad.leeNotas("C:\\Users\\\\usuario\\OneDrive - UNIVERSIDAD DE SEVILLA\\Escritorio\\General\\Fundamentos de la programación\\Java\\Laboratorios\\LAB_1_Universidad\\data\\notas.csv"));
		System.out.println(notas);
		
	}
	
}
