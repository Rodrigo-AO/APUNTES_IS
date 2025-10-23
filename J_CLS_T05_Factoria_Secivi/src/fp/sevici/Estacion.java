package fp.sevici;

import java.util.Objects;

import fp.utiles.Checkers;

public record Estacion (String id, String nombre, Integer numPuestos, Integer bicisDisponibles, Coordenada ubicacion) implements Comparable<Estacion>{
	
	public Estacion {
		Checkers.check("El número de puestos ha de ser mayor a 0", numPuestos()>0);
		Checkers.check("No puede haber más bicis que puestos disponibles", numPuestos()>=bicisDisponibles() && bicisDisponibles() >= 0);
	}
	
	public Integer puestosVacios() {
		return numPuestos() - bicisDisponibles();
	}
	
	public Boolean tieneBicisDisponibles() {
		return bicisDisponibles() > 0 ;
	}
	
	public Double ocupacion() {
		Double res = Double.valueOf((bicisDisponibles()/numPuestos())*100);
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Estacion other = (Estacion) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(Estacion o) {
		return id().compareTo(o.id());
	}
	
	
	
}
