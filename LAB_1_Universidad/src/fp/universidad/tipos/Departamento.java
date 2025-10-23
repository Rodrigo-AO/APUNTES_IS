package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Departamento {
	private String nombre;
	private Set<Profesor> profesores;
	private Set<Asignatura> asignaturas;
	
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.profesores = new HashSet<Profesor>();
		this.asignaturas = new HashSet<Asignatura>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Set<Profesor> getProfesores(){
		return new HashSet<Profesor> (profesores);
	}
	
	public void nuevoProfesor(Profesor profesor) {
		if(profesores.contains(profesor)) {
			System.out.println("El profesor ya se encuentra registrado");
		}
		profesores.add(profesor);
	}
	
	public void eliminaProfesor(Profesor profesor) {
		if(!profesores.contains(profesor)) {
			System.out.println("El profesor no se encuentra registrado");
		}
		profesores.remove(profesor);
	}
	
	public Set<Asignatura> getAsignaturas() {
		return new HashSet<Asignatura>(asignaturas);
	}
	
	public void nuevaAsignatura(Asignatura asignatura) {
		if(asignaturas.contains(asignatura)) {
			System.out.println("La asignatura ya se encuentra registrada");
		}
		asignaturas.add(asignatura);
	}
	
	public void eliminaAsignatura(Asignatura asignatura) {
		if(!asignaturas.contains(asignatura)) {
			System.out.println("La asignatura no se encuentra registrada");
		}
		asignaturas.remove(asignatura);
	}
	
	public void borraTutorias() {
		for(Profesor profesor: profesores) {
			profesor.borraTutorias();
		}
	}
	
	public void borraTutorias(Categoria categoria) {
		for(Profesor profesor: profesores) {
			if(profesor.getTipoProfesor() == categoria) {
				profesor.borraTutorias();
			}
		}
	}
	
	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura() {
		SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();
		for(Profesor profesor: getProfesores()) {
			for(Asignatura asignatura: getAsignaturas()) {
				if(!(res.containsKey(asignatura)) && profesor.getAsignaturas().contains(asignatura)) {
					SortedSet<Profesor> profesorAsig = new TreeSet<Profesor>(Set.of(profesor));
					res.put(asignatura, profesorAsig);
				} else if((profesor.getAsignaturas().contains(asignatura))) {
					SortedSet<Profesor> profesoresAsig = res.get(asignatura);
					profesoresAsig.add(profesor);
					res.put(asignatura, profesoresAsig);
				}
			}
		}
		return res;
	}
	
	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor() {
		SortedMap<String, SortedSet<Tutoria>> res = new TreeMap<String, SortedSet<Tutoria>>();
		for(Profesor profesor: getProfesores()) {
			String clave = profesor.toString();
			for(Tutoria tutoria: profesor.getTutorias()) {
				if(res.containsKey(clave)) {
					SortedSet<Tutoria> tutorias = profesor.getTutorias();
					tutorias.add(tutoria);
					res.put(clave, tutorias);
				} else {
					SortedSet<Tutoria> tutorias = new TreeSet<Tutoria>(Set.of(tutoria));
					res.put(clave, tutorias);
				}
			}
		}
		return res;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(getNombre(), other.getNombre());
	}
	
	public int compareTo(Departamento departamento) {
		return getNombre().compareTo(departamento.getNombre());
	}
	
	public String toString() {
		return getNombre();
	}
}
