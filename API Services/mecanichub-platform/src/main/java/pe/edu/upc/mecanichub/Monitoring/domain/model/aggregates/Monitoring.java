package pe.edu.upc.mecanichub.Monitoring.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "monitorings")
public class Monitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appointmentId; // Referencia a la cita relacionada

    private Long workshopId;    // Referencia al taller

    private String status;      // Estado actual (ej: "Inspection", "Repairing", "Completed")

    private String message;     // Mensaje o nota descriptiva

    private LocalDateTime timestamp; // Fecha y hora del monitoreo

    public Monitoring(Long appointmentId, Long workshopId, String status, String message, LocalDateTime timestamp) {
        this.appointmentId = appointmentId;
        this.workshopId = workshopId;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
