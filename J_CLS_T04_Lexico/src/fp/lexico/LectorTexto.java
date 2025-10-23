package fp.lexico;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import fp.utiles.Checkers;
import fp.utiles.MatcherStream;
import fp.utiles.Ficheros;

/**
 * @author Toñi Reina
 *
 */
public class LectorTexto {
	private List<String> palabras;

	private static final String LETTER = "[@+\\p{javaLetter}\\p{javaDigit}]";
	private static final String JOINER = "[-.:/''\\p{M}\\u2032\\u00A0\\u200C\\u200D~]";
	private static final Charset ENCODING = StandardCharsets.ISO_8859_1;
	/*
	 * A word is: one or more "letters" followed by zero or more sections of one or
	 * more "joiners" followed by one or more "letters"
	 */
	private static final Pattern WORD = Pattern.compile(LETTER + "+(" + JOINER + "+" + LETTER + "+)*");

	public LectorTexto() {
		this.palabras = new ArrayList<>();

	}

	public LectorTexto(String texto) {
		this();
		agregaMensaje(texto);
	}

	/**
	 * @param fichero Nombre de fichero con palabras huecas. 
	 * El fichero debe contener una palabra por l�nea.
	 */
	public void  agregaFichero(String fichero){
		agregaFichero(fichero);
	}

	public void  agregaFichero(String fichero, Charset encoding){
		Checkers.checkNoNull(fichero);
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", 
				fichero, encoding);
		for (String linea: lineas) {
			this.agregaMensaje(linea);
		}
	}
	public void agregaMensaje(String texto) {
		Checkers.checkNoNull(texto);
		List<String> pals = MatcherStream.find(WORD, texto)
				                         .collect(Collectors.toList());
		this.palabras.addAll(pals);
	}

	/**
	 * @return Lista de todas las palabras extraidas del texto
	 */
	public List<String> getPalabras() {
		return new ArrayList<String>(palabras);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palabras == null) ? 0 : palabras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LectorTexto))
			return false;
		LectorTexto other = (LectorTexto) obj;
		if (palabras == null) {
			if (other.palabras != null)
				return false;
		} else if (!palabras.equals(other.palabras))
			return false;
		return true;
	}

	public String toString() {
		return "LectorTexto [getPalabras()=" + getPalabras() + "]";
	}
	
}
