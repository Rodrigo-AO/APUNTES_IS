package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import fp.utiles.Checkers;

public class FactoriaEstudioPedidos {
	
	public static EstudioPedidos leerEstudioPedidos(String rutaFichero) {
		Checkers.checkNoNull(rutaFichero);
		Set<Pedido> res = new HashSet<Pedido>();
		List<String> lineas = new LinkedList<String>();
		try {
			//List<String> lines = Files.readAllLines(Paths.get(rutaFichero));
			//for(String l: lines) {
			//	lineas.add(l);
			//}
			lineas = Files.readAllLines(Paths.get(rutaFichero));
		} catch (IOException e) {
			System.out.println("Excepción capturada: error de lectura (" + e +")");
		}
		lineas.remove(0);
		for(String l: lineas) {
			Pedido pe = parseaPedido(l);
			res.add(pe);
		}
		return new EstudioPedidos(res);
	}

	public static Pedido parseaPedido(String linea) {
		String[] datos = linea.split(";");
		Checkers.check("Cantidad de datos erronea", datos.length == 9);
		String[] fechaS = datos[0].split("/");
		LocalDate fecha = LocalDate.of(Integer.valueOf(fechaS[2]), Integer.valueOf(fechaS[1]), Integer.valueOf(fechaS[0]));
		String usuario = datos[1];
		String pais = datos[2];
		String ciudad = datos[3];
		Envio envio = Envio.valueOf(datos[4]);
		Set<String> categorias = setDeString(datos[5]);
		String producto = datos[6];
		Double precioUnitario = stringADouble(datos[7]);
		Integer unidadesCompradas = Integer.valueOf(8);
		return new Pedido(fecha, usuario, pais, ciudad, envio, categorias, producto, precioUnitario, unidadesCompradas);
	}

	private static Set<String> setDeString(String categoriasS) {
		Set<String> res = new HashSet<String>();
		String[] categoriasStr = categoriasS.split("and");
		for(String categoria: categoriasStr) {
			res.add(categoria.trim());
		}
		return res;
	}
	
	private static Double stringADouble(String string) {
		String valor = string;
		if(string.contains("$")) {
			valor = string.substring(1, string.length());
		}
		return Double.valueOf(valor);
	}
}
