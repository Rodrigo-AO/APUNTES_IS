package fp.figuras;

import java.awt.*;

/**
 * Un monigote que puede se ser manipulado y dibujarse en un canvas.
 * 
 * @author Adaptado por Toñi Reina para FP de l código de Michael Kölling and
 *         David J. Barnes
 * @version 1.0.0
 */

public class MonigoteImpl implements Monigote {
	private Integer altura;
	private Integer anchura;
	private Integer xPosition;
	private Integer yPosition;
	private String color;
	private Boolean esVisible;

	/**
	 * Crea un nuevo monigote en una posición por defecto y de un tamaño colores por
	 * defecto.
	 */
	public MonigoteImpl() {
		altura = 60;
		anchura = 30;
		xPosition = 280;
		yPosition = 190;
		color = "black";
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
	 * @see fp.figuras.Monigote#cambiarTamanyo(java.lang.Integer, java.lang.Integer)
	 */
	public void cambiarTamanyo(Integer nuevaAltura, Integer nuevaAnchura) {
		borrar();
		altura = nuevaAltura;
		anchura = nuevaAnchura;
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
	 * Draw the person with current specifications on screen.
	 */
	private void dibujar() {
		Integer bh = (int) (altura * 0.7); // body height
		Integer hh = (altura - bh) / 2; // half head height
		Integer hw = anchura / 2; // half width
		Integer x = xPosition;
		Integer y = yPosition;
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			int[] xpoints = { x - 3, x - hw, x - hw, x - (int) (hw * 0.2) - 1, x - (int) (hw * 0.2) - 1, x - hw,
					x - hw + (int) (hw * 0.4) + 1, x, x + hw - (int) (hw * 0.4) - 1, x + hw, x + (int) (hw * 0.2) + 1,
					x + (int) (hw * 0.2) + 1, x + hw, x + hw, x + 3, x + (int) (hw * 0.6), x + (int) (hw * 0.6), x + 3,
					x - 3, x - (int) (hw * 0.6), x - (int) (hw * 0.6) };
			int[] ypoints = { y, y + (int) (bh * 0.2), y + (int) (bh * 0.4), y + (int) (bh * 0.2), y + (int) (bh * 0.5),
					y + bh, y + bh, y + (int) (bh * 0.65), y + bh, y + bh, y + (int) (bh * 0.5), y + (int) (bh * 0.2),
					y + (int) (bh * 0.4), y + (int) (bh * 0.2), y, y - hh + 3, y - hh - 3, y - hh - hh, y - hh - hh,
					y - hh - 3, y - hh + 3 };
			canvas.dibujar(this, color, new Polygon(xpoints, ypoints, 21));
			canvas.esperar(10);
		}
	}

	/**
	 * Erase the person on screen.
	 */
	private void borrar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.borrar(this);
		}
	}
}
