package fp.figuras;

import java.awt.Polygon;



/**
 * Un triángulo que puede se ser manipulado y dibujarse en un canvas.
 * Esta es una implementación en la que se usan atributos definidos
 * con tipos básicos
 * 
 * @author Adaptado por Toñi Reina para FP del código de Michael Kölling y
 *         David J. Barnes
 * @version 1.0.0
 */

public class TrianguloImpl2 implements Triangulo {
	private int altura;
	private int anchura;
	private int xPosition;
	private int yPosition;
	private String color;
	private boolean esVisible;

	/**
	 * Crea un nuevo triángulo en una posición por defecto y con un color por
	 * defecto.
	 */
	public TrianguloImpl2() {
		altura = 60;
		anchura = 70;
		xPosition = 210;
		yPosition = 140;
		color = "green";
		esVisible = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#hacerVisible()
	 */
	public void hacerVisible() {
		esVisible = true;
		dibujar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#hacerInvisible()
	 */
	public void hacerInvisible() {
		borrar();
		esVisible = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverDerecha()
	 */
	public void moverDerecha() {

		moverHorizontalmente(20);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverIzquierda()
	 */
	public void moverIzquierda() {
		moverHorizontalmente(-20);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverArriba()
	 */
	public void moverArriba() {
		moverVerticalmente(-20);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverAbajo()
	 */
	public void moverAbajo() {
		moverVerticalmente(20);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverHorizontalmente(java.lang.Integer)
	 */
	public void moverHorizontalmente(Integer distancia) {
		borrar();
		xPosition += distancia;
		dibujar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverVerticalmente(java.lang.Integer)
	 */
	public void moverVerticalmente(Integer distancia) {
		borrar();
		yPosition += distancia;
		dibujar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverHorizontalmenteDespacio(java.lang.Integer)
	 */
	public void moverHorizontalmenteDespacio(Integer distancia) {
		Integer delta;

		if (distancia < 0) {
			delta = -1;
			distancia = -distancia;
		} else {
			delta = 1;
		}

		for (int i = 0; i < distancia; i++) {
			xPosition += delta;
			dibujar();
		}
	}

	public void moverVerticalmenteDespacio(Integer distancia) {
		Integer delta;

		if (distancia < 0) {
			delta = -1;
			distancia = -distancia;
		} else {
			delta = 1;
		}

		for (int i = 0; i < distancia; i++) {
			yPosition += delta;
			dibujar();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Triangulo#cambiarTamanyo(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public void cambiarTamanyo(Integer nuevaAltura, Integer nuevaAnchura) {
		borrar();
		altura = nuevaAltura;
		anchura = nuevaAnchura;
		dibujar();

	}

	public void cambiarColor(String nuevoColor) {
		color = nuevoColor;
		dibujar();
	}


	/**
	 * Dibuja el triángulo con las especificaciones actuales en el canvas.
	 */
	private void dibujar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			int[] xpoints = { xPosition, xPosition + (anchura / 2), xPosition - (anchura / 2) };
			int[] ypoints = { yPosition, yPosition + altura, yPosition + altura };
			canvas.dibujar(this, color, new Polygon(xpoints, ypoints, 3));
			canvas.esperar(10);
		}
	}

	/**
	 * Borra el triángulo del canvas
	 */
	private void borrar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.borrar(this);
		}
	}
}
