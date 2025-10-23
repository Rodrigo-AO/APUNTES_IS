package fp.laboratorio;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Tipo que representa a una clase de laboratorio
 * 
 * @author Toñi Reina
 * @version 1.0.0 - 22/01/2019
 */

public interface ClaseLaboratorio {

	/**
	 * @param estudiante Estudiante a inscribir.
	 * Inscribe al estudiante en el laboratorio, siempre que el laboratorio no esté completo. Es decir,
	 * que no se haya llegado a su capacidad.
	 * Si el laboratorio está completo, se muestra un mensaje por la consola.
	 */
	void inscribeEstudiante(Estudiante estudiante);

	/**
	 * @return Devuelve el número de estudiantes inscritos en el laboratorio.
	 */
	Integer getNumeroEstudiantes();

	/**
	 * @return Devuelve el aula en la que se imparte el laboratorio.
	 */
	String getAula();
	
	/**
	 * @param nuevaAula Aula nueva en la que se imparte el laboratorio.
	 * Cambia el aula en la que se imparte el laboratorio.
	 */
	void setAula(String nuevaAula);

	/**
	 * @return Devuelve el profesor que imparte el laboratorio.
	 */
	String getProfesor();

	/**
	 * @param nuevoProfesor Nuevo profesor que imparte el laboratorio.
	 * Cambia el profesor que imparte el laboratorio.
	 */
	void setProfesor(String nuevoProfesor);

	/**
	 * @return Devuelve la fecha y hora en la que se imparte el laboratorio.
	 */
	LocalDateTime getFechaHora();

	/**
	 * @param nuevaFechaHora Nueva fecha y hora en la que se imparte el laboratorio.
	 * Cambia la fecha y hora en la que se imparte el laboratorio.
	 */
	void setFechaHora(LocalDateTime nuevaFechaHora);
	
	List<Estudiante> getEstudiantesOrdenados();

}