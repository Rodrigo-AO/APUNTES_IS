package fp.sevici;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RedEstaciones {
	private String nombre;
	private SortedSet<Estacion> estaciones;
	
	public RedEstaciones(String nombre) {
		this.nombre = nombre;
		this.estaciones = new TreeSet<Estacion>();
	}
	
	public RedEstaciones() {
		this("");
	}
	
	public RedEstaciones(String nombre, Set<Estacion> estaciones) {
		this.nombre = nombre;
		this.estaciones = new TreeSet<Estacion>(estaciones);
	}
	
}
