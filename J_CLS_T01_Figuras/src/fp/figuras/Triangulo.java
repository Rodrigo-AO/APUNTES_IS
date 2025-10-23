package fp.figuras;

public interface Triangulo extends Figura{

	/**
	 * @param nuevaAltura Nueva altura del triángulo
	 * @param nuevaAnchura Nueva anchura del triángulo
	 * Cambia el tamaño del triángulo al nuevo tamaño (en pixeles). 
	 * El tamaño debe ser >=0.
	 */
	void cambiarTamanyo(Integer nuevaAltura, Integer nuevaAnchura);
}