package fp.universidad.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Profesor;

public class TestDespacho {

	public static void main(String[] args) {
		
		Despacho de1 = new Despacho("A2.32", 2,  89);
		Profesor pro1 = new Profesor("28864657W", "Pascual", "García Verrero", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Profesor pro2 = new Profesor("28876657W", "Juan", "García Verrero", LocalDate.of(1998,  9, 15), "Juan.garcia@example.com", Categoria.TITULAR);
		Profesor pro4 = new Profesor("28848657W", "Ruben", "Santiago Derrapante", LocalDate.of(1998,  9, 15), "pascual.garcia@example.com", Categoria.TITULAR);
		Set<Profesor> profesores = new HashSet<Profesor>(Set.of(pro1, pro2, pro4));
		de1.setProfesores(profesores);
		System.out.println(de1);
		System.out.println(de1.getCapacidad());
		System.out.println(de1.getPlanta());
		System.out.println(de1.getTipoEspacio());
		
	}

}
