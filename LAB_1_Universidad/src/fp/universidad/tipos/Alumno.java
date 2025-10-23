package fp.universidad.tipos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import fp.utiles.Checkers;

public class Alumno extends Persona{
	private Set<Asignatura> asignaturas;
	private Expediente expediente;
	
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		setEmail(email);
		this.asignaturas = new HashSet<Asignatura> ();
		this.expediente = new Expediente();
	}
	
	public Alumno(String datos) {
		super(datos);
		this.asignaturas = new HashSet<Asignatura>();
		this.expediente = new Expediente();
	}
	
	public void setEmail(String email) {
		Checkers.check("Email no válido", !email.isBlank() && email.endsWith("@alum.us.es"));
		super.setEmail(email);
	}
	
	public Set<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}
	
	public Expediente getExpediente() {
		return this.expediente;
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public Integer getCurso() {
		Integer res = 0;
		if(asignaturas.isEmpty()) return res;
		for(Asignatura asignatura : asignaturas) {
			if(res == 0 || asignatura.curso() > res) {
				res = asignatura.curso();
			}
		}
		return res;
	}
	
	public void matriculaAsignatura(Asignatura as) {
		Checkers.check("El alumno ya está matriculado", !estaMatriculado(as));
		asignaturas.add(as);
	}
	
	public Boolean estaMatriculado(Asignatura as) {
		return asignaturas.contains(as);
	}
	
	public void eliminaAsignatura(Asignatura as) {
		Checkers.check("El alumno no está matriculado", estaMatriculado(as));
		asignaturas.remove(as);
	}
	
	public void evaluaAsignatura(Asignatura as, Integer curso, TipoConvocatoria conv, Double nota) {
		Checkers.check("El alumno no está matriculado", estaMatriculado(as));
		expediente.nuevaNota(new Nota(as, curso, conv, nota));
	}
	
	public SortedMap<Asignatura, TipoCalificacion> getCalificacionPorAsignatura() {
		SortedMap<Asignatura, TipoCalificacion> res = new TreeMap<Asignatura, TipoCalificacion>();
		for(Asignatura asignatura: getAsignaturas()) {
			for(Nota nota: getExpediente().getNotas()) {
				if(asignatura.equals(nota.asignatura())) {
					if(!(res.containsKey(asignatura))) {
						res.put(asignatura, getExpediente().getNotaMaxima(asignatura).getCalificacion());
					}
				}
			}
		}
		return res;
	}
	
	public Map<Integer, Integer> getNumAsignaturasPorCurso() {
		Map<Integer, Integer> res = new TreeMap<Integer, Integer>();
		for(Asignatura asignatura: getAsignaturas()) {
			if(res.containsKey(asignatura.curso())) {
				Integer cantidad = res.get(asignatura.curso());
				res.put(asignatura.curso(), cantidad + 1);
			} else {
				res.put(asignatura.curso(), 1);
			}
		}
		return res;
	}
	
	public String toString() {
		return "(" + getCurso() + "º)" + super.toString();
	}
}
