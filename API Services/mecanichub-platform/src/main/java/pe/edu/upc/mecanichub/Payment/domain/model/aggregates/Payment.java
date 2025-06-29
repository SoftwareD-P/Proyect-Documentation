package pe.edu.upc.mecanichub.Payment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor // Necesario para JPA
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String sourceAccount;
    private String destinationAccount;

    private BigDecimal amount;

    private LocalDateTime timestamp;

    public Payment(String sourceAccount, String destinationAccount, BigDecimal amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Se asigna automáticamente
    }

    // Método de dominio: reembolso, por ejemplo
    public void refundToSource() {
        // Lógica de dominio para revertir, marcar flag, etc.
        // Aquí podrías lanzar un evento de dominio o registrar auditoría
    }
}
