package fp.figuras;

import java.awt.*;

/**
 * Un cuadrado que que puede se ser manipulado y dibujarse en un canvas.
 * 
 * @author Adaptado por To�i Reina para FP de l c�digo de Michael K�lling and
 *         David J. Barnes
 * @version 1.0.0
 */

public class CuadradoImpl implements Cuadrado {
	private Integer lado;
	private Integer xPosition;
	private Integer yPosition;
	private String color;
	private Boolean esVisible;

	/**
	 * Crea un nuevo cuadrado en una posici�n por defecto y con un color por
	 * defecto.
	 * 
	 */
	public CuadradoImpl() {
		lado = 60;
		xPosition = 310;
		yPosition = 120;
		color = "red";
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

	/* (non-Javadoc)
	 * @see fp.figuras.Figura#moverIzquierda()
	 */
	public void moverIzquierda() {
		moverHorizontalmente(-20);

	}
	
	/* (non-Javadoc)
	 * @see fp.figuras.Figura#moverArriba()
	 */
	public void moverArriba() {
		moverVerticalmente(-20);
		
	}

    /* (non-Javadoc)
     * @see fp.figuras.Figura#moverAbajo()
     */
    public void moverAbajo() {
       moverVerticalmente(20);
    }
	
    /* (non-Javadoc)
     * @see fp.figuras.Figura#moverHorizontalmente(java.lang.Integer)
     */
    public void moverHorizontalmente(Integer distancia) {
    	borrar();
		xPosition += distancia;
		dibujar();
    }

    /* (non-Javadoc)
     * @see fp.figuras.Figura#moverVerticalmente(java.lang.Integer)
     */
    public void moverVerticalmente(Integer distancia) {
    	borrar();
		yPosition += distancia;
		dibujar();
    	
    }
	
	/* (non-Javadoc)
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
    
	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see fp.figuras.Cuadrado#cambiarTamanyo(java.lang.Integer)
	 */
	public void cambiarTamanyo(Integer nuevoLado) {
		borrar();
		lado = nuevoLado;
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
	 * Dibuja el cuadrado en la pantalla.
	 */
	private void dibujar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.dibujar(this, color, new Rectangle(xPosition, yPosition, lado, lado));
			canvas.esperar(10);
		}
	}

	/**
	 *Borra el cuadrado de la pantalla
	 */
	private void borrar() {
		if (esVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.borrar(this);
		}
	}
}
