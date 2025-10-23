package fp.figuras.test;

import fp.figuras.*;
public class TestFigurasSegundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuadrado c1 = new CuadradoImpl();
		c1.cambiarColor("red");
		c1.moverHorizontalmente(-80);
		c1.hacerVisible();
		
		Cuadrado c2 = new CuadradoImpl();
		c2.cambiarColor("red");
		c2.moverHorizontalmente(-80);
		c2.hacerVisible();
		c2.moverVerticalmenteDespacio(60);
		Cuadrado c22 = new CuadradoImpl();
		c22.cambiarColor("red");
		c22.moverHorizontalmente(-80);
		c22.hacerVisible();
		c22.moverVerticalmenteDespacio(120);
		Cuadrado c222 = new CuadradoImpl();
		c222.cambiarColor("red");
		c222.moverHorizontalmente(-80);
		c222.hacerVisible();
		c222.moverVerticalmenteDespacio(120);
		c222.moverHorizontalmenteDespacio(-60);
		
		Cuadrado c3 = new CuadradoImpl();
		c3.cambiarColor("red");
		c3.moverHorizontalmente(-80);
		c3.hacerVisible();
		c3.moverVerticalmenteDespacio(-60);
		Cuadrado c33 = new CuadradoImpl();
		c33.cambiarColor("red");
		c33.moverHorizontalmente(-80);
		c33.hacerVisible();
		c33.moverVerticalmenteDespacio(-120);
		Cuadrado c333 = new CuadradoImpl();
		c333.cambiarColor("red");
		c333.moverHorizontalmente(-80);
		c333.hacerVisible();
		c333.moverVerticalmenteDespacio(-120);
		c333.moverHorizontalmenteDespacio(60);
		
		Cuadrado c4 = new CuadradoImpl();
		c4.cambiarColor("red");
		c4.moverHorizontalmente(-80);
		c4.hacerVisible();
		c4.moverHorizontalmenteDespacio(60);
		Cuadrado c44 = new CuadradoImpl();
		c44.cambiarColor("red");
		c44.moverHorizontalmente(-80);
		c44.hacerVisible();
		c44.moverHorizontalmenteDespacio(120);
		Cuadrado c444 = new CuadradoImpl();
		c444.cambiarColor("red");
		c444.moverHorizontalmente(-80);
		c444.hacerVisible();
		c444.moverHorizontalmenteDespacio(120);
		c444.moverVerticalmenteDespacio(60);
		
		Cuadrado c5 = new CuadradoImpl();
		c5.cambiarColor("red");
		c5.moverHorizontalmente(-80);
		c5.hacerVisible();
		c5.moverHorizontalmenteDespacio(-60);
		Cuadrado c55 = new CuadradoImpl();
		c55.cambiarColor("red");
		c55.moverHorizontalmente(-80);
		c55.hacerVisible();
		c55.moverHorizontalmenteDespacio(-120);
		Cuadrado c555 = new CuadradoImpl();
		c555.cambiarColor("red");
		c555.moverHorizontalmente(-80);
		c555.hacerVisible();
		c555.moverHorizontalmenteDespacio(-120);
		c555.moverVerticalmenteDespacio(-60);
		
	}

}
