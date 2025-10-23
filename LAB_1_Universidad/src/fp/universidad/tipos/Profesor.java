package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import fp.utiles.Checkers;

public class Profesor extends Persona {
	private Categoria tipoProfesor;
	private SortedSet<Tutoria> tutorias;
	private Map<Asignatura, Double> creditos;

	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			Categoria tipoProfesor) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		Checkers.check("El profesor ha de ser mayor de edad", getEdad2() >= 18);
		this.tipoProfesor = tipoProfesor;
		this.tutorias = new TreeSet<Tutoria>();
		this.creditos = new HashMap<Asignatura, Double>();
	}

	public Categoria getTipoProfesor() {
		return tipoProfesor;
	}

	public SortedSet<Tutoria> getTutorias() {
		SortedSet<Tutoria> res = new TreeSet<Tutoria>();
		res.addAll(tutorias);
		return res;
	}
	
	public Map<Asignatura, Double> getAsignaturaCreditos() {
		Map<Asignatura, Double> res = new HashMap<Asignatura, Double>();
		res.putAll(creditos);
		return res;
	}
	
	public List<Asignatura> getAsignaturas() {
		List<Asignatura> res = new ArrayList<Asignatura>();
		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		asignaturas.addAll(getAsignaturaCreditos().keySet());
		for(Asignatura asignatura: asignaturas) {
			res.add(asignatura);
		}
		return res;
	}
	
	public List<Double> getCreditos() {
		List<Double> res = new ArrayList<Double>();
		for(Double credito: getAsignaturaCreditos().values()) {
			res.add(credito);
		}
		return res;
	}
	
	public void imparteAsignatura(Asignatura asignatura, Double dedicacion) {
		Checkers.check("La dedicacion ha de ser mayor o igual a 0", dedicacion >= 0.);
		Checkers.check("La dedicacion no puede ser mayor a los créditos de la asignatura", asignatura.creditos() >= dedicacion);
		Checkers.check("Limite de créditos permitido excedido", getDedicacionTotal() <= 24.);
		creditos.put(asignatura, dedicacion);
	}
	
	public Double getDedicacionTotal() {
		Set<Double> dedicacion = new HashSet<Double>();
		dedicacion.addAll(getAsignaturaCreditos().values());
		Double res = 0.;
		for(Double credito: dedicacion) {
			res = res + credito;
		}
		return res;
	}
	
	public void eliminaAsignatura(Asignatura asignatura) {
		creditos.remove(asignatura);
	}
	
	public Double dedicacionAsignatura(Asignatura asignatura) {
		Double res = 0.;
		if(creditos.containsKey(asignatura)) {
			res = creditos.get(asignatura);
		}
		return res;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		Checkers.check("El profesor ha de ser mayor de edad", getEdad(fechaNacimiento) >= 18);
		super.setFechaNacimiento(fechaNacimiento);
	}

	private Integer getEdad(LocalDate fechaNacimiento) {
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}

	public void nuevaTutoria(LocalTime horaComienzo, Integer duracion, DayOfWeek diaSemana) {
		Tutoria nuevaTutoria = new Tutoria(diaSemana, horaComienzo, duracion);
		Checkers.check("La tutoría ya está registrada", tutorias.contains(nuevaTutoria));
		tutorias.add(nuevaTutoria);
	}
	
	public void nuevaTutoria(Tutoria tutoria) {
		tutorias.add(tutoria);
	}

	public void borraTutoria(LocalTime horaComienzo, DayOfWeek diaSemana) {
		Tutoria tutoria = new Tutoria(diaSemana, horaComienzo, 10);
		tutorias.remove(tutoria);													// remove se rige por el equals de tutoria
	}

	public void borraTutorias() {
		tutorias.clear();
	}
	
	public int hashCode() {
		return super.hashCode();
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public int compareTo(Profesor pr) {
		return super.compareTo(pr);
	}

	public String toString() {
		return super.toString() + "(" + getTipoProfesor() + ")";
	}
	
}
