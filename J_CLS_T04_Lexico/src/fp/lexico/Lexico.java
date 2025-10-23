package fp.lexico;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lexico {
	
	private SortedSet<String> palabras;
	
	public Lexico() {
		this.palabras = new TreeSet<String> ();
	}
	
	public Lexico(Collection<String> palabras) {
		this.palabras = new TreeSet<String> ();
		agregarPalabras(palabras);
	}

	public void agregarPalabras(Collection<String> palabras) {
		for(String palabra: palabras) {
			agragarPalabra(palabra);
		}
	}
	
	public void agragarPalabra(String palabra) {
		palabras.add(palabra.toLowerCase());
	}
	
	public SortedSet<String> getPalabras() {
		return new TreeSet<String>(palabras);		// Devuelve una copia de la lista original
	}
	
	public Integer getTotalPalabras() {
		return palabras.size();
	}
	
	public Set<String> getPalabrasComunes(Lexico lexico){
		Set<String> comunes = getPalabras();
		comunes.retainAll(lexico.getPalabras());
		return comunes;
	}
	
	public Set<String> getTodasComunes(Lexico lexico){
		Set<String> comunes = getPalabras();
		comunes.addAll(lexico.getPalabras());
		return comunes;
	}
	
	public Set<String> getDiferenciaPalabras(Lexico lexico){
		Set<String> resta = getPalabras();
		resta.removeAll(lexico.getPalabras());
		return resta;
	}
}