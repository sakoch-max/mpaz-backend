package cl.mpaz.inventarioservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    @Autowired
    private EquipoRepository repository;

    // Obtener todo el catálogo
    @GetMapping
    public List<Equipo> listarEquipos() {
        return repository.findAll();
    }

    // Crear un equipo nuevo
    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return repository.save(equipo);
    }

    // Actualizar stock
    @PutMapping("/{id}/stock")
    public ResponseEntity<Equipo> actualizarStock(@PathVariable Long id, @RequestParam int cambio) {
        return repository.findById(id).map(equipo -> {
            int nuevoStock = equipo.getStockDisponible() + cambio;
            if (nuevoStock < 0) {
                return ResponseEntity.badRequest().<Equipo>build();
            }
            equipo.setStockDisponible(nuevoStock);
            return ResponseEntity.ok(repository.save(equipo));
        }).orElse(ResponseEntity.notFound().build());
    }
}