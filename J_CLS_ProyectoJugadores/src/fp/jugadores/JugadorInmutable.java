package fp.jugadores;

import java.time.LocalDate;

public record JugadorInmutable( // Son clases cuyos valores serán costultables pero inmutables
		String nombre,
		LocalDate fechaNacimiento,
		Double altura,
		String nacionalidad,
		Integer goles) {
	
	// Trae el construcctor canónico, los getters, toString, equals y hashCode
	// Hay que implementar las propiedades derivadas, las restricciones y el compareTo
	
	public JugadorInmutable{
		// Hay que implementar y definir los checkers
		checkGoles(goles);
	}
	
	// Definicion del checker checkGoles
	private void checkGoles(Integer goles) {
		if (goles<0) {		// Las funciones del record vienen con el nombre del atrib sin ()
			throw new IllegalArgumentException("Los goles no pueden ser menores que 0");
		}
	}
	
	// Hay que definir las clases derivadas
	public Integer getEdad() {
		return fechaNacimiento.until(LocalDate.now()).getYears();
		// return fechaNacimento.hasta(ahora).cogerAños()
	}
	
	// Hay que implementar el compareTo
	public int compareTo(JugadorInmutable o) {
		int r = this.goles().compareTo(o.goles()); // r es la comparación de los goles, pudiendo adoptar (+, - o 0)
		if (r==0) { // Si los goles son iguales
			r = this.nacionalidad.compareTo(o.nacionalidad()); // r adopta la nacionalidad y la compara
			// no hay que redefinir r como un int ya q lo hicimos arriba al inicializarlo
		}
		return r;
	}
	
}