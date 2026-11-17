package cl.mpaz.inventarioservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventarioServiceApplicationTests {

	@Test
	void verificarCreacionYStockDeEquipo() {
		Equipo proyector = new Equipo("Proyector Epson", "Audiovisual", "Estante B2", 4, "Proyector HDMI");

		assertEquals("Proyector Epson", proyector.getNombre());
		assertEquals(4, proyector.getStockDisponible());

		// descuento de stock
		proyector.setStockDisponible(proyector.getStockDisponible() - 1);
		assertEquals(3, proyector.getStockDisponible());
	}
}