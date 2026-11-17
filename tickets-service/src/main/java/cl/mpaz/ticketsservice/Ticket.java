package cl.mpaz.ticketsservice;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String docenteEmail;
    private String sala;
    private String fechaInicio;      // Formato ISO: "2026-11-20T14:00:00"
    private String fechaDevolucion;  // Formato ISO: "2026-11-20T16:00:00"
    private String estado;           // "PENDIENTE", "APROBADO", "RECHAZADO", "DEVUELTO"
    private String motivoRechazo;
    private String equiposResumen;   // Ej: "Proyector Epson (x1), Parlante JBL (x1)"

    public Ticket() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDocenteEmail() { return docenteEmail; }
    public void setDocenteEmail(String docenteEmail) { this.docenteEmail = docenteEmail; }
    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMotivoRechazo() { return motivoRechazo; }
    public void setMotivoRechazo(String motivoRechazo) { this.motivoRechazo = motivoRechazo; }
    public String getEquiposResumen() { return equiposResumen; }
    public void setEquiposResumen(String equiposResumen) { this.equiposResumen = equiposResumen; }
}