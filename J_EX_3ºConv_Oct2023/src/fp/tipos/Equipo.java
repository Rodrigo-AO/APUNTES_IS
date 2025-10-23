package fp.tipos;

import fp.utiles.Checkers;

public record Equipo(String nombre, Integer clasificacion, String estadio) {
	
	// C1 creado por record
	public Equipo {
		Checkers.check("La posición en la clasificación debe estar comprendida entre 1 y 20", 0 < clasificacion && clasificacion < 21);
		Checkers.check("La propiedad estadio debe comenzar por la cadena “Estadio”", estadio.startsWith("Estadio"));
	}
	
}
