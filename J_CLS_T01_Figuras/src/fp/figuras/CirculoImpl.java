package fp.figuras;

import java.awt.geom.*;

/**
 * Un c�rculo que puede se ser manipulado y dibujarse en un canvas.
 * @author Adaptado por To�i Reina para FP de l c�digo de
 *    Michael K�lling and David J. Barnes
 * @version 1.0.0
 */

public class CirculoImpl implements Circulo {
	private Integer diametro;
	private Integer xPosition;
	private Integer yPosition;
	private String color;
	private Boolean esVisible;

	/**
	 * Create a new circle at default position with default color.
	 */
	public CirculoImpl() {
		diametro = 68;
		xPosition = 230;
		yPosition = 90;
		color = "blue";
		esVisible=false;
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
		moverVerticalmente(-20);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fp.figuras.Figura#moverVerticalmenteDespacio(java.lang.Integer)
	 */
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
	 * @see fp.figuras.Circulo#cambiarTamanyo(java.lang.Integer)
	 */
	public void cambiarTamanyo(Integer nuevoDiametro) {
		borrar();
		diametro = nuevoDiametro;
		dibujar();
	}


	/* (non-Javadoc)
	 * @see fp.figuras.Figura#cambiarColor(java.lang.String)
	 */
	public void cambiarColor(String nuevoColor) {
		color = nuevoColor;
		dibujar();
	}


	/**
	 * Dibujar el circulo en la pantalla
	 */
	private void dibujar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.dibujar(this, color, new Ellipse2D.Double(xPosition, yPosition, diametro, diametro));
			canvas.esperar(10);			
		}
	}

	/**
	 * Eliminar el circulo de la pantalla
	 */
	private void borrar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.borrar(this);
		}
	}
}
