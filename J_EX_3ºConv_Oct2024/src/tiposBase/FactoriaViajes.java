package tiposBase;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import utiles.Checkers;

public class FactoriaViajes {
	
	public static Viaje parseaViaje(String linea) {
		String[] cadena = linea.split(";");
		Checkers.check("La cadena no cumple con el formato requerido", cadena.length == 5);
		String[] tiempo = cadena[2].split(":");
		Duration duracion = stringADuration(tiempo);
		String paradasStr = cadena[4].substring(1, cadena[4].length() - 1);
		String[] listaSt = paradasStr.split(",");
		List<Parada> lista = stringAListParada(listaSt);
		return new Viaje(Double.valueOf(cadena[0]),
				Integer.valueOf(cadena[1]),
				duracion,
				TipoViaje.valueOf(cadena[3]),
				lista);
	}
	
	private static Duration stringADuration(String[] string) {
		return Duration.ofMinutes((int) Integer.valueOf(string[0])*60 + Integer.valueOf(string[1]));
	}
	
	private static List<Parada> stringAListParada(String[] cadena) {
		List<Parada> lista = new LinkedList<Parada>();
		cadena[0].replace("[", "");
		cadena[cadena.length-1].replace("]", "");
		for(String text: cadena) {
			String[] datos = text.split("-");
			String[] tiempo = datos[1].split(":");
			if(!(datos[1].equals("FIN"))) {
				lista.add(new Parada(datos[0], LocalTime.of(Integer.valueOf(tiempo[0]), Integer.valueOf(tiempo[1]))));
			}
		}
		return lista;
	}
	
}
