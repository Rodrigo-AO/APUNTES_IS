package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import fp.utiles.Checkers;

public class GestorCursos {

	private String nombre;
	private String url;
	private List<CursoOnLine> cursos;
	
	public GestorCursos(String nombre) {
		setNombre(nombre);
		this.url = null;
		this.cursos = new ArrayList<CursoOnLine>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		Checkers.checkNoNull(nombre);
		this.nombre = nombre;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		Checkers.check("Formato de url inválido", url.startsWith("http") || url.startsWith("https"));
	}
	
	public List<CursoOnLine> getCursos() {
		return cursos;
	}
	
	public String toString() {
		return getNombre() + ", (" + getUrl() + ") - " + getCursos().size(); 
	}
	
	public int hashCode() {
		return Objects.hash(getNombre(), getUrl());
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		GestorCursos other = (GestorCursos) obj;
		return Objects.equals(getNombre(), other.getNombre()) && Objects.equals(getUrl(), other.getUrl());
	}
	
	public int compareTo(GestorCursos ges) {
		int res = getNombre().compareTo(ges.getNombre());
		if(res == 0) {
			res = getUrl().compareTo(ges.getUrl());
		}
		return res;
	}
	
	//----------------------------------------------------Otras operaciones----------------------------------------------------\\
	
	public void agregaCurso(CursoOnLine c) {
		if(!(c == null)) {
			cursos.add(c);
		}
	}
	
	public void eliminaCurso(CursoOnLine c) {
		if(cursos.contains(c)) {
			cursos.remove(c);
		} else {
			throw new IllegalArgumentException("El curso no se encuentra registrado");
		}
	}
	
	public void agregaCursos(Collection<CursoOnLine> cursos) {
		cursos.addAll(cursos);
	}
	
	// GestorCursos(III)
	public Map<NivelDificultad, Integer> contarCursosPorNivelDificultad() {
		Map<NivelDificultad, Integer> res = new HashMap<NivelDificultad, Integer>();
		for(CursoOnLine curso: cursos) {
			NivelDificultad clave = curso.getNivelDificultad();
			if(res.containsKey(clave)) {
				Integer cantidad = res.get(clave);
				res.put(clave, cantidad + 1);
			} else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	public SortedMap<Integer, Integer> contarCursosPorMes() {
		SortedMap<Integer, Integer> res = new TreeMap<Integer, Integer>();
		for(CursoOnLine curso: cursos) {
			Integer clave = curso.getDuracionMeses();
			if(res.containsKey(clave)) {
				Integer cantidad = res.get(clave);
				res.put(clave, cantidad + 1);
			} else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	public Map<String, Integer> contarCursosGratuitosPorOrganizacion() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for(CursoOnLine curso: cursos) {
			String clave = curso.getOrganizacion();
			if(res.containsKey(clave)) {
				Integer cantidad = res.get(clave);
				res.put(clave, cantidad + 1);
			} else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	// GestorCursos(IV)
	public SortedMap<LocalDate, List<CursoOnLine>> getCursosPorMesAño() {
		SortedMap<LocalDate, List<CursoOnLine>> res = new TreeMap<LocalDate, List<CursoOnLine>>();
		for(CursoOnLine curso: cursos) {
			LocalDate clave = LocalDate.of(curso.getFechaInicio().getYear(), curso.getFechaInicio().getMonth(), 1);
			if(res.containsKey(clave)) {
				List<CursoOnLine> cursos = res.get(clave);
				cursos.add(curso);		// No hay que usar el .put ya que la lista ya está dentro y asignada a la clave
				// Igual a res.get(clave).add(curso);
			} else {
				res.put(clave, new ArrayList<CursoOnLine>(List.of(curso)));
			}
		}
		return res;
	}
	
	// GestorCursos(V)
	public SortedMap<Integer, Set<String>> getOrganizacionesPorDuracion() {
		SortedMap<Integer, Set<String>> res = new TreeMap<Integer, Set<String>>();
		for(CursoOnLine curso: cursos) {
			Integer clave = curso.getDuracion();
			if(res.containsKey(clave)) {
				res.get(clave).add(curso.getOrganizacion());
			} else {
				res.put(clave, new HashSet<String>(Set.of(curso.getOrganizacion())));
			}
		}
		return res;
	}
	
	// GestorCursos(VI)
	public SortedMap<Integer, Set<String>> getOrganizacionesPorNumCursosGratuitoos() {
		SortedMap<Integer, Set<String>> res = new TreeMap<Integer, Set<String>>();
		Map<String, Integer> organizaciones = contarCursosGratuitosPorOrganizacion();
		for(Entry<String, Integer> orgGra: organizaciones.entrySet()) {
			Integer clave = orgGra.getValue();
			if(res.containsKey(clave)) {
				res.get(clave).add(orgGra.getKey());
			} else {
				res.put(clave, new HashSet<String>(Set.of(orgGra.getKey())));
			}
		}
		return res;
	}
	
}
