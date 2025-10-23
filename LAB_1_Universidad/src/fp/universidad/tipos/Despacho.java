package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public class Despacho extends Espacio{
	private Set<Profesor> profesores;
	
	public Despacho(String nombre, Integer planta, Integer capacidad, Set<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, planta, capacidad);
		setProfesores(profesores);
	}
	
	public Despacho(String nombre, Integer planta, Integer capacidad, Profesor profesor) {
		super(TipoEspacio.OTRO, nombre, planta, capacidad);
		this.profesores = Set.of(profesor);
	}
	
	public Despacho(String nombre, Integer planta, Integer capacidad) {
		super(TipoEspacio.OTRO, nombre, planta, capacidad);
		this.profesores = new HashSet<Profesor>();
	}
	
	public Despacho(String datos) {
		super(nuevaCadena(datos));
		this.profesores = new HashSet<Profesor>();
	}
	
	private static String nuevaCadena(String datos) {
		String res = datos + ", OTRO";
		return res;
	}
	
	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		Checkers.check("La cantidad de profesores no puede ser mayor a la capacidad del despacho", capacidad > profesores.size());
		this.profesores = profesores;
	}
	
	@Override
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		throw new UnsupportedOperationException("La operación no está disponible");
	}

	public String toString() {
		return super.toString() + " " + profesores;
	}
	
}
