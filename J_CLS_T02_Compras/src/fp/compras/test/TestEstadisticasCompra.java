package fp.compras.test;



import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import fp.compras.Compra;
import fp.compras.EstadisticasCompra;
import fp.compras.FactoriaCompras;

public class TestEstadisticasCompra {

	public static void testCompraMaximaMinimaProvincia(EstadisticasCompra e, String provincia) {
		System.out.println("Las compras máximas y minimas de " + provincia + " son:");
		System.out.println(e.compraMaximaMinimaProvincia(provincia));
	}
	
	public static void testHoraMenosAfluencia(EstadisticasCompra e) {
		System.out.println("La hora de menos afluencia es: " + e.horaMenosAfluencia());
	}
	
	public static void testSupermercadosMasFacturacion(EstadisticasCompra e, Integer n) {
		System.out.println("Los supermercados de más facturación son: ");
		System.out.println(e.supermercadosMasFacturacion(n));
		
	}	
	
	public static void testClientesItinerantes (EstadisticasCompra e, Integer n) {
		System.out.println("Los clientes itinerantes con más de " + n + "provincias son");
		Map<String, List<String>> res = e.clientesItinerantes(n);
		res.entrySet().stream()
			.forEach(System.out::println);
	}
	
	public static void testDiasEstrella(EstadisticasCompra e, String supermercado, String provincia) {
		String msg = String.format("Los días estrella para el supermerado %s de la provincia %s son", supermercado, provincia);
		System.out.println(msg);
		List<LocalDate> res = e.diasEstrella(supermercado, provincia);
		System.out.println(res);
	}
	public static void main (String [] args) {
		
		
		List<Compra> compras = FactoriaCompras.leeCompras("./data/compras.csv");
		EstadisticasCompra e = new EstadisticasCompra(compras);
		
		testCompraMaximaMinimaProvincia(e, "Sevilla");
		
		testHoraMenosAfluencia(e);
		
		testSupermercadosMasFacturacion(e, 5);
	
		testClientesItinerantes(e, 7);
		
		testDiasEstrella(e, "Aldi", "Huelva");
	}


}
