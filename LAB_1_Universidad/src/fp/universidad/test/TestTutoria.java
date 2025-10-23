package fp.universidad.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.universidad.tipos.Tutoria;

public class TestTutoria {

	public static void main(String[] args) {
		
		Tutoria tut1 = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(10, 40));
		System.out.println(tut1);
		
		try {
			Tutoria tue = new Tutoria(DayOfWeek.SUNDAY, LocalTime.of(10, 30), LocalTime.of(10, 40));
			System.out.println(tue);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			Tutoria tue = new Tutoria(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30));
			System.out.println(tue);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			Tutoria tue = new Tutoria(DayOfWeek.TUESDAY, LocalTime.of(10, 30), 20);
			System.out.println(tue);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(tut1.getDuracion());
	}
}
