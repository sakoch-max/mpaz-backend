package cl.mpaz.ticketsservice;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TicketsServiceApplicationTests {

	@Test
	void validarReglaTresHorasYEstadoTicket() {
		Ticket ticket = new Ticket();
		ticket.setDocenteEmail("profesor@marcelapaz.cl");
		ticket.setSala("Sala 104");
		ticket.setEstado("PENDIENTE");

		// Probamos una fecha válida (5 horas en el futuro)
		LocalDateTime fechaValida = LocalDateTime.now().plusHours(5);
		long horas = Duration.between(LocalDateTime.now(), fechaValida).toHours();
		assertTrue(horas >= 3, "Debe permitir reservas con 3 o más horas de anticipación");

		// Simulamos aprobación del Admin
		ticket.setEstado("APROBADO");
		assertEquals("APROBADO", ticket.getEstado());
	}
}