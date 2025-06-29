package pe.edu.upc.mecanichub.Appointment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.mecanichub.Appointment.domain.model.aggregates.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
