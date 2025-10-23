package fp.tipos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;

import fp.utiles.Checkers;

public class Vuelo {
	private Trayecto trayecto;
	private Double precio;
	private Integer numPasajeros;
	private Integer numPlazas;
	private String codigo;
	private LocalDate fecha;
	private Duration duracion;
	private List<String> tripulacion;
	private String destino;
	private String compañia;
	private String modelo;
	
	public Vuelo
	(Trayecto trayecyo, Double precio, Integer numPasajeros, Integer numPlazas,
			String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion, String destino) {
		Checkers.check("El número de plazas ha de ser mayor o igual a 0", numPlazas >= 0);
		Checkers.check("El numero de pasajeros ha de ser mayor a 0", numPasajeros > 0);
		Checkers.check("El precio ha de ser mayor a 0", precio > 0);
		Checkers.check("El número de pasajeros debe de ser menor o igual al número de plazas", numPasajeros <= numPlazas);
		this.trayecto = trayecyo;
		this.precio = precio;
		this.numPasajeros = numPasajeros;
		this.numPlazas = numPlazas;
		this.codigo = codigo;
		this.fecha = fecha;
		this.duracion = duracion;
		this.tripulacion = tripulacion;
		this.destino = destino;
	}
	
	public Trayecto getTrayecto() {
		return trayecto;
	}
	
	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}
	
	public String getCompañia() {
		return compañia;
	}
	
	public String getModelo() {
		return modelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(Integer numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public List<String> getTripulacion() {
		return tripulacion;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public void incrementaPrecioPorcentaje(Double porcentaje) {
		Double porcentajeIncrementado = precio*(porcentaje/100);
		this.precio = precio + porcentajeIncrementado;
	}
	
	public String toString() {
		return trayecto + ", " + codigo + ", " + fecha;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(getCodigo(), other.getCodigo())
				&& 
				Objects.equals(getFecha(), other.getFecha());
	}
}
