package pe.edu.upc.mecanichub.Payment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.mecanichub.Payment.domain.model.aggregates.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
