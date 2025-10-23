package fp.test;

import fp.tipos.EstudioPedidos;
import fp.tipos.FactoriaEstudioPedidos;

public class TestFactoriaEstudioPedidos {

	public static void main(String[] args) {
		
		EstudioPedidos lecestped = FactoriaEstudioPedidos.leerEstudioPedidos("./data/DatosEjercicioJava.csv");
		System.out.println(lecestped);
	}

}
