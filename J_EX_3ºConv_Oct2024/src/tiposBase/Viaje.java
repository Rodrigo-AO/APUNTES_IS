package tiposBase;

import java.time.Duration;
import java.util.List;
import utiles.Checkers;

public class Viaje {
	
	private Double precio;
	private Integer distancia;
	private Duration duracion;
	private TipoViaje tipoViaje;
	private List<Parada> trayecto;
	
	//----------------------------------------------------------CONSTRUCTORES----------------------------------------------------------\\
	public Viaje(Double precio, Integer distancia, Duration duracion, TipoViaje tipoViaje, Parada origen, Parada destino) {
		checkR1C1(origen, destino);
		checkR2(distancia, duracion, precio);
		checkR3C1(tipoViaje);
		this.precio = precio;
		this.distancia = distancia;
		this.duracion = duracion;
		this.tipoViaje = tipoViaje;
		this.trayecto = List.of(origen, destino);
	}
	
	public Viaje(Double precio, Integer distancia, Duration duracion, TipoViaje tipoViaje, List<Parada> trayecto) {
		checkR1C2(trayecto);
		checkR2(distancia, duracion, precio);
		checkR3C2(trayecto, tipoViaje);
		this.precio = precio;
		this.distancia = distancia;
		this.duracion = duracion;
		this.tipoViaje = tipoViaje;
		this.trayecto = trayecto;
	}
	
	//---------------------------------------------------------RESTRICCIONES---------------------------------------------------------\\
	private void checkR1C1(Parada origen, Parada destino) {
		Checkers.checkNoNull(origen);
		Checkers.checkNoNull(destino);
	}
	
	private void checkR1C2(List<Parada> trayecto) {
		Checkers.check("El trayecto ha de tener al menos 2 paradas", trayecto.size() >= 2);
	}
	
	private void checkR2(Integer distancia, Duration duracion, Double precio) {
		Checkers.check("La distancia ha de ser mayor a 0", distancia > 0);
		Checkers.check("La distancia ha de ser mayor a 0", duracion.getSeconds() > 0);
		Checkers.check("La distancia ha de ser mayor a 0", precio > 0);
	}

	private void checkR3C1(TipoViaje tipoViaje) {
		Checkers.check("Un viaje con solo 2 paradas no puede ser de tipo Transbordo", !(tipoViaje.equals(TipoViaje.Transbordo)));
	}
	
	private void checkR3C2(List<Parada> trayecto, TipoViaje tipoViaje) {
		Checkers.check("Un viaje con solo 2 paradas no puede ser de tipo Transbordo",
				!(trayecto.size() == 2 && tipoViaje.equals(TipoViaje.Transbordo)));
	}

	//------------------------------------------------------GETTERS AND SETTERS------------------------------------------------------\\
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public TipoViaje getTipoViaje() {
		return tipoViaje;
	}

	public void setTipoViaje(TipoViaje tipoViaje) {
		this.tipoViaje = tipoViaje;
	}

	public List<Parada> getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(List<Parada> trayecto) {
		this.trayecto = trayecto;
	}

	//-----------------------------------------------------PROPIEDADES DERIVADAS-----------------------------------------------------\\
	public Double getVelocidadMedia() {
		Integer distancia = this.distancia;
		Double duracion = this.duracion.toMinutes()/60.;
		return  distancia/duracion;
	}
	
	public Integer getNumeroParadas() {
		return this.trayecto.size()-2;
	}
	
	public List<String> getIntermedias() {
		List<Parada> paradas = this.trayecto;
		paradas.remove(0);
		paradas.remove(paradas.size()-1);
		List<String> intermedias = List.of();
		paradas.stream().map(parada -> intermedias.add(parada.nombre()));
		return intermedias;
	}
	
	public String getOrigen() {
		return this.trayecto.getFirst().nombre();
	}
	
	public String getDestino() {
		return this.trayecto.getLast().nombre();
	}
	
	public Integer getNumeroTrasbordos() {
		List<String> paradas = getIntermedias();
		Integer numeroTrasbordos = 0;
		for(int i = 1; i < paradas.size(); i++) {
			if(paradas.get(i).equals(paradas.get(i-1))) {
				numeroTrasbordos++;
			}
		}
		return numeroTrasbordos;
	}
	
	@Override
	public String toString() {
		return "Viaje [precio=" + precio + ", distancia=" + distancia + ", duracion=" + duracion + ", tipoViaje="
				+ tipoViaje + ", trayecto=" + trayecto + "]";
	}
	
}
