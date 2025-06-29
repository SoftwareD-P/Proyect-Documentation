package pe.edu.upc.mecanichub.Workshop.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Workshop.application.WorkshopService;
import pe.edu.upc.mecanichub.Workshop.domain.model.aggregates.Workshop;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workshops")
@Tag(name = "Workshops", description = "CRUD for workshops with database persistence")
public class WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping
    @Operation(summary = "Get all workshops")
    public List<Workshop> getAllWorkshops() {
        return workshopService.getAllWorkshops();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a workshop by ID")
    public Workshop getWorkshopById(@PathVariable Long id) {
        return workshopService.getWorkshopById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workshop not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new workshop")
    public Workshop createWorkshop(@RequestBody Workshop workshop) {
        return workshopService.createWorkshop(workshop);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a workshop")
    public Workshop updateWorkshop(@PathVariable Long id, @RequestBody Workshop updatedWorkshop) {
        return workshopService.updateWorkshop(id, updatedWorkshop)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workshop not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a workshop")
    public void deleteWorkshop(@PathVariable Long id) {
        workshopService.deleteWorkshop(id);
    }
}
