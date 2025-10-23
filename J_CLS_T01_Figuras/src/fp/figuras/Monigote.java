package fp.figuras;

public interface Monigote extends Figura{

	/**
	 * @param nuevaAltura Nueva altura del monigote
	 * @param nuevaAnchura Nueva anchura del monigote
	 * Cambia el tamaño al nuevo tamaño (en pixels). El tamaño debe ser >=0.
	 */
	void cambiarTamanyo(Integer nuevaAltura, Integer nuevaAnchura);

}