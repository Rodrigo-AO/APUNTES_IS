package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaVinos {
	
	public static Vino parsearVino(String linea) {
		String[] datos = linea.split(",");
		Checkers.check("Los datos son inválidos", datos.length == 5);
		String pais = String.valueOf(datos[0].trim());
		String region = String.valueOf(datos[1].trim());
		Integer puntos = Integer.valueOf(datos[2].trim());
		Double precio = Double.valueOf(datos[3].trim());
		String uva = String.valueOf(datos[4].trim());
		return new Vino(pais, region, puntos, precio, uva);
	}
	
	public static Vinoteca leerVinoteca(String ruta) {
		Vinoteca res = new VinotecaStream();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(ruta));
			lineas.remove(0);
			for(String linea: lineas) {
				res.agregarVino(parsearVino(linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
