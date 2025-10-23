package fp.tipos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EstadisticasJugadores {
	
	private Set<Jugador> jugadores;
	private Integer numJugadores;
	
	//--------------------------------------------------------CONSTRUCTORES--------------------------------------------------------\\
	
	public EstadisticasJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	//------------------------------------------------------------MÉTODOS------------------------------------------------------------\\
	
	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public Integer getNumJugadores() {
		return numJugadores;
	}
	
	
	public Long getNumeroLesionesDistintas (Integer umbralClasificacion) {
		return jugadores.stream()
				.filter(j -> j.getEquipo().clasificacion() < umbralClasificacion)
					.flatMap(j -> j.getLesiones().stream())
						.distinct()
							.count();
	}
	
	
	public List<String> getNJugadoresMasJovenesPosicionSinLesion(Posicion p, Integer n) {
		return jugadores.stream()
				.filter(j -> j.getPosicion().equals(p))
					.filter(j -> j.getLesiones().isEmpty())
						.sorted(Comparator.comparing(Jugador::getFechaDeNacimiento))
							.limit(n)
								.map(Jugador::getNombre)
									.collect(Collectors.toList());
	}
	
	
	public Equipo getEquipoMasJugadoresConGolesSuperiorMedia() {
		Double mediaGoles = jugadores.stream()
				.collect(Collectors.averagingDouble(Jugador::getGoles));
		
		Map<Equipo, Long> equipoJugadores = jugadores.stream()
				.filter(j -> j.getGoles() > mediaGoles)
					.collect(Collectors.groupingBy(
						Jugador::getEquipo, Collectors.counting()));
		
		return equipoJugadores.entrySet().stream()
				.max(Map.Entry.comparingByValue())
					.get()
						.getKey();
	}
	
	
	public Boolean todosEquiposTienenJugadorLesionado() {
		Map<Equipo, Boolean> equipoLesion = jugadores.stream()
				.collect(Collectors.groupingBy(Jugador::getEquipo, 
						Collectors.collectingAndThen(Collectors.toList(), l -> hayLesion(l))));
		
		return equipoLesion.entrySet().stream().allMatch(e -> e.getValue().equals(true));
	}
	
	private Boolean hayLesion(List<Jugador> lista) {
		return lista.stream().anyMatch(j -> !(j.getLesiones().isEmpty()));
	}
	
	
	public SortedMap<Equipo, String> getNombreJugadorConMayorSumaGAPorEquipo() {
		SortedMap<Equipo, String> res = new TreeMap<Equipo, String>(Comparator.comparingInt(Equipo::clasificacion));
		for(Jugador jugador: jugadores) {
			Equipo clave = jugador.getEquipo();
			Integer golesAsistencias = sumaGolesAsistencias(jugador);
			if(res.containsKey(clave)) {
				if(sumaGolesAsistencias(jugadorPorNombre(res.get(clave), clave)) < golesAsistencias) {
					res.put(clave, jugador.getNombre());
				}
			} else {
				res.put(clave, jugador.getNombre());
			}
		}
		return res;
	}
	
	private Integer sumaGolesAsistencias(Jugador jugador) {
		return jugador.getGoles() + jugador.getAsistencias();
	}
	
	private Jugador jugadorPorNombre(String nombre, Equipo clave) {
		Jugador res = null;
		for(Jugador jugador: jugadores) {
			if(jugador.getEquipo().equals(clave) && jugador.getNombre().equals(nombre)) {
				res = jugador;
			}
		}
		return res;
	}

	
	//-------------------------------------------------------------COMÚN-------------------------------------------------------------\\

	@Override
	public String toString() {
		String res = "Jugadores = ";
		for(Jugador jugador: jugadores) {
			res += jugador + "\n";
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(jugadores);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(this == null || this.getClass() != obj.getClass()) return false;
		EstadisticasJugadores other = (EstadisticasJugadores) obj;
		return Objects.equals(jugadores, other.jugadores);
	}
	
}
