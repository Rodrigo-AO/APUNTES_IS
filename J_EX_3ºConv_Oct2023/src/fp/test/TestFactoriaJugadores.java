package fp.test;

import fp.tipos.*;

public class TestFactoriaJugadores {

	public static void main(String[] args) {

		Jugador j1 = FactoriaJugadores.parseaJugador("Lionel Messi;1987-06-24;DELANTERO;35;25;[Tobillo izquierdo, Gemelo derecho, Gemelo derecho];FC Barcelona;1;Estadio Camp Nou");
		Jugador j2 = FactoriaJugadores.parseaJugador("Sergio Ramos;1986-03-30;DEFENSOR;8;3;[Gemelo derecho, Tobillo izquierdo];Real Madrid;3;Estadio Santiago Bernabéu");
		Jugador j3 = FactoriaJugadores.parseaJugador("Marc-André ter Stegen;1992-04-30;PORTERO;0;0;[];FC Barcelona;1;Estadio Camp Nou");
		Jugador j4 = FactoriaJugadores.parseaJugador("Mikel Oyarzabal;1997-04-21;DELANTERO;15;9;[Rodilla izquierda];Real Sociedad;8;Estadio Anoeta");
		Jugador j5 = FactoriaJugadores.parseaJugador("Koke;1992-01-08;CENTROCAMPISTA;7;15;[Muslo izquierdo, Tobillo derecho, Tobillo derecho];Atletico Madrid;2;Estadio Wanda Metropolitano");
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(j3);
		System.out.println(j4);
		System.out.println(j5);
		
	}

}
