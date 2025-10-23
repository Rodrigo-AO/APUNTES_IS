package fp.universidad.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import fp.universidad.tipos.*;

public class TestCentro {

	public static void main(String[] args) {
		
		Espacio es1 = new Espacio(TipoEspacio.EXAMEN, "A3.10", 3, 197);
		Espacio es2 = new Espacio(TipoEspacio.TEORIA, "A2.10", -2, 153);
		Espacio es3 = new Espacio(TipoEspacio.TEORIA, "A3.15", 3, 89);
		Espacio es4 = new Espacio(TipoEspacio.TEORIA, "A1.12", 1, 172);
		Espacio es5 = new Espacio(TipoEspacio.EXAMEN, "A4.32", -2, 187);
		Espacio es6 = new Espacio(TipoEspacio.OTRO, "A2.14", 2, 187);
		Espacio es7 = new Espacio(TipoEspacio.OTRO, "A4.21", -41, 187);
		Despacho de1 = new Despacho("A2.32", 2, 89);
		Despacho de2 = new Despacho("A1.42", -1, 89);
		Despacho de3 = new Despacho("A2.19", 2, 89);
		
		Centro ce1 = new Centro("Escuela Técnica Superior de Ingeniería Informática", "Av. Reina Mercedes, s/n", 7, 2);
		ce1.nuevoEspacio(es1);
		ce1.nuevoEspacio(es2);
		ce1.nuevoEspacio(es3);
		ce1.nuevoEspacio(es4);
		ce1.nuevoEspacio(es5);
		ce1.nuevoEspacio(es6);
		ce1.nuevoEspacio(de1);
		ce1.nuevoEspacio(de2);
		ce1.nuevoEspacio(de3);
		
		Departamento dep1 = new Departamento("Departamento de cálculo");
		Profesor pro1 = new Profesor("28864657W", "Pascual", "García Verrero", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro2 = new Profesor("28876657W", "Juan", "García Verrero", LocalDate.of(1998,  9, 15), "Juan.garcia@example.com", Categoria.TITULAR);
		Profesor pro3 = new Profesor("28486257W", "Jesus", "García Exfoliente", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro4 = new Profesor("28848657W", "Ruben", "Santiago Derrapante", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		dep1.nuevoProfesor(pro1);
		dep1.nuevoProfesor(pro2);
		dep1.nuevoProfesor(pro3);
		Set<Profesor> profesores = new HashSet<Profesor>(Set.of(pro1, pro2, pro4));
		de1.setProfesores(profesores);
		
		System.out.println(ce1);
		System.out.println(Arrays.toString(ce1.getConteosEspacios()));
		System.out.println(ce1.getDespachos());
		System.out.println(ce1.getDespachos(dep1));
		System.out.println(ce1.plantas());
		System.out.println(ce1.sotanos());
		
		try {
			ce1.eliminaEspacio(es7);
		} catch (IllegalArgumentException e){
			System.out.println(e);
		}
		
		try {
			ce1.nuevoEspacio(es7);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
