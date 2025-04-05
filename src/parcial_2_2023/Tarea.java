package parcial_2_2023;

import java.time.LocalDate;

public record Tarea(String descripcion, LocalDate plazo) {

	public Tarea(String texto) {
		this(texto, null);
	}
	
	public boolean tienePlazo() {
		return plazo() != null;
	}
	
	public boolean isVencida() {
		return plazo() != null && plazo().isAfter(LocalDate.now());
	}
}
