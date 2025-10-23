package fp.universidad.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.TipoConvocatoria;

public class TestExpediente {

	public static void main(String[] args) {
		
		Asignatura as1 = new Asignatura("FP", "1234567", 12., TipoAsignatura.ANUAL, 1);
		Asignatura as2 = new Asignatura("AE", "1243567", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura as3 = new Asignatura("EdC", "1234657", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		
		Nota no1 = new Nota(as1, 2024, TipoConvocatoria.PRIMERA, 3.);
		Nota no2 = new Nota(as1, 2024, TipoConvocatoria.PRIMERA, 7.);
		Nota no3 = new Nota(as2, 2024, TipoConvocatoria.PRIMERA, 5.);
		Nota no4 = new Nota(as3, 2024, TipoConvocatoria.PRIMERA, 8.);
		
		Expediente exp1 = new Expediente();
		exp1.nuevaNota(no1);
		exp1.nuevaNota(no2);
		exp1.nuevaNota(no3);
		exp1.nuevaNota(no4);
		
		System.out.println(exp1.getNotaMedia());
		System.out.println(exp1.getNotaMaxima());
		System.out.println(exp1.getNotaMaxima(as1));
		System.out.println(exp1.getNotas());
		System.out.println(exp1);
	}

}
