package fp.figuras.test;

import fp.figuras.*;
public class TestFiguras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circulo c1 = new CirculoImpl(); // Genera el circulo por defecto
		// Interfaz(tipo obj) nombre = new Clase(obj)
		
		c1.hacerVisible();
		c1.moverArriba();
		c1.moverVerticalmenteDespacio(-50);
		
		Triangulo t1 = new TrianguloImpl();
		
		t1.hacerVisible();
		t1.moverArriba();
		t1.moverVerticalmenteDespacio(50);
		t1.moverVerticalmenteDespacio(-50);
		
		
		Triangulo t2 = new TrianguloImpl2();
		
		t2.hacerVisible();
		t2.cambiarColor("yellow");
		t2.moverHorizontalmenteDespacio(80);
		
		Cuadrado cuad1 = new CuadradoImpl();
		cuad1.hacerVisible();
		cuad1.moverAbajo();
		cuad1.moverAbajo();
		cuad1.moverAbajo();
		
		Monigote m = new MonigoteImpl();
		m.hacerVisible();
		
	}

}
