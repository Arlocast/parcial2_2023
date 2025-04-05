package parcial_2_2023;

import java.time.LocalDate;

public record Tarea(String texto, LocalDate fecha) {

	public Tarea(String texto) {
		this(texto, null);
	}
}
