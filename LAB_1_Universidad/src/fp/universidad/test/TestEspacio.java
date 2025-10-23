package fp.universidad.test;

import fp.universidad.tipos.*;

public class TestEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Espacio es1 = new Espacio(TipoEspacio.OTRO, "A3.10", 3, 193);
		System.out.println(es1);
		System.out.println(es1.getPlanta());
		System.out.println(es1.getCapacidad());
		
		try {
			Espacio es2 = new Espacio(TipoEspacio.OTRO, "A3.10", 3, -1);
			System.out.println(es2);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepcion capturada: " + e.getMessage());
		}
	}
}
