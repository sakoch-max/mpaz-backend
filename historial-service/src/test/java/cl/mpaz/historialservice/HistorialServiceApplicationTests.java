package cl.mpaz.historialservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistorialServiceApplicationTests {

	@Test
	void verificarRegistroAuditoría() {
		RegistroMovimiento mov = new RegistroMovimiento();
		mov.setTicketId(10L);
		mov.setAccion("TICKET_APROBADO");
		mov.setResponsable("admin@marcelapaz.cl");
		mov.asignarFecha();

		assertEquals(10L, mov.getTicketId());
		assertEquals("TICKET_APROBADO", mov.getAccion());
		assertNotNull(mov.getFechaHora());
	}
}