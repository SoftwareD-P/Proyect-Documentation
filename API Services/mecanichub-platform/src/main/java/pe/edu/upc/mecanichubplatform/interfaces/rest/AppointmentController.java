package pe.edu.upc.mecanichubplatform.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichubplatform.application.AppointmentService;
import pe.edu.upc.mecanichubplatform.appointments.domain.model.aggregates.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@Tag(name = "Appointments", description = "In-memory CRUD for appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    @Operation(summary = "Get all appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an appointment by ID")
    public Appointment getAppointmentById(@PathVariable String id) {
        return appointmentService.getAppointmentById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));
    }

    @PostMapping
    @Operation(summary = "Create a new appointment")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Reschedule appointment")
    public Appointment rescheduleAppointment(@PathVariable Long id, @RequestBody LocalDateTime newDate) {
        return appointmentService.updateAppointment(id, newDate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an appointment")
    public void deleteAppointment(@PathVariable Long id) {
        if (!appointmentService.deleteAppointment(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        }
    }
}
