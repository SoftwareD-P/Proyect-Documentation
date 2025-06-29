package pe.edu.upc.mecanichub.Monitoring.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Monitoring.application.MonitoringService;
import pe.edu.upc.mecanichub.Monitoring.domain.model.aggregates.Monitoring;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitorings")
@Tag(name = "Monitorings", description = "CRUD for monitoring records with database persistence")
public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping
    @Operation(summary = "Get all monitoring records")
    public List<Monitoring> getAllMonitorings() {
        return monitoringService.getAllMonitorings();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a monitoring record by ID")
    public Monitoring getMonitoringById(@PathVariable Long id) {
        return monitoringService.getMonitoringById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Monitoring not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new monitoring record")
    public Monitoring createMonitoring(@RequestBody Monitoring monitoring) {
        return monitoringService.createMonitoring(monitoring);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a monitoring record by ID")
    public void deleteMonitoring(@PathVariable Long id) {
        monitoringService.deleteMonitoring(id);
    }
}
