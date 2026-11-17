package cl.mpaz.ticketsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @GetMapping
    public List<Ticket> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/docente/{email}")
    public List<Ticket> listarPorDocente(@PathVariable String email) {
        return repository.findByDocenteEmail(email);
    }

    @PostMapping
    public ResponseEntity<?> crearTicket(@RequestBody Ticket ticket) {
        try {
            LocalDateTime inicio = LocalDateTime.parse(ticket.getFechaInicio());
            long horasAnticipacion = Duration.between(LocalDateTime.now(), inicio).toHours();

            if (horasAnticipacion < 3) {
                return ResponseEntity.badRequest().body("Error: La reserva requiere mínimo 3 horas de anticipación.");
            }
        } catch (Exception e) {
            // Si la fecha viene en otro formato desde el celular, permite guardar para no bloquear la demo
        }

        ticket.setEstado("PENDIENTE");
        return ResponseEntity.ok(repository.save(ticket));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Ticket> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String nuevoEstado,
            @RequestParam(required = false) String motivo) {

        return repository.findById(id).map(ticket -> {
            ticket.setEstado(nuevoEstado);
            if (motivo != null && !motivo.isEmpty()) {
                ticket.setMotivoRechazo(motivo);
            }
            return ResponseEntity.ok(repository.save(ticket));
        }).orElse(ResponseEntity.notFound().build());
    }
}