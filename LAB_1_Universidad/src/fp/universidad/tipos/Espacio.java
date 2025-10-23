package fp.universidad.tipos;

import java.util.Objects;
import fp.utiles.*;

public class Espacio{

	TipoEspacio tipoEspacio;
	String nombre;
	Integer planta;
	Integer capacidad;
	
	public Espacio(TipoEspacio tipoEspacio, String nombre, Integer planta, Integer capacidad) {
		this.tipoEspacio = tipoEspacio;
		this.nombre = nombre;
		this.planta = planta;
		setCapacidad(capacidad);
	}
	
	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public Espacio(String datos) {
		this(validaDatos(datos));								// record asume que se llamara a un constructor privado de String[]
	}
	
	private static String[] validaDatos(String datos) {			// validamos y creamos el String[]
		String[] cadena = datos.split(",");
		if(cadena.length != 4) {
			throw new IllegalArgumentException("La cadena introducida no tiene los datos requeridos");
		}
		return cadena;
	}
	
	// "A0.10,0,100,TEORIA"
	private Espacio(String[] cadena) {							// constructor privado con String[] que llama al canónico 
		this(TipoEspacio.valueOf(cadena[3].trim()), cadena[0].trim(), Integer.valueOf(cadena[1].trim()), Integer.valueOf(cadena[2].trim()));
	}

	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}
	
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		Checkers.check("La capacidad ha de ser mayor a 0 a", capacidad > 0);
		this.capacidad = capacidad;
	}
	
	public Integer getPlanta() {
		return planta;
	}
	
	public Espacio creaEspacio(String datos) {
		return new Espacio(datos);
	}
	
	public String toString() {
		return nombre + " (planta " + getPlanta() + ")";
	}
	
	public int hashCode() {
		return Objects.hash(getNombre(), getPlanta());
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(getNombre(), other.getNombre()) && Objects.equals(getPlanta(), other.getPlanta());
	}
	
	public int compareTo(Espacio esp) {
		int res = getPlanta().compareTo(esp.getPlanta());
		if(res==0) {
			res = getNombre().compareTo(getNombre());
		}
		return res;
	}
}
