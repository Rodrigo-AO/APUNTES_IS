package fp.universidad.tipos;

import java.util.Objects;

public record Asignatura (
		String nombre, String codigo, Double creditos, TipoAsignatura tipoAsignatura, Integer curso) implements Comparable<Asignatura>{
	
	// DONE: constructor, getters, toString, equals y hashCode
	// TODO: propiedades derivadas, restricciones y compareTo
	
	public Asignatura {
		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);
	}
	
	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public Asignatura(String datos) {
		this(validaDatos(datos));									// record asume que se llamara a un constructor privado de String[]
	}
	
	private static String[] validaDatos(String datos) {				// validamos y creamos el String[]
		String[] cadena = datos.split("#");
		if(cadena.length != 5) {
			throw new IllegalArgumentException("La cadena introducida no tiene los datos requeridos");
		}
		checkCodigo(cadena[1].trim());
		checkCreditos(Double.valueOf(cadena[2].trim()));
		checkCurso(Integer.valueOf(cadena[4].trim()));
		return cadena;
	}
	
	// Fundamentos de Programación#1234567#12.0#ANUAL#1
	private Asignatura(String[] cadena) {							// constructor privado con String[] que llama al canónico 
		this(cadena[0].trim(), cadena[1].trim(), Double.valueOf(cadena[2].trim()),
				TipoAsignatura.valueOf(cadena[3].trim()), Integer.valueOf(cadena[4].trim()));
	}

	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public String acronimo() {
		String res = "";
		for(int i=0; i < nombre().length(); i++) {
			if(Character.isUpperCase(nombre().charAt(i))) {
				res = res + nombre().charAt(i);
			}
		}
		return res;
	}
	
	private static void checkCodigo(String codigo) {
		if(codigo.length() != 7) {
			throw new IllegalArgumentException("El código ha de constar de 7 dígitos");
		}
		if(esCodigo(codigo)) {
			throw new IllegalArgumentException("El código ha de ser numérico");
		}
	}
	private static Boolean esCodigo(String codigo) {
		Boolean res = false;
		for(int i = 0; i<codigo.length(); i++) {
			if(!Character.isDigit(codigo.charAt(i))) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	private static void checkCreditos(Double creditos) {
		if(creditos <= 0) {
			throw new IllegalArgumentException("El número de creditos ha de ser mayor a 0");
		}
	}
	
	private static void checkCurso(Integer curso) {
		if(1 > curso || curso > 4) {
			throw new IllegalArgumentException("El curso se comprende del 1º al 4º año");
		}
	}

	@Override
	public String toString() {
		return "(" + codigo + ") " + nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(codigo(), other.codigo());
	}

	@Override
	public int compareTo(Asignatura a) {
		return codigo().compareTo(a.codigo());
	}
}
