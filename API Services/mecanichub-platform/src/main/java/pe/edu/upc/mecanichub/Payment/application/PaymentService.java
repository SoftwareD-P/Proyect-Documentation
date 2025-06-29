package pe.edu.upc.mecanichub.Payment.application;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Payment.domain.model.aggregates.Payment;
import pe.edu.upc.mecanichub.Payment.infrastructure.persistence.jpa.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(String id) {
        return paymentRepository.findById(id);
    }

    @Transactional
    public Payment createPayment(Payment payment) {
        if (paymentRepository.existsById(payment.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment ID already exists.");
        }
        return paymentRepository.save(payment);
    }

    @Transactional
    public void deletePayment(String id) {
        if (!paymentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found.");
        }
        paymentRepository.deleteById(id);
    }
}
