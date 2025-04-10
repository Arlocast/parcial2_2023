package parcial_2_2023;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Agenda {

	// Atributos
	private LinkedList<Tarea> todas;
	private LinkedList<Tarea> completas;
	private HashMap<LocalDate, LinkedList<Tarea>> tareasPorFecha;
	
	// Contructor
	public Agenda() {
		this.todas = new LinkedList<Tarea>();
		this.completas = new LinkedList<Tarea>();
		this.tareasPorFecha = new HashMap<LocalDate, LinkedList<Tarea>>();
	}
	
	// Getters
	public List<Tarea> getTodas(){
		return Collections.unmodifiableList(todas);
	}
	
	public List<Tarea> getTareasPorFecha(LocalDate fecha){
		LinkedList<Tarea> tareasDeEsaFecha = tareasPorFecha.get(fecha);
		if (tareasDeEsaFecha == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(tareasDeEsaFecha);
	}
	
	// Funcionalidad
	public LinkedList<Tarea> getPendientes(){
		LinkedList<Tarea> pendientes = new LinkedList<Tarea>();
		for (Tarea t : todas) {
			if(!completas.contains(t) && !t.isVencida()) { // Las pendientes deben no estar completas ni vencidas o con que cumplan una vale?
				pendientes.add(t);
			}
		}
		return pendientes;
	}
	
	// Método sobrecargado para ordenar las pendientes
	public LinkedList<Tarea> getPendientes(Comparator<Tarea> comparador){
		LinkedList<Tarea> pendientes = this.getPendientes();
		Collections.sort(pendientes, comparador);
		return pendientes;
	}
	
	public LinkedList<LocalDate> listarPlazosPendientes(){
		LinkedList<LocalDate> plazosPendientes =  new LinkedList<LocalDate>();
		for (Tarea t : this.getPendientes()) {
			plazosPendientes.add(t.plazo()); // No comprueba duplicados
		}
		return plazosPendientes;
	}
	
	protected void eliminarTarea(Tarea t) {
		Iterator<Tarea> iterador = todas.iterator();
		while(iterador.hasNext()) {
			Tarea sig = iterador.next();
			if (sig.equals(t)) {
				iterador.remove(); // Elimina el último elemento retornado por iterator.next()
			}
		}
	}
	
	public boolean agregarTarea(Tarea t) {
		
		// Me da las tareas asociadas a ese plazo
		LinkedList<Tarea> tareas = tareasPorFecha.get(t.plazo()); 
		
		// En caso de que la clave no exista la creamos
		if (tareas == null) tareas = new LinkedList<Tarea>();
		
		// La añadimos a la lista y al mapa
		tareas.add(t);
		tareasPorFecha.put(t.plazo(), tareas);

		// Comprobar que no esté repetida. Es decir acceder al mapa en esa fecha y ver si ya hay una tarea con esa misma desc
		for (Tarea tarea : tareas) {
			if (tarea.descripcion().equals(t.descripcion())){
				return false;
			}
		}
		todas.add(t);
		return true;
	}
	
	public LinkedList<Tarea> agregarTareas(Tarea... tareas){
		LinkedList<Tarea> agregadas = new LinkedList<Tarea>();
		for (Tarea t : tareas) {
			if (this.agregarTarea(t)) {
				agregadas.add(t);
			}
		}
		return agregadas;
	}
	
	protected abstract boolean esDestacada(Tarea t);
	
	public final void mostrarTareasDestacadas(){ // LinkedList<Tarea>
		// LinkedList<Tarea> destacadas = new LinkedList<Tarea>();
		for (Tarea t : this.getPendientes(new ComparadorTareas())) {
			if (this.esDestacada(t)) {
				System.out.println("Destacada: " + t);
				// destacadas.add(t);
			}
		}
		// return destacadas;
	}
	
	// Sobreescribimos el método clone
	@Override
	public Agenda clone() throws CloneNotSupportedException{
		Agenda copia = (Agenda) super.clone();
		copia.todas = new LinkedList<Tarea>(todas);
		copia.completas = new LinkedList<Tarea>();
		copia.tareasPorFecha = new HashMap<LocalDate, LinkedList<Tarea>>();
		
		return copia;
	}

	@Override
	public String toString() {
		return "todas=" + todas + ", completas=" + completas + ", tareasPorFecha=" + tareasPorFecha;
	}
	
	
}
