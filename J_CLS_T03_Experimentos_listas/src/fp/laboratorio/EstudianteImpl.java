package fp.laboratorio;

/**
 * Clase que implementa la intefaz Estudiante
 * 
 * @author Toñi Reina
 * @version 1.0.0 22/01/2019
 */
public class EstudianteImpl implements Estudiante {

	//Atributos
	private String nombre;
	private String apellidos;
	private String uvus;
	private Double puntos;
	
	/**
	 * @param nombre Nombre del estudiante.
	 * @param apellidos Apellidos del estudiante.
	 * @param uvus UVUS del estudiante.
	 * Crea un estudiante con un nombre, unos apellidos y un uvus. El estudiante tendrá 0 puntos.
	 */
	//Constructor
	public EstudianteImpl(String nombre, String apellidos, String uvus) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.uvus = uvus;
		this.puntos = 0.0;
	}
	
	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#getNombre()
	 */
	//Método observador -básica
	public String getNombre() {
		return nombre;
	}
	
	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#setNombre(java.lang.String)
	 */
	//Modificador
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}

	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#getApellidos()
	 */
	//consultor
	public String getApellidos() {
		return apellidos;
	}

	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#setApellidos(java.lang.String)
	 */
	//modificador
	public void setApellidos(String nuevosApellidos) {
		this.apellidos = nuevosApellidos;
	}

	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#getUVUS()
	 */
	//consultor
	public String getUVUS() {
		return uvus;
	}
	
	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#getIniciales()
	 */
	//consultor - derivada
	public String getIniciales() {
		return getNombre().trim().charAt(0)+"." +getApellidos().trim().charAt(0)+".";
	}

	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#getPuntos()
	 */
	//observadora
	public Double getPuntos() {
		return puntos;
	}

	/* (non-Javadoc)
	 * @see fp.laboratorio.Estudiante#sumarPuntos(java.lang.Double)
	 */
	//operacion - modificador
	public void sumarPuntos(Double puntosAdicionales) {
		this.puntos += puntosAdicionales;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Representación como cadena
	public String toString() {
		return getApellidos()+"," + getNombre()+" - " + getUVUS()+ "- Puntos:" + getPuntos();
	}
	
	
	public boolean equals(Object obj) {
		boolean res = false;
		
			if (obj instanceof Estudiante) {
				Estudiante e = (Estudiante)obj;
				res = this.getNombre().equals(e.getNombre()) 
						&& this.getApellidos().equals(e.getApellidos())
						&& this.getUVUS().equals(e.getUVUS());
			}
		
		return res;
	}
	
	public int hashCode() {
		return getNombre().hashCode() + 31* getApellidos().hashCode() + 31* 31* getUVUS().hashCode();
	}
	

	public int compareTo(Estudiante o) {
		int res = this.getApellidos().compareTo(o.getApellidos());
		if (res == 0) {
			res = this.getNombre().compareTo(o.getNombre());
			if (res == 0) {
				res = this.getUVUS().compareTo(o.getUVUS());
			}
		}
		
		return res;
	}
}
