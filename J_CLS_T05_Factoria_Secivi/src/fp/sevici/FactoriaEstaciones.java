package fp.sevici;

import java.security.DrbgParameters.NextBytes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.utiles.Ficheros;

public class FactoriaEstaciones {
	
	public static RedEstaciones leerRedEstaciones(String nombreFichero, String nombreRed) {
		List<String> lineas = Ficheros.leeFichero("Error al leer", nombreFichero);
		lineas.remove(0);
		
		Set<Estacion> estacionesLeidas = new HashSet<Estacion>();
		
		for(String linea: lineas) {
			estacionesLeidas.add(parsearEstacion(linea));
		}
		
		return new RedEstaciones(nombreRed, estacionesLeidas);
	}

	public static Estacion parsearEstacion(String lineaCSV) {
		String[] trozos = lineaCSV.split(",");
		String[] trozo1 = trozos[0].trim().split("_");
		String id = trozo1[0].trim();
		String nombre = trozo1[1].trim();
		return null;
	}
	
}
