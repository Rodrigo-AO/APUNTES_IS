package fp.jugadores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

// Si mi clase tiene un orden natural -> implements Comparable <T>
public class Jugador implements Comparable<Jugador>{

	// Atributos
		private String nombre;
		private LocalDate fechaNacimiento;
		private Double altura;
		private String nacionalidad;
		private Integer goles;
		
		// Constructor
		public Jugador
		(String nombre, LocalDate fechaNacimiento, Double altura, String nacionalidad, Integer goles) {
			// Checkers
			checkGoles(goles);
			// Asignaciones de valor al parametro
			this.nombre = nombre;
			this.fechaNacimiento = fechaNacimiento;
			this.altura = altura;
			this.nacionalidad = nacionalidad;
			this.goles = goles;
			// En ocasiones puede que no sepamos los valores de algún paramentro
			// Tendremos que usar un "null"
		}
		
		// Contructor 2 (valores desconocidos "null")
		public Jugador
		(String nombre, LocalDate fechaNacimiento, Integer goles) {
			this.nombre = nombre;
			this.fechaNacimiento = fechaNacimiento;
			this.altura = null;
			this.nacionalidad = null;
			this.goles = goles;
		}
		
		// Constructor 3 (de string a objeto): "Jugador 3, 28/06/1990, 1.75, Español, 17"
		public Jugador
		(String s) {
			String[] datos = s.split(",");
			// Comprobacion de longitud de cadena
			if (datos.length != 5) {
				throw new IllegalArgumentException("Cadena con formato no válido");
			}
			String nombre = datos[0].trim();
			LocalDate fechaNacimiento =
					LocalDate.parse(datos[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Double altura = Double.valueOf(datos[2].trim());
			String nacionalidad = datos[3].trim();
			Integer goles = Integer.valueOf(datos[4].trim());
			
			checkGoles(goles);
			this.nombre = nombre;
			this.fechaNacimiento = fechaNacimiento;
			this.altura = altura;
			this.nacionalidad = nacionalidad;
			this.goles = goles;	
		}
		
		// Métodos
		
		// Checkers (Restricciones)
		private void checkGoles(Integer goles) {
			if (goles<0) {
				throw new IllegalArgumentException("Los goles no pueden ser negativos");
			}
		}
		
		// Getters
		public String getNombre() {
			return nombre;
		}
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		public Double getAltura() {
			return altura;
		}
		public String getNacionalidad() {
			return nacionalidad;
		}
		public Integer getGoles() {
			return goles;
		}
		
		// Para evitar errores, en los metodos setters emplearemos los checkers
		public void setGoles(Integer nuevosGoles) {
			checkGoles(nuevosGoles);
			this.goles = nuevosGoles;
		}
		
		
		// To String
		public String toString() {
			return "Jugador [getNombre()=" + getNombre() + ", getFechaNacimiento()=" + getFechaNacimiento()
					+ ", getAltura()=" + getAltura() + ", getNacionalidad()=" + getNacionalidad() +
					", getGoles()=" + getGoles() + "]";
		}
		
		
		// Comparadore hashCode() y equals()
		
		// hashCode() 
		// Devuelve un numero de 32 bits para cualquier objeto
		// 2 objetos pueden tener el mismo hashCode sin ser iguales, por lo que no es muy preciso
		public int hashCode() {
			return Objects.hash(goles, nacionalidad);
		}
		
		// equals()
		// Compara dos objetos a nivel de contenido, usando por defento Object
		public boolean equals(Object obj) { 
			if (this == obj) return true;						// Comprueba si tienen la misma referencia
			if (obj == null) return false;						// Comprueba si es null (nunca pudiendo ser igual)
			if (getClass() != obj.getClass()) return false;		// Comprueba si son diferentes clases
			Jugador other = (Jugador) obj;						// Lo convierte a jugador para acceder a los atributos
			return Objects.equals(goles, other.goles)
					&&											// Compara los atributos
					Objects.equals(nacionalidad, other.nacionalidad);
			// ¿Qué son las referencias?: ruta de memoria en la que se guarda el objeto
			// Si p1=Juan, p2=p1 y p3=Juan, p1 y p2 tienen la misma ruta de memoria, por ende, la misma referencia
			// pero p3, aun siendo el mismo contenido, tiene diferente referencia. Esto causaría este resultado:
			// syso(p1 == p2) -> True, syso(p1 == p3) -> False, syso(p1.equals(p3)) -> True
		}
		
		// CompareTo
		// Para comparar dos valores, podemos usar compareTo, pudiendo dar negativo, obj1<obj2,
		// 0, obj1=obj2, o positivo obj1>obj2
		public int compareTo(Jugador o) {
			int r = this.getGoles().compareTo(o.getGoles()); // r será la comparacion de los goles (+, 0 o -)
			if (r==0) {
				r = this.nacionalidad.compareTo(o.getNacionalidad());
			}
			return r;
		}
}