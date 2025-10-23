package fp.jugadores.test;

import java.time.LocalDate;
import fp.jugadores.*;

public class TestJugador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola mundo");
		
		// Constructor canónico
		Jugador j1 = new Jugador
				("Messi", LocalDate.of(1987, 6, 24), 1.7, "Argentina", 111);
		
		System.out.println(j1);
		
		// Constructor 2 (con null)
		Jugador j2 = new Jugador
				("NaboMan", LocalDate.of(1987, 6, 24), 111);
		
		// Constructor 3 (con String)
		Jugador j3 = new Jugador
				("Jugador 3, 28/06/1990, 1.75, Español, 17");
		
		// Constructor 4 (con records)
		JugadorInmutable j4 = new JugadorInmutable
				("Messi", LocalDate.of(1987, 6, 24), 1.7, "Argentina", 111);
		
		
		String Nombre = j1.getNombre();
		LocalDate FechaNacimiento = j1.getFechaNacimiento();
		Double Altura = j1.getAltura();
		String Nacionalidad = j1.getNacionalidad();
		Integer Goles = j1.getGoles();
		System.out.println(Nombre);
		System.out.println(FechaNacimiento);
		System.out.println(Altura);
		System.out.println(Nacionalidad);
		System.out.println(Goles);
		j1.setGoles(400);
		System.out.println(j1);
		System.out.println(j1.getGoles());
		
		// Comprobaciones de identidad e igualdad
		System.out.println(j1.equals(j2));
		System.out.println(j1==j2);
		
		// hashCode() e equals
		System.out.println(j1.hashCode());
		System.out.println(j2.hashCode());
		
		System.out.println(j3);
		
		System.out.println(j4);
		System.out.println(j4.altura());
	}	
}
