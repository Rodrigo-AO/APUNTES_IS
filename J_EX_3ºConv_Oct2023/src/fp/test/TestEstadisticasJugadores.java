package fp.test;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import fp.tipos.Equipo;
import fp.tipos.EstadisticasJugadores;
import fp.tipos.FactoriaJugadores;
import fp.tipos.Jugador;

public class TestEstadisticasJugadores {

	public static void main(String[] args) {
		
		Jugador j1 = FactoriaJugadores.parseaJugador("Lionel Messi;1987-06-24;DELANTERO;35;25;[Tobillo izquierdo, Gemelo derecho, Gemelo derecho];FC Barcelona;1;Estadio Camp Nou");
		Jugador j2 = FactoriaJugadores.parseaJugador("Sergio Ramos;1986-03-30;DEFENSOR;8;3;[Gemelo derecho, Tobillo izquierdo];Real Madrid;3;Estadio Santiago Bernabéu");
		Jugador j3 = FactoriaJugadores.parseaJugador("Marc-André ter Stegen;1992-04-30;PORTERO;0;0;[];FC Barcelona;1;Estadio Camp Nou");
		Jugador j4 = FactoriaJugadores.parseaJugador("Mikel Oyarzabal;1997-04-21;DELANTERO;15;9;[Rodilla izquierda];Real Sociedad;8;Estadio Anoeta");
		Jugador j5 = FactoriaJugadores.parseaJugador("Koke;1992-01-08;CENTROCAMPISTA;7;15;[Muslo izquierdo, Tobillo derecho, Tobillo derecho];Atletico Madrid;2;Estadio Wanda Metropolitano");
		Set<Jugador> conjunto = new HashSet<Jugador>();
		conjunto.add(j1); conjunto.add(j2); conjunto.add(j3); conjunto.add(j4); conjunto.add(j5); 
		EstadisticasJugadores est = new EstadisticasJugadores(conjunto);
		System.out.println(est.getNumeroLesionesDistintas(1));
		
		SortedMap<Equipo, String> jugadorGAEquipo = est.getNombreJugadorConMayorSumaGAPorEquipo();
		System.out.println(jugadorGAEquipo);

	}

}
