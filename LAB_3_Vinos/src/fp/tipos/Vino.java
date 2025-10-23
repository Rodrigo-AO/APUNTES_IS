package fp.tipos;

import fp.utiles.Checkers;

public record Vino(String pais, String region, Integer puntos, Double precio, String uva) {
	
	public Vino {
		Checkers.check("Puntos ha de estar entre 0 y 100", puntos>=0 && 100>=puntos);
		Checkers.check("El precio del vino ha de ser mayor a 0", precio>0);
	}

	public Double calidadPrecio() {
		return puntos()/precio();
	}
	
	@Override
	public String toString() {
		return pais() + ", " + region() + ", " + puntos() + ", " + precio() + ", " + uva() + ", " + calidadPrecio();
	}
	
}
