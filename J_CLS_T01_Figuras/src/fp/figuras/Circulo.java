package fp.figuras;

public interface Circulo extends Figura{

	/**
	 * @param nuevoDiametro Nuevo diámetro en pixeles.
	 * Cambia el tamaño del círculo por el nuevo tamaño(en pixeles). El nuevo diámetro debe ser >=0. 
	 */
	void cambiarTamanyo(Integer nuevoDiametro);

}