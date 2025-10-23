package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.trenes.utiles.Checkers;

public class TrayectoTrenImpl implements TrayectoTren{
	
	private String codigoTren;
	private String nombre;
	private TipoTren tipo;
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	public TrayectoTrenImpl(String codigoTren, String nombre, TipoTren tipo, String estacionOrigen,
			String estacionFinal, LocalTime horaSalida, LocalTime horaLlegada) {
		Checkers.check("Formato inválido del código", codigoTren.length() == 5 && esDigito(codigoTren));
		Checkers.checkNoNull(getHoraSalida());
		Checkers.checkNoNull(getHoraLlegada());
		Checkers.check("La hora de salida de la primera estacion no puede ser posterior a la hora de llegada de la última estación", getHoraSalida().isBefore(getHoraLlegada()));
		this.codigoTren = codigoTren;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estaciones = new LinkedList<String> (List.of(estacionOrigen, estacionFinal));
		this.horasSalida = new LinkedList<LocalTime> (List.of(horaSalida, null));
		this.horasLlegada = new LinkedList<LocalTime> (List.of(null, horaLlegada));
	}
	
	private Boolean esDigito(String codigoTren) {
		Boolean res = true;
		for(int i = 0; i < codigoTren.length(); i++) {
			if(!Character.isDigit(codigoTren.charAt(i))) {
				res = false;
			}
		}
		return res;
	}

	@Override
	public String getCodigoTren() {
		return codigoTren;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public List<String> getEstaciones() {
		return new ArrayList<String> (estaciones);
	}

	@Override
	public List<LocalTime> getHorasSalida() {
		return new ArrayList<LocalTime> (horasSalida);
	}

	@Override
	public List<LocalTime> getHorasLlegada() {
		return new ArrayList<LocalTime> (horasLlegada);
	}

	@Override
	public LocalTime getHoraSalida() {
		return horasSalida.get(0);
	}

	@Override
	public LocalTime getHoraLlegada() {
		return horasLlegada.get(horasLlegada.size()-1);
	}

	@Override
	public LocalTime getHoraSalida(String estacion) {
		LocalTime res = null;
		int pos = getEstaciones().indexOf(estacion);
		if(pos >= 0) {
			res = getHorasSalida().get(pos);
		}
		return res;
	}

	@Override
	public LocalTime getHoraLlegada(String estacion) {
		LocalTime res = null;
		int pos = getEstaciones().indexOf(estacion);
		if(pos >= 0) {
			res = getHorasLlegada().get(pos);
		}
		return res;
	}

	@Override
	public Duration getDuracionTrayecto() {
		return Duration.between(getHoraSalida(), getHoraLlegada());
	}

	@Override
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posicion debe de ser intermedia", posicion > 1 && posicion <= estaciones.size());
		Checkers.check("El tren no puede llegar ni antes de la estacion previa ni despues de la estacion posterior",
				noLlegadaPreviaSalida(posicion, horaLlegada) && noSalidaPreviaLlegada(posicion, horaSalida));
		Checkers.check("El tren no puede salir antes de haber llegado", horaSalida.isBefore(horaLlegada));
		estaciones.add(posicion, estacion);
		horasLlegada.add(posicion, horaLlegada);
		horasSalida.add(posicion, horaSalida);
	}

	private Boolean noLlegadaPreviaSalida(int posicion, LocalTime horaLlegada) {
		Boolean res = true;
		if(getHorasSalida().get(posicion-1).isAfter(horaLlegada)) {
			res = false;
		}
		return res;
	}
	
	private Boolean noSalidaPreviaLlegada(int posicion, LocalTime horaSalida) {
		Boolean res = true;
		if(getHorasLlegada().get(posicion+1).isBefore(horaSalida)) {
			res = false;
		}
		return res;
	}

	@Override
	public void eliminarEstacionIntermedia(String estacion) {
		int pos = getEstaciones().indexOf(estacion);
		Checkers.check("No se puede eliminar la estación", 1 < pos && pos < getEstaciones().size());
		estaciones.remove(pos);
		horasLlegada.remove(pos);
		horasSalida.remove(pos);
	}
	
	public int hashCode() {
		return Objects.hash(getNombre(), getHoraSalida(), getCodigoTren());
	}

	@Override
	public int compareTo(TrayectoTren o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
