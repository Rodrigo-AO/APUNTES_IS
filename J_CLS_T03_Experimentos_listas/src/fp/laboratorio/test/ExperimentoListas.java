package fp.laboratorio.test;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import fp.laboratorio.Estudiante;
import fp.laboratorio.EstudianteImpl;

public class ExperimentoListas {

	public static void main(String[] args) {

		Estudiante e1 = new EstudianteImpl("Ada", "Lovelace", "adalov");
		Estudiante e2 = new EstudianteImpl("Grace", "Murray", "gramur");
		Estudiante e3 = new EstudianteImpl("Frances", "Allen", "fraall");
		Estudiante e4 = new EstudianteImpl("Hedy", "Lamarr", "hedlam");
		Estudiante e5 = new EstudianteImpl("Radia", "Perlman", "ritper");
		Estudiante e6 = new EstudianteImpl("Margaret", "Hamilton", "marham");

		// Crea una lista vacía de estudiantes
		List<Estudiante> lista = new ArrayList<>();
			// List<TipoIntroducible> = new ArrayList<>(); crea una lista a partir del constructor por defecto (sin parámetros)
			// List<TipoIntroducible> = new LinkedList<>(); es otra forma
		
		// Añade 5 estudiantes (e1-e5) a la lista
		lista.add(e1);
		lista.add(e2);
		lista.add(e3);
		lista.add(e4);
		lista.add(e5);
		
		// Visualiza el nmero de estudiantes que tiene la lista
			System.out.println("Numero de estuddiantes: " + lista.size());
		
		// Visualiza los estudiantes de las posiciones 0, 1 y 5.
			System.out.println("1º estudiante en la lista: "+ lista.get(0));
			System.out.println("2º estudiante en la lista: "+ lista.get(1));
		try {
			System.out.println("6º estudiante en la lista: "+ lista.get(5));	// error por fuera de limites
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excepción capturada: " + e.getMessage());;
		}
		
		// Visualiza, de los estudiantes 2 y 4 solo su uvus.
			System.out.println("UVUS 2º estudiante: " + lista.get(1).getUVUS());
			System.out.println("UVUS 4º estudiante: " + lista.get(3).getUVUS());
		
		// Inserta el estudiante e6 como tercer estudiante de la lista
			lista.add(2, e6);
			for(Estudiante i : lista) {		// i se vuelve un objeto tipo lista que va almacenando 1 a 1 los estudiantes de la lista
				System.out.println("\t>>>" + i);		// \t sitve para tabular los syso
			}
		
		// Busca la posición de la estudiante que se llama Frances Allen.
			Integer indx = lista.indexOf("Frances Allen");
			System.out.println("La posición en la lista de Frances Allen es: " + indx);
			// Da -1 dado que esta buscando un tipo String en un tipo Estudiante
			indx = buscarIndiceEstudiante(lista, "Frances", "Allen");
			System.out.println("La posición en la lista de Frances Allen es: " + indx);
		
		// Obten una sublista con los estudiantes de la posici�n 1 a la 4.
			List<Estudiante> sublista = lista.subList(1, 5); 		// si pongo del 1 l 4, el 4 no lo incluye
		
		// Visualiza ambas listas
			System.out.println(lista);
			// Para no repetir el for, creamos un método que nos imprima las listas igual que hicimos antes
			System.out.println(lista);
			mostrarLista(lista);
			System.out.println(sublista);
			mostrarLista(sublista);
		
		// Elimina de la sublista el segundo estudiante (�ndice 1).
			sublista.remove(1);
		
		// Muestra ambas listas.
			System.out.println(lista);
			mostrarLista(lista);
			System.out.println(sublista);
			mostrarLista(sublista);
		
		// Muestras ambas listas, pero haciendo que haya un estudiante por línea.
			System.out.println(lista);
			mostrarLista(lista);
			System.out.println(sublista);
			mostrarLista(sublista);
		
	}

	private static void mostrarLista(List<Estudiante> lista) {
		for(Estudiante e: lista) {
			System.out.println("\t>>>" + e);
		}
	}

	private static Integer buscarIndiceEstudiante(List<Estudiante> lista, String Nombre, String Apellidos) {
		// Esquema de búsqueda de índice
		Integer res = -1;		// Si no está se queda en -1
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(Nombre)
				&&													// usamos equals para que compare contenido, == compara clases
				lista.get(i).getApellidos().equals(Apellidos)) {
					res = i;
					break;
			}
		}
		return res;
	}

	private static void mostrarIterable(Iterable<Estudiante> lista) {
		for (Estudiante e : lista) {
			System.out.println(e);
		}
	}

	public static Integer buscarEstudiantePorNombreyApellidos(List<Estudiante> lista, String nombre, String apellidos) {
		int pos = -1;
		for (int i = 0; i < lista.size(); i++) {
			Estudiante e = lista.get(i);
			if (e.getNombre().equals(nombre) && e.getApellidos().equals(apellidos)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

}
