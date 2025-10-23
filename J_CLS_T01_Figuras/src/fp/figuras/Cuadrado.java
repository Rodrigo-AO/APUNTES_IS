package fp.figuras;

public interface Cuadrado extends Figura{

	
	/**
	 * @param nuevoLado Nuevo tamaño en pixels.
	 * Cambia el tamñao por el nuevo tamaño (en pixels). El tamaño debe ser >=0.
	 */
	void cambiarTamanyo(Integer nuevoLado);

}