package cl.mpaz.historialservice;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_movimientos")
public class RegistroMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private String accion;       // "RESERVA_CREADA", "TICKET_APROBADO", "TICKET_RECHAZADO"
    private String responsable;  // Email del docente o admin
    private String fechaHora;

    public RegistroMovimiento() {}

    @PrePersist
    public void asignarFecha() {
        if (this.fechaHora == null) {
            this.fechaHora = LocalDateTime.now().toString();
        }
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }
    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
}