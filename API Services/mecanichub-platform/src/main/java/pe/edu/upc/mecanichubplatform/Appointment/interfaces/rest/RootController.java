package pe.edu.upc.mecanichubplatform.Appointment.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Tag(name = "Root")
public class RootController {
    @GetMapping
    public ResponseEntity<Void> root() {
        return ResponseEntity.ok().build();
    }
}
