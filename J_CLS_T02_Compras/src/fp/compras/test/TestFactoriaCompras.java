package fp.compras.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.compras.Compra;
import fp.compras.FactoriaCompras;

public class TestFactoriaCompras {

	public static void main(String[] args) {
		
//		LocalDateTime fechaLlegada = LocalDateTime.parse("01/01/2019 06:19",
//				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//		System.out.println(fechaLlegada);
		List<Compra> compras = FactoriaCompras.leeCompras("./data/compras.csv");
		System.out.println("Se han leido " + compras.size() + " datos de compras");
		for (Compra c : compras) {
			System.out.println(c);
		}
	}

}
