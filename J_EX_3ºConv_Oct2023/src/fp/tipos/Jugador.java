package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import fp.utiles.Checkers;

public class Jugador {
	
	private String nombre;
	private LocalDate fechaDeNacimiento;
	private Integer edad;
	private Posicion posicion;
	private Integer goles;
	private Integer asistencias;
	private Equipo equipo;
	private List<String> lesiones;
	private Boolean campeon;
	
	//--------------------------------------------------------CONSTRUCTORES--------------------------------------------------------\\
	
	public Jugador(String nombre, LocalDate fechaDeNacimiento, Integer edad, Posicion posicion, Integer goles,
			Integer asistencias, Equipo equipo, List<String> lesiones, Boolean campeon) {
		Checkers.check("La fecha de nacimiento no puede ser anterior al 1970-01-01", fechaDeNacimiento.isAfter(LocalDate.of(1970, 01, 01)));
		Checkers.check("Los goles y asistencias deben ser números mayores o iguales a 0", goles >= 0 && asistencias >= 0);
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.edad = edad;
		this.posicion = posicion;
		this.goles = goles;
		this.asistencias = asistencias;
		this.equipo = equipo;
		this.lesiones = lesiones;
		this.campeon = campeon;
	}
	
	//------------------------------------------------------------MÉTODOS------------------------------------------------------------\\
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Integer getGoles() {
		return goles;
	}

	public Integer getAsistencias() {
		return asistencias;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public List<String> getLesiones() {
		return new ArrayList<String>(lesiones);
	}

	public Boolean getCampeon() {
		return campeon;
	}
	
	//-----------------------------------------------------PROPIEDADES DERIVADAS-----------------------------------------------------\\
	
	public Boolean mismaLesionConsecutiva() {
		return null;
	}
	
	//-------------------------------------------------------------COMÚN-------------------------------------------------------------\\
	
	

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", edad=" + edad
				+ ", posicion=" + posicion + ", goles=" + goles + ", asistencias=" + asistencias + ", equipo=" + equipo
				+ ", lesiones=" + lesiones + ", campeon=" + campeon + "]";
	}
	
	public int compareTo(Jugador o) {
		int r = this.getFechaDeNacimiento().compareTo(o.getFechaDeNacimiento());
		if (r==0) {
			r = this.getNombre().compareTo(o.getNombre());
		}
		return r;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaDeNacimiento, nombre);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(this == null || this.getClass() != obj.getClass()) return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento) && Objects.equals(nombre, other.nombre);
	}
	
	
}
