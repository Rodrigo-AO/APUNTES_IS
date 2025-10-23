package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.List;
import fp.utiles.Ficheros;

public class FactoriaUniversidad {
	
	// --------------------------------------------------- Espacio --------------------------------------------------- \\
	/*
	public static List<Espacio> leeEspacios (String ficheroEspacios){
		List<Espacio> res = new ArrayList<Espacio>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ficheroEspacios));
			for (String linea: lineas) {
				res.add(creaEspacio(linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	*/
	public static List<Espacio> leeEspacios(String fichero) {
		List<String> datos = Ficheros.leeFichero("Error en la lectura del fichero", fichero);
		List<Espacio> res = new ArrayList<Espacio>();
		for(String dato: datos) {
			res.add(creaEspacio(dato));
		}
		return res;
	}
	
	private static Espacio creaEspacio(String linea) {
		return new Espacio(linea);
	}
	
	// --------------------------------------------------- Despacho --------------------------------------------------- \\
	/*
	public static List<Despacho> leeDespachos (String ficheroDespachos) {
		List<Despacho> res = new ArrayList<Despacho>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ficheroDespachos));
			for (String linea: lineas) {
				res.add(creaDespacho(linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	*/
	public static List<Despacho> leeDespachos(String fichero) {
		List<String> datos = Ficheros.leeFichero("Error en la lectura del fichero", fichero);
		List<Despacho> res = new ArrayList<Despacho>();
		for(String dato: datos) {
			res.add(creaDespacho(dato));
		}
		return res;
	}

	private static Despacho creaDespacho(String linea) {
		return new Despacho(linea);
	}
	
	// --------------------------------------------------- Alumno --------------------------------------------------- \\
		/*
		public static List<Alumno> leeAlumnos(String ficheroAlumnos) {
			List<Alumno> res = new ArrayList<Alumno>();
			try {
				List<String> lineas = Files.readAllLines(Paths.get(ficheroAlumnos));
				for (String linea: lineas) {
					res.add(creaAlumno(linea));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		*/

		public static List<Alumno> leeAlumnos(String fichero) {
			List<String> datos = Ficheros.leeFichero("Error en la lectura del fichero", fichero);
			if(!(datos.isEmpty())) {
				datos.remove(0);
			}
			List<Alumno> res = new ArrayList<Alumno>();
			for(String dato: datos) {
				res.add(creaAlumno(dato));
			}
			return res;
		}
		
		private static Alumno creaAlumno(String linea) {
			return new Alumno(linea);
		}
	
	// --------------------------------------------------- Asignatura --------------------------------------------------- \\
	/*
	public static List<Asignatura> leeAsignaturas(String ficheroAsignaturas) {
		List<Asignatura> res = new ArrayList<Asignatura>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ficheroAsignaturas));
			for (String linea: lineas) {
				res.add(creaAsignatura(linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	*/

	public static List<Asignatura> leeAsignaturas(String fichero) {
		List<String> datos = Ficheros.leeFichero("Error en la lectura del fichero", fichero);	
		List<Asignatura> res = new ArrayList<Asignatura>();
		for(String dato: datos) {
			res.add(creaAsignatura(dato));
		}
		return res;
	}
	
	private static Asignatura creaAsignatura(String linea) {
		return new Asignatura(linea);
	}
	
	// --------------------------------------------------- Nota --------------------------------------------------- \\
	/*
	public static List<Nota> leeNotas(String ficheroNotas) {
		List<Nota> res = new ArrayList<Nota> ();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ficheroNotas));
			for (String linea: lineas) {
				res.add(creaNota(linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	*/
	
	public static List<Nota> leeNotas(String fichero) {
		List<String> datos = Ficheros.leeFichero("Error en la lectura del fichero", fichero);
		List<Nota> res = new ArrayList<Nota>();
		for(String dato: datos) {
			res.add(creaNota(dato));
		}
		return res;
	}
	
	private static Nota creaNota(String linea) {
		return new Nota(linea);
	}
}
