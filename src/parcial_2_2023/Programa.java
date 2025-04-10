package parcial_2_2023;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {
		Tarea t1 = new Tarea("Hacer POO", LocalDate.of(2025, 4, 10));
		Tarea t2 = new Tarea("Hacer ISO", LocalDate.of(2025, 4, 12));
		Tarea t3 = new Tarea("Hacer AED", LocalDate.of(2025, 4, 13));
		Tarea t4 = new Tarea("Hacer ALF", LocalDate.of(2025, 4, 14));
		Tarea t5 = new Tarea("Hacer AEC", LocalDate.of(2025, 4, 15));
		Tarea t6 = new Tarea("Hacer REDES", LocalDate.of(2025, 4, 16));
				
		LinkedList<Agenda> agendas = new LinkedList<Agenda>();
		AgendaPersonal a1 = new AgendaPersonal();
		AgendaPersonal a2 = new AgendaPersonal();

		a1.agregarTarea(t1);
		a1.agregarTarea(t2);
		a1.agregarTarea(t3);
		
		a1.setUrgente(t3);
		a1.agregarTareas(t4, t5);
		a1.eliminarTarea(t5);
		a1.setUrgente(t1);
		a1.mostrarTareasDestacadas();
		agendas.add(a1);
		
		a2.agregarTarea(t6);
		agendas.add(a2);
		
		for (Agenda a : agendas) {
			if (a.getClass() == AgendaPersonal.class) {
				System.out.println(((AgendaPersonal) a).getUrgentes());
			}
		}
	}

}
