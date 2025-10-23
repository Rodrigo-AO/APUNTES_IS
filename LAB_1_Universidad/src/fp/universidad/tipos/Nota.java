package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Nota(
		Asignatura asignatura, Integer añoComienzo, TipoConvocatoria convocatoria,
		Double valorNumerico, Boolean mencionHonor) {
	
	// DONE: constructor, toString, getters, equals, hashCode
	// TODO: constructor 2, clases derivadas, compareTo, checkers
	
	public Nota {
		checkValorNumerico(valorNumerico);
		Checkers.check("La nota ha de estar entre 0 y 10", valorNumerico >= 0 && valorNumerico <= 10);
		checkMencionHonor(mencionHonor, valorNumerico);
		// Checkers.check("No puede haber meción de honor con una nota inferior a 9", );
	}
	
	public Nota(Asignatura asignatura, Integer añoComienzo,
			TipoConvocatoria convocatoria, Double valorNumerico) {
		this(asignatura, añoComienzo, convocatoria, valorNumerico, false);
	}
	
	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public Nota(String datos) {
		this(validaDatos(datos));
	}
	
	private Nota(String[] cadena) {
		this(new Asignatura(cadena[0].trim()), Integer.valueOf(cadena[1].trim()), TipoConvocatoria.valueOf(cadena[2].trim()),
				Double.valueOf(cadena[3].trim()), Boolean.valueOf(cadena[4].trim()));
	}
	
	private static String[] validaDatos(String datos) {
		String[] cadena = datos.split(",");
		if(cadena.length != 5) {
			throw new IllegalArgumentException("La cadena introducida no tiene los datos requeridos");
		}
		checkValorNumerico(Double.valueOf(cadena[3].trim()));
		checkMencionHonor(Boolean.valueOf(cadena[4].trim()), Double.valueOf(cadena[3].trim()));
		return cadena;
	}

	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	private static void checkValorNumerico(Double valorNumerico) {
		if(0 > valorNumerico || valorNumerico > 10) {
			throw new IllegalArgumentException("La nota debe de estar entre 0 y 10");
		}
	}
	private static void checkMencionHonor(boolean mencionHonor, Double valorNumerico) {
		if(mencionHonor == true && valorNumerico < 9) {
			throw new IllegalArgumentException("No puede haber meción de honor con una nota inferior a 9");
		}
	}
	
	public String getCursoAcademico() {
		String añoActual = String.valueOf(añoComienzo);
		String añoProximo = String.valueOf(añoComienzo + 1);
		return añoActual + "-" + añoProximo.substring(2);
	}
	
	public TipoCalificacion getCalificacion() {
		TipoCalificacion respuesta = null;
		if(valorNumerico >= 0 && valorNumerico < 5) respuesta = TipoCalificacion.SUSPENSO;
		if(valorNumerico >= 5 && valorNumerico < 7) respuesta = TipoCalificacion.APROBADO;
		if(valorNumerico >= 7 && valorNumerico < 9) respuesta = TipoCalificacion.NOTABLE;
		if(valorNumerico >= 9 && mencionHonor == false) respuesta = TipoCalificacion.SOBRESALIENTE;
		if(valorNumerico >= 9 && mencionHonor == true) respuesta = TipoCalificacion.MATRICULA_HONOR;
		return respuesta;
	}

	@Override
	public String toString() {
		return asignatura + ", " + getCursoAcademico() + ", " + convocatoria + ", " +
				valorNumerico + ", " + getCalificacion();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Nota other = (Nota) obj;
		return Objects.equals(getCursoAcademico(), other.getCursoAcademico())
				&&
				Objects.equals(asignatura(), other.asignatura())
				&&
				Objects.equals(convocatoria(), other.convocatoria());
	}
	
	public int compareTo(Nota not) {
		int res = getCursoAcademico().compareTo(getCursoAcademico());
		if(res == 0) {
			res = asignatura().compareTo(asignatura());
			if(res == 0) {
				res = convocatoria().compareTo(convocatoria());
			}
		}
		return res;
	}
}
