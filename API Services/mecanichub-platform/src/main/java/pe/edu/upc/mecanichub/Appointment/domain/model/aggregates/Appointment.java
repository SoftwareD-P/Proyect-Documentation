package pe.edu.upc.mecanichub.Appointment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upc.mecanichub.Appointment.domain.model.valueobjects.AppointmentStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client;      // antes: VehicleOwner
    private String service;     // antes: Service
    private String workshop;
    private String assignedWorker; // antes: Worker

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private LocalDateTime date;

    public Appointment(String client, String service, String workshop, LocalDateTime date) {
        this.client = client;
        this.service = service;
        this.workshop = workshop;
        this.date = date;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void assignWorker(String worker) {
        if (this.status == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Cannot assign a worker to a cancelled appointment.");
        }
        this.assignedWorker = worker;
    }

    public void changeStatusTo(AppointmentStatus newStatus) {
        if (this.status == AppointmentStatus.COMPLETED && newStatus == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Cannot cancel a completed appointment.");
        }
        this.status = newStatus;
    }

    public void rescheduleTo(LocalDateTime newDate) {
        if (newDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot reschedule to a past date.");
        }
        this.date = newDate;
    }
}
