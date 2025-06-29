package pe.edu.upc.mecanichubplatform.Appointment.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Appointment {
    Long id;
    VehicleOwner client;
    Service service;
    Workshop workshop;
    AppointmentStatus status;
    Worker assignedWorker;
    LocalDateTime date;

    public Appointment(Long id, VehicleOwner client, Service service, Workshop workshop, AppointmentStatus status, Worker assignedWorker, LocalDateTime date) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.workshop = workshop;
        this.status = status;
        this.assignedWorker = assignedWorker;
        this.date = date;
    }
}
