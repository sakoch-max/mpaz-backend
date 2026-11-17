package cl.mpaz.inventarioservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner cargarDatosIniciales(EquipoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Equipo("Kit LEGO WeDo 2.0", "Robótica", "Estante A1", 5, "Kit de robótica educativa básica para aula"));
                repository.save(new Equipo("Proyector Epson PowerLite", "Audiovisual", "Estante B2", 4, "Proyector HDMI alta luminosidad para salas"));
                repository.save(new Equipo("Parlante Portátil Bluetooth JBL", "Audiovisual", "Estante B1", 4, "Sistema de audio amplificado con micrófono"));
                repository.save(new Equipo("Cámara Digital Canon EOS Rebel", "Audiovisual", "Estante C1", 3, "Cámara réflex 24.1 MP para talleres"));
                repository.save(new Equipo("Tablet Samsung Galaxy Tab A8", "Computación", "Gabinete D1", 12, "Tablet 10.5 pulgadas con funda protectora"));
                System.out.println(">>> Catálogo inicial cargado en Neon con éxito <<<");
            }
        };
    }
}