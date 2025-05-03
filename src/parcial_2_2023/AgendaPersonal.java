package parcial_2_2023;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AgendaPersonal extends Agenda{

	// Atributos
	private HashSet<Tarea> urgentes;
	
	// Constructor
	public AgendaPersonal() {
		super();
		this.urgentes = new HashSet<Tarea>();
	}
	
	// Getters and Setters
	public Set<Tarea> getUrgentes(){
		return Collections.unmodifiableSet(urgentes);
	}
	
	public boolean setUrgente(Tarea t) {
		if (t.tienePlazo()) {
			return urgentes.add(t);
		}
		return false;
	}
	
	public boolean unsetUrgente(Tarea t) {
		return urgentes.remove(t);
	}
	
	public boolean isUrgente(Tarea t) {
		return urgentes.contains(t);
	}
	
	@Override
	protected boolean esDestacada(Tarea t) {
		if (t.plazo().equals(LocalDate.now()) && this.isUrgente(t)) {
			
			return true;
		}
		return false;
	}
	
	@Override
	public AgendaPersonal clone() throws CloneNotSupportedException {
		AgendaPersonal copia = (AgendaPersonal) super.clone();
		copia.urgentes = new HashSet<Tarea>(urgentes);
		return copia;
	}

	@Override
	public String toString() {
		return "AgendaPersonal [" + super.toString() + " urgentes=" + urgentes + "]";
	}

	
}
