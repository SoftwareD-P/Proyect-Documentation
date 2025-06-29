package pe.edu.upc.mecanichubplatform.Appointment.application;

import org.springframework.stereotype.Service;
import pe.edu.upc.mecanichubplatform.Appointment.domain.model.aggregates.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Optional<Appointment> getAppointmentById(String id) {
        return appointments.stream().filter(appointment -> appointment.getId().equals(id)).findFirst();
    }

    public Appointment createAppointment(Appointment appointment) {
        if (getAppointmentById(String.valueOf(appointment.getId())).isPresent()) {
            throw new IllegalArgumentException("The appointment already exists.");
        }
        appointments.add(appointment);
        return appointment;
    }

    public Optional<Appointment> updateAppointment(Long id, LocalDateTime newDate) {
        Optional<Appointment> existingAppointment = getAppointmentById(String.valueOf(id));
        if (!existingAppointment.isPresent()) {
            return Optional.empty();
        }
        existingAppointment.get().setDate(newDate);
        return existingAppointment;
    }

    public boolean deleteAppointment(Long id) {
        return appointments.removeIf(appointment -> appointment.getId().equals(id));
    }
}
