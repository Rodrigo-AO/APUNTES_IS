package fp.sevici;

import java.util.Objects;

import fp.utiles.Checkers;

public record Coordenada(Double latitud, Double longitud, UnidadMedida unidad) {

	public Coordenada{
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º", -90 <= latitud() && latitud() <= 90);
		Checkers.check("La lontigud debe estar comprendida entre -90º y +90º", -180 <= longitud() && longitud() <= 180);
	}
	
	public Coordenada(Double latitud, Double longitud) {
		this(latitud, longitud, UnidadMedida.GRADOS);
	}
	
	public Coordenada() {
		this(0., 0., UnidadMedida.GRADOS);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(latitud(), longitud());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Coordenada other = (Coordenada) obj;
		return Objects.equals(latitud(), other.latitud()) && Objects.equals(longitud(), other.longitud());
	}
	
	public Coordenada aRadianes() {
		Coordenada res = null;
		if(unidad == UnidadMedida.RADIAN) {
			res = new Coordenada(latitud(), longitud(), unidad());
		} else {
			res = new Coordenada(Math.toRadians(latitud()), Math.toRadians(longitud()), UnidadMedida.RADIAN);
		}
		return res;
	}
	
	public Coordenada aGrados() {
		Coordenada res = null;
		if(unidad == UnidadMedida.GRADOS) {
			res = new Coordenada(latitud(), longitud(), unidad());
		} else {
			res = new Coordenada(Math.toDegrees(latitud()), Math.toDegrees(longitud()), UnidadMedida.GRADOS);
		}
		return res;
	}
	
	public Double getDistanciaHaversine(Coordenada c) {
		Coordenada c1 = aGrados();
		Coordenada c2 = c.aGrados();
		
		Double difLat = c1.latitud() - c2.latitud();
		Double difLon = c1.longitud() - c2.longitud();
		
		Double aux = Math.pow(Math.sin(difLat/2), 2) + Math.cos(c1.latitud()) *
				Math.cos(c2.latitud()) + Math.pow(Math.sin(difLon/2), 2);
		
		return 2 * 6372.8 * Math.asin(Math.sqrt(aux));
	}
	
}
