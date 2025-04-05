package parcial_2_2023;

import java.util.Comparator;

public class ComparadorTareas implements Comparator<Tarea> {
	
	@Override
	public int compare(Tarea t1, Tarea t2) {
		if(!t1.tienePlazo() && !t2.tienePlazo()) {
			return 1;
		}
		return t1.plazo().compareTo(t2.plazo());
	}
}
