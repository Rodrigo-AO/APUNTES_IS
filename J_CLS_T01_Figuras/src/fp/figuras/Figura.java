package fp.figuras;



public interface Figura {

	/**
	 * 
	 * Hace la figura visible. Si ya es visible no hace nada.
	 */
	void hacerVisible();
	/**
	 * 
	 * Hace la figura invisible. Si ya es visible no hace nada.
	 */
	void hacerInvisible();
	/**
	 * Mueve la figura unos cuantos píxeles a la derecha
	 */
	void moverDerecha();
	/**
	 * Mueve la figura unos cuantos píxeles a la izquierda
	 */
	void moverIzquierda();
	/**
	 * Mueve la figura unos cuantos píxeles hacia arriba
	 */
	void moverArriba();
	
	/**
	 * Mueve la figura unos cuantos píxeles hacia abajo
	 */
	void moverAbajo();
	/**
	 * @param distancia Nímero de píxeles a mover
	 * Mueve horizontalmente la figura el nímero de pixeles dados por distancia.
	 */
	void moverHorizontalmente(Integer distancia);
	/**
	 * @param distancia Nímero de píxeles a mover
	 * Mueve verticalmente la figura el nímero de pixeles dados por distancia.
	 */
	void moverVerticalmente(Integer distancia);
	/**
	 * @param distancia Nímero de píxeles a mover
	 * Mueve horizontalmente y despacio la figura el nímero de pixeles dados por distancia.
	 */
	void moverHorizontalmenteDespacio(Integer distancia);
	/**
	 * @param distancia Nímero de píxeles a mover
	 * Mueve verticalmente y despacio la figura el nímero de pixeles dados por distancia.
	 */
	void moverVerticalmenteDespacio(Integer distancia);

	/**
	 * @param nuevoColor
	 * Cambia el color. Los colores válidos son "rojo", "amarillo", "azul", "verde",
	 * "magenta" y "negro".
	 */ 
	void cambiarColor (String nuevoColor);
	
}
