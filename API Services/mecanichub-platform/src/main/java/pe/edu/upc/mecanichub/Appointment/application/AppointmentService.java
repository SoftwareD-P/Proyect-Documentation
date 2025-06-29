package pe.edu.upc.mecanichub.Appointment.application;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Appointment.domain.model.aggregates.Appointment;
import pe.edu.upc.mecanichub.Appointment.infrastructure.persistence.jpa.repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        if (appointment.getId() != null && appointmentRepository.existsById(appointment.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The appointment already exists.");
        }
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Optional<Appointment> updateAppointment(Long id, LocalDateTime newDate) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.rescheduleTo(newDate);
            return appointmentRepository.save(appointment);
        });
    }

    @Transactional
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found.");
        }
        appointmentRepository.deleteById(id);
    }
}
