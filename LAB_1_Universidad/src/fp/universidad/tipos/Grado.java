package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.utiles.Checkers;

public class Grado {
	private String nombre;
	private Set<Asignatura> asigOblig;
	private Set<Asignatura> asigOpt;
	private Double minCreditos;				// suma de los creditos de las asignaturas opt que ha de cursar
	
	
	public Grado(String nombre, Set<Asignatura> asigOblig, Set<Asignatura> asigOpt, Double minCreditos) {
		Checkers.check("Todas las asignaturas optativas deben de tener el mismo número de créditos", checkCreditos(asigOpt));
		Checkers.check("El número mínimo de créditos de asignaturas optativas que debe cursar un alumno debe estar comprendido entre cero y el número total de créditos de asignaturas optativas del grado", 0 < minCreditos && minCreditos < sumCreditos(asigOpt));
		this.nombre = nombre;
		this.asigOblig = asigOblig;
		this.asigOpt = asigOpt;
		this.minCreditos = minCreditos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Set<Asignatura> getAsignaturasObligatorias() {
		return asigOblig;
	}
	
	public Set<Asignatura> getAsignaturasOptativas() {
		return asigOpt;
	}
	
	public Double getMinimoCreditos() {
		return minCreditos;
	}
	
	private boolean checkCreditos(Set<Asignatura> asigOpt) {
		boolean res = true;
		Double muestraCreditos = 0.;
		for(Asignatura asignatura: asigOpt) {
			if(muestraCreditos == 0.) {
				muestraCreditos = asignatura.creditos();
			}
			else if(asignatura.creditos() != muestraCreditos) {
				res = false;
			}
		}
		return res;
	}
	
	private Double sumCreditos(Set<Asignatura> asigOpt) {
		Double suma = 0.;
		for(Asignatura asignatura: asigOpt) {
			suma += asignatura.creditos();
		}
		return suma;
	}

	public Set<Asignatura> getAsignaturas() {
		Set<Asignatura> res = new HashSet<Asignatura>();
		res.addAll(getAsignaturasObligatorias()); res.addAll(getAsignaturasOptativas());
		return res;
	}
	
	public Asignatura getAsignatura(String codigo) {
		Asignatura res = null;
		for(Asignatura asignatura: getAsignaturas()) {
			if(asignatura.codigo().equals(codigo)) {
				res = asignatura;
				break;
			}
		}
		return res;
	}
	
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {
		SortedMap<Asignatura, Double> res = new TreeMap<Asignatura, Double>();
		Set<Asignatura> asignaturas = getAsignaturas();
		for(Asignatura asignatura: asignaturas) {
			if(!(res.containsKey(asignatura))) {
				res.put(asignatura, asignatura.creditos());
			}
		}
		return res;
	}
	
	public Map<Integer, Double> getTotalCreditosPorCurso() {
		Map<Integer, Double> res = new TreeMap<Integer, Double>();
		Set<Asignatura> asignaturas = getAsignaturas();
		for(Asignatura asignatura: asignaturas) {
			if(!(res.containsKey(asignatura.curso()))) {
				res.put(asignatura.curso(), asignatura.creditos());
			}
		}
		return res;
	}
	
	public String toString() {
		return nombre;
	}
	
	public int hashChode() {
		return Objects.hash(getNombre());
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() == obj.getClass()) return false;
		Grado other = (Grado) obj;
		return Objects.equals(getNombre(), other.getNombre());
	}
	
	public int compareTo(Grado gra) {
		return getNombre().compareTo(gra.getNombre());
	}

}
