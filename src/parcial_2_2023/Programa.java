package parcial_2_2023;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {
		Tarea t1 = new Tarea("Hacer POO", LocalDate.of(2025, 4, 11));
		Tarea t2 = new Tarea("Hacer ISO", LocalDate.of(2025, 4, 12));
		Tarea t3 = new Tarea("Hacer AED", LocalDate.of(2025, 4, 13));
				
		LinkedList<Agenda> agendas = new LinkedList<Agenda>();
		AgendaPersonal a1 = new AgendaPersonal();
		a1.agregarTarea(t1);
		a1.agregarTarea(t2);
		a1.agregarTarea(t3);
		a1.setUrgente(t3);
		for (Agenda a : agendas) {
			if (a.getClass() == AgendaPersonal.class) {
				System.out.println(((AgendaPersonal) a).getUrgentes());
			}
		}
		System.out.println("Hola");
	}

}
