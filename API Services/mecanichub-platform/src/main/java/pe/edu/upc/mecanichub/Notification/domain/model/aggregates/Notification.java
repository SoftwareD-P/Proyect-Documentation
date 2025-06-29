package pe.edu.upc.mecanichub.Notification.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String recipient;

    @NotBlank
    @Size(max = 255)
    private String message;

    @NotBlank
    @Size(max = 50)
    private String type; // Ej: EMAIL, SMS, PUSH

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private boolean delivered;
}
