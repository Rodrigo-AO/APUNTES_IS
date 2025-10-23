package fp.universidad.tipos;

import java.time.LocalTime;
import java.util.Objects;

import fp.utiles.*;
import java.time.DayOfWeek;

public record Tutoria (DayOfWeek diaSemana, LocalTime horaComienzo, LocalTime horaFin) implements Comparable<Tutoria>{
	
	public Tutoria{
		Checkers.check("La tutoría solo puede reservarse de lunes a viernes", diaSemana != DayOfWeek.SATURDAY || diaSemana != DayOfWeek.SUNDAY);
		Checkers.check("La tutoría solo puede durar 15 minutos", getDuracion(horaComienzo, horaFin) <= 15);
	}

	public Tutoria(DayOfWeek diaSemana, LocalTime horaComienzo, Integer duracion) {
		this(diaSemana, horaComienzo, horaComienzo.plusMinutes(duracion));
	}

	public String getInicial(DayOfWeek diaSemana) {
		Checkers.check("La tutoría solo puede reservarse de lunes a viernes", diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY);
		String res = "";
		switch(diaSemana) {
		case MONDAY:
			res = "L"; break;
		case TUESDAY:
			res = "M"; break;
		case WEDNESDAY:
			res = "X"; break;
		case THURSDAY:
			res = "J"; break;
		case FRIDAY:
			res = "V"; break;
		default:
			break;
		}
		return res;
	}
	
	public Integer getDuracion(LocalTime horaComienzo, LocalTime horaFin) {
		Integer duracion = Integer.valueOf(horaFin.getMinute() - horaComienzo.getMinute());
		return duracion;
	}
	
	public Integer getDuracion() {
		Integer duracion = Integer.valueOf(horaFin.getMinute() - horaComienzo.getMinute());
		return duracion;
	}

	@Override
	public String toString() {
		return getInicial(diaSemana()) + " " + horaComienzo + "-" + horaFin;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Tutoria other = (Tutoria) obj;
		return Objects.equals(diaSemana(), other.diaSemana())
				&&
				Objects.equals(horaComienzo(), other.horaComienzo());
	}

	public int compareTo(Tutoria tut) {
		int res = diaSemana().compareTo(tut.diaSemana());
		if(res == 0) {
			res = horaComienzo().compareTo(tut.horaComienzo());
		}
		return res;
	}
}
