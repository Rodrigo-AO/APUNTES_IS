package fp.laboratorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Clase que implemente al tipo ClaseLaboratorio
 * 
 * @author Toñi Reina 
 * @version 1.0.0 22/01/2019
 */
public class ClaseLaboratorioImpl implements ClaseLaboratorio {

	private String profesor;
    private String aula;
    private LocalDateTime fechaHora;
    private List<Estudiante> estudiantes;
    private Integer capacidadMax;
    
    
    /**
     * @param numMaximoEstudiantes Número máximo de estudiantes del laboratorio.
     * Crea una clase de laboratorio con profesor y aulas desconocidos, fecha acutal del sistema,
     * sin estudiantes, y con la capacidad máxima dada por el parámetro numMaximoEstudiantes
     */
    public ClaseLaboratorioImpl(Integer numMaximoEstudiantes) {
    	this.profesor = "Desconocido";
    	this.aula = "Desconocida";
        this.fechaHora = LocalDateTime.now()	;
        this.estudiantes = new ArrayList<Estudiante>();
        this.capacidadMax = numMaximoEstudiantes;
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#inscribeEstudiante(fp.laboratorio.Estudiante)
	 */
    @Override
	public void inscribeEstudiante (Estudiante estudiante) {
    	if (estudiantes.size() == capacidadMax) {
    		System.out.println("No se puede inscribir al estudiante, el laboratorio está completo");
    	}else {
    		estudiantes.add(estudiante);
    	}
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#getNumeroEstudiantes()
	 */
    @Override
	public Integer getNumeroEstudiantes() {
    	return estudiantes.size();
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#getAula()
	 */
    @Override
	public String getAula(){
    	return aula;
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#setAula(java.lang.String)
	 */
    @Override
	public void setAula(String nuevaAula) {
    	this.aula = nuevaAula;
    }

    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#getProfesor()
	 */
    @Override
	public String getProfesor() {
    	return profesor;
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#setProfesor(java.lang.String)
	 */
    @Override
	public void setProfesor(String nuevoProfesor) {
    	this.profesor = nuevoProfesor;
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#getFechaHora()
	 */
    @Override
	public LocalDateTime getFechaHora() {
    	return fechaHora;
    }
    
    /* (non-Javadoc)
	 * @see fp.laboratorio.ClaseLaboratorio#setFechaHora(java.time.LocalDateTime)
	 */
    @Override
	public void setFechaHora(LocalDateTime nuevaFechaHora) {
    	this.fechaHora = nuevaFechaHora;
    }
    
    public String toString() {
    	String res = "ClaseLaboratorio "  + getFechaHora();
    	res+= " Profesor: " + getProfesor() + " Aula: " + getAula()+"\n";
    	for (Estudiante estudiante: estudiantes) {
    		res+=estudiante.toString()+"\n";
    	}
        res+= "Numero de estudiantes:" + getNumeroEstudiantes();
    	return res;		
    }
    
    public List<Estudiante> getEstudiantesOrdenados() {
    	List<Estudiante> lista = new ArrayList<>(estudiantes);
    	Collections.sort(lista);
    	return lista;
    }
}
