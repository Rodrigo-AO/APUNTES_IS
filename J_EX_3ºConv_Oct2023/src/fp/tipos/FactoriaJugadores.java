package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaJugadores {
	
	public static Jugador parseaJugador(String lineaCSV) {
		String[] datos = lineaCSV.split(";");
		Checkers.check("Datos introducidos insuficientes/erroneos", datos.length == 9);
		String nombre = datos[0];
		String[] fecha = datos[1].split("-");
		LocalDate fechaDeNacimiento = LocalDate.of(Integer.valueOf(fecha[0]), Integer.valueOf(fecha[1]), Integer.valueOf(fecha[2]));
		Integer edad = LocalDate.from(fechaDeNacimiento).getYear();
		Posicion posicion = Posicion.valueOf(datos[2]);
		Integer goles = Integer.valueOf(datos[3]);
		Integer asistencias = Integer.valueOf(datos[4]);
		Equipo equipo = creaEquipo(datos[6], datos[7], datos[8]);
		List<String> lesiones = creaLista(datos[5]);
		Boolean campeon = equipo.clasificacion() == 1;
		return new Jugador(nombre, fechaDeNacimiento, edad, posicion, goles, asistencias, equipo, lesiones, campeon);
	}
	
	private static List<String> creaLista(String lista) {
		if(lista.equals("[]")) return new ArrayList<String>();
		String[] cadena = lista.split(",");
		cadena[0].replace("[", ""); cadena[cadena.length-1].replace("]", "");
		List<String> res = new ArrayList<String>();
		for(String dato: cadena) res.add(dato);
		return res;
	}

	private static Equipo creaEquipo(String nombre, String clasificacion, String estadio) {
		return new Equipo(nombre, Integer.valueOf(clasificacion), estadio);
	}
	
}
