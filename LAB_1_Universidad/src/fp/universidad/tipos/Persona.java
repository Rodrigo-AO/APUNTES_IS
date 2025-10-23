package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Persona implements Comparable<Persona>{
	
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;

	public Persona(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email) {
		// checkDni1(dni); checkDni2(dni); checkEmail1(email); checkEmail2(email); checkEmail3(email);
		setDni(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		setEmail(email);
	}

	public Persona(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento) {
		this(dni, nombre, apellidos, fechaNacimiento, "");
	}
	
	// --------------------------------------- Constructor con String ----------------------------------------------------\\
	
	public Persona(String datos) {
		this(validaDatos(datos));
	}
	
	private static String[] validaDatos(String datos) {
		String[] cadena = datos.split(",");
		if(cadena.length != 5) {
			throw new IllegalArgumentException("La cadena introducida no tiene los datos requeridos");
		}
		return cadena;
	}
	
	// "12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es"
	private Persona(String[] cadena) {
		this(cadena[0].trim(), cadena[1].trim(), cadena[2].trim(),
				LocalDate.parse(cadena[3].trim(), DateTimeFormatter.ofPattern("d/M/yyyy")), cadena[4].trim());
	}
	
	// --------------------------------------- Constructor con String ----------------------------------------------------\\

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		checkDni1(dni); checkDni2(dni);
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		checkEmail(email); checkEmail1(email); checkEmail2(email); checkEmail3(email);
		this.email = email;
	}

	public Integer getEdad1() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}
	
	public Integer getEdad2() {
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}

	private void checkDni1(String dni) {
		if(dni.length() != 9) {
			throw new IllegalArgumentException("El DNI ha de tener 9 caracteres");
		}
		for(int i = 0; i<8; i++) {
			if(!Character.isDigit(dni.charAt(i))) {
				throw new IllegalArgumentException("Los primeros 8 caracteres del DNI han de ser dígitos");
			}
		}
		if(!Character.isLetter(dni.charAt(8))) {
			throw new IllegalArgumentException("El 9º caracter del DNI ha de ser una letra");
		}
	}
	
	private void checkDni2(String dni) {
		if(dni.length() != 9) {
			throw new IllegalArgumentException("El DNI ha de tener 9 caracteres");
		}
		if(esDigito(dni) || esLetra(dni)) {
			throw new IllegalArgumentException("Formato del DNI inválido");
		}
	}
	private Boolean esDigito(String dni) {
		Boolean digito = false;
		for(int i = 0; i<8; i++) {
			if(!Character.isDigit(dni.charAt(i))) {
				digito = true;
				break;
			}
		}
		return digito;
	}
	private Boolean esLetra(String dni) {
		Boolean letra = false;
		if(!Character.isLetter(dni.charAt(8))) {
			letra = true;
		}
		return letra;
	}
	
	private void checkEmail(String email) {
		String[] partes = email.split("@");
		if(partes.length !=2 && email != "") {
			throw new IllegalArgumentException("Formato de email invalido, ha de contener un (único) @");
		}
		if(partes.length == 2) {
			if(partes[0].isBlank() || partes[1].isBlank()) {	// isBlank() es igual a isEmpity() pero detecta también espacios
				throw new IllegalArgumentException("Formato de email invalido, no puede empezar ni terminar en @");
			}
		}
	}
	
	private void checkEmail1(String email) {
		String[] partes = email.split("@");
		if(partes.length != 2 && email != "") {
			throw new IllegalArgumentException("Formato de email invalido, ha de contener un @");
		}
	}
	
	private void checkEmail2(String email) {
		if(!email.contains("@") && email != "") {
			throw new IllegalArgumentException("Formato de email invalido, ha de contener un @");
		}
	}
	
	private void checkEmail3(String email) {
		String[] partes = email.split("@");
		if(partes.length !=2 && email != "") {
			throw new IllegalArgumentException("Formato de email invalido, ha de contener un (único) @");
		}
		if(partes.length == 2) {
			if(partes[0].isBlank() || partes[1].isBlank()) {	// isBlank() es igual a isEmpity() pero detecta también espacios
				throw new IllegalArgumentException("Formato de email invalido, no puede empezar ni terminar en @");
			}
		}
	}

	public String toString() {
		return dni + " - " + apellidos + ", " + nombre + " - " + 
				fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	};

	public int hashCode() {
		return Objects.hash(getDni(), getNombre(), getApellidos());
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Persona other = (Persona) obj;
		return Objects.equals(getDni(), other.getDni()) && Objects.equals(getNombre(), other.getNombre())
				&& Objects.equals(getApellidos(), other.getApellidos());
	}

	public int compareTo(Persona pers) {
		int res = getApellidos().compareTo(pers.getApellidos());
		if(res == 0) {
			res = getNombre().compareTo(pers.getNombre());
			if(res == 0) {
				res = getDni().compareTo(pers.getDni());
			}
		}
		return res;
	}
}