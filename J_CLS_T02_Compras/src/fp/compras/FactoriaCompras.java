package fp.compras;

import fp.compras.utiles.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class FactoriaCompras {
	
	private static Compra parsearCompra(String lineaCSV) {
		Compra res = null;
		Checkers.checkNoNull(lineaCSV);
		String [] trozos = lineaCSV.split(",");
		String msg=String.format("Formato Compra no v�lida <%s>", lineaCSV);
		Checkers.check(msg, trozos.length==6);
		
		String dni = trozos[0].trim();
		String supermercado = trozos[1].trim();
		String provincia = trozos[2].trim();
		LocalDateTime fechaLlegada = LocalDateTime.parse(trozos[3].trim(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) ;
		LocalDateTime fechaSalida = LocalDateTime.parse(trozos[4].trim(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) ;
		Double totalCompras = Double.valueOf(trozos[5].trim());
		
		res= new Compra(dni, supermercado, provincia, fechaLlegada, fechaSalida,totalCompras);
		return res;
	}
	
	
	public static List<Compra> leeCompras(String fichero){
		Checkers.checkNoNull(fichero);
		String errMsg = String.format("Error leyendo fichero <%s>", fichero);
		List<String> lineas = Ficheros.leeFichero(errMsg, fichero, StandardCharsets.UTF_8);
		
		List<Compra> res = lineas.stream()
						.skip(1)
						.map(linea->parsearCompra(linea))
						.collect(Collectors.toList());
		return res;
		
	}

}
