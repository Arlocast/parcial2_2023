package parcial_2_2023;

import java.util.Comparator;

public class ComparadorTareas implements Comparator<Tarea> {
	
	@Override
	public int compare(Tarea t1, Tarea t2) { // -1: < 0: = 1: >
		if(!t1.tienePlazo() && t2.tienePlazo()) { // 1º null, osea es mayor
			return 1;
		}
		else if (t1.tienePlazo() && !t2.tienePlazo()) { // 2º null, osea es mayor
			return -1;
		}
		else if (!t1.tienePlazo() && !t2.tienePlazo()) { // ambas null, iguales
			return 0;
		}
		return t1.plazo().compareTo(t2.plazo());
	}
}
