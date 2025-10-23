package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Expediente {
	private List<Nota> notas;
	
	public Expediente() {
		notas = new ArrayList<Nota>();
	}
	
	public List<Nota> getNotas() {
		return new ArrayList<Nota>(notas);								// Devovemos una copia de la lista para que no se pueda editar
	}
	
	public void nuevaNota(Nota n) {
		if(notas.contains(n)) {											// Para detectar el contains usa el equals de notas
			notas.remove(n);
		}
		else {
			Checkers.check("Un alumno no puede presentarse a más de 2 convocatorias por curso", contarConvocatoriasCurso(n) <=1);
		}
		notas.add(n);
	}
	
	private Integer contarConvocatoriasCurso(Nota n) {
		Integer contador = 0;
		for(Nota nota: notas) {
			if(nota.getCursoAcademico().equals(n.getCursoAcademico())
					&& nota.asignatura().equals(n.asignatura())) {
				contador += 1;
			}
		}
		return contador;
	}
	
	public Double getNotaMedia() {
		Double res = 0.;
		Integer numNotas = 0;
		for(Nota nota: notas) {
			if(nota.valorNumerico() >= 5) {
				res += nota.valorNumerico();
				numNotas += 1;
			}
		}
		if(numNotas != 0) {
			res = res/numNotas;
		}
		return res;
	}
	
	public Nota getNotaMaxima() {
		Double valor = 0.;
		Nota res = null;
		for(Nota nota: notas) {
			if(nota.valorNumerico() > valor) {
				res = nota;
			}
		}
		return res;
	}
	
	public Nota getNotaMaxima(Asignatura asi) {
		Double valor = 0.;
		Nota res = null;
		for(Nota nota: notas) {
			if(nota.valorNumerico() > valor && nota.asignatura().equals(asi)) {
				res = nota;
			}
		}
		return res;
	}
	
	public int hashCode() {
		return Objects.hash(notas);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}
	
	public String toString() {
		return getNotas().toString();
	}
	
}
