package cl.mpaz.historialservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*")
public class HistorialController {

    @Autowired
    private HistorialRepository repository;

    @GetMapping
    public List<RegistroMovimiento> listarHistorial() {
        return repository.findAll();
    }

    @PostMapping
    public RegistroMovimiento registrarMovimiento(@RequestBody RegistroMovimiento movimiento) {
        return repository.save(movimiento);
    }
}