package tiposTest;

import tiposBase.Viaje;

import java.util.HashMap;
import java.util.Map;

import tiposBase.FactoriaViajes;

public class TestFactoriaViajes {

	public static void main(String[] args) {
		Viaje viaje = FactoriaViajes.parseaViaje("14.99;507;7:20;Transbordo;[Sevilla-09:00, Huelva-10:10, Faro-11:20, Faro-11:30,Aeropuerto Faro-12:30, Albufeira-13:40,Albufeira-14:00, Lisboa-FIN]");
		System.out.println(viaje);
		
		
		Map<String, Integer> cantidadPorLugar = new HashMap<String, Integer>();
		cantidadPorLugar.put("TIENDA", 2000);
		cantidadPorLugar.put("ONLINE", 2000);
		cantidadPorLugar.put("OTRO", 1500);
		System.out.println(cantidadPorLugar.entrySet());
		System.out.println(cantidadPorLugar.size());
		System.out.println(cantidadPorLugar.values());
	}

}
