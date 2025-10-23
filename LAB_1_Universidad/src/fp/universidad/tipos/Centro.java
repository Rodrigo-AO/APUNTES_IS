package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import fp.utiles.Checkers;

public record Centro(String nombre, String direccion, Integer plantas, Integer sotanos, Set<Espacio> espacios) {
	
	
	public Centro {
		Checkers.check("El centro debe de tener al menos 1 planta", plantas >= 1);
		Checkers.check("No puede haber sótanos negativos", sotanos >= 0);
	}
	
	
	public Centro (String nombre, String direccion, Integer plantas, Integer sotanos){
		this(nombre, direccion, plantas, sotanos, new HashSet<>());
	}
	
	
	public void nuevoEspacio(Espacio e) {
		Checkers.check("La planta no se reconoce en el centro", -sotanos() <= e.getPlanta() && e.getPlanta() <= plantas()-1);
		espacios.add(e);
	}
	
	
	public void eliminaEspacio(Espacio e) {
		espacios.remove(e);
	}
	
	public Integer[] getConteosEspacios() {
		int aulaTeoria = 0; int laboratorio = 0; int seminario = 0; int aulaExamen = 0; int otroTipo = 0;
		for(Espacio espacio: espacios) {
			switch(espacio.getTipoEspacio()) {
			case TEORIA:
				aulaTeoria += 1;
				break;
			case LABORATORIO:
				laboratorio += 1;
				break;
			case SEMINARIO:
				seminario += 1;
				break;
			case EXAMEN:
				aulaExamen += 1;
				break;
			case OTRO:
				otroTipo += 1;
				break;
			default:
				break;
			}
		}
		Integer[] res = {aulaTeoria, laboratorio, seminario, aulaExamen, otroTipo};
		return res;
	}
	
	
	public Set<Despacho> getDespachos(){
		Set<Despacho> res = new HashSet<Despacho>();
		for(Espacio espacio: espacios) {
			if(espacio instanceof Despacho) {
				res.add((Despacho) espacio);
			}
		}
		return res;
	}
	
	public Set<Despacho> getDespachos(Departamento d){
		Set<Despacho> res = new HashSet<Despacho>();
		Set<Profesor> profesores = d.getProfesores();
		for(Espacio espacio: espacios) {
			if(espacio instanceof Despacho) {
				if(contieneProfesor(espacio, profesores)) {
					res.add((Despacho) espacio);
				}
			}
		}
		return res;
	}
	
	private boolean contieneProfesor(Espacio espacio, Set<Profesor> profesores) {
		boolean res = false;
		Despacho despacho = (Despacho) espacio;
		for(Profesor profesor: profesores) {
			if(despacho.getProfesores().contains(profesor)) {
				res = true;
				break;
			}
		}
		return res;
	}


	public Set<Profesor> getProfesores() {
		Set<Profesor> res = new HashSet<Profesor>();
		for(Espacio espacio: espacios) {
			if(espacio instanceof Despacho) {
				Despacho despacho = (Despacho) espacio;
				res.addAll(despacho.getProfesores());
			}
		}
		return res;
	}
	
	public Set<Profesor> getProfesores(Departamento d){
		Set<Profesor> res = new HashSet<Profesor>();
		Set<Profesor> profesores = d.getProfesores();
		for(Espacio espacio: espacios) {
			if(espacio instanceof Despacho) {
				if(contieneProfesor(espacio, profesores)) {
					Despacho despacho = (Despacho) espacio;
					res.addAll(despacho.getProfesores());
				}
			}
		}
		return res;
	}
	
	public Espacio getEspacioMayorCapacidad() {
		Espacio res = null;
		Integer capacidad = 0;
		if(espacios.isEmpty()) return res;
		for(Espacio espacio: espacios) {
			if(res == null || espacio.getCapacidad() > capacidad) {
				capacidad = espacio.getCapacidad();
				res = espacio;
			}
		}
		return res;
	}
	
	public SortedMap<String, Despacho> getDespachosPorProfesor() {
		SortedMap<String, Despacho> res = new TreeMap<String, Despacho>();
		Set<Profesor> profesores = getProfesores();
		Set<Despacho> despachos = getDespachos();
		for(Despacho despacho: despachos) {
			for(Profesor profesor: profesores) {
				if(!(res.containsKey(profesor.toString()))) {
					res.put(profesor.toString(), despacho);
				}
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		return nombre();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Centro other = (Centro) obj;
		return Objects.equals(nombre(), other.nombre());
	}
	
	public int compareTo(Centro cen) {
		return nombre().compareTo(cen.nombre());
	}
	
}
