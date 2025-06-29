package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.edu.upc.mecanichub.Payment.application.PaymentService;
import pe.edu.upc.mecanichub.Payment.domain.model.aggregates.Payment;
import pe.edu.upc.mecanichub.Payment.infrastructure.persistence.jpa.repositories.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private PaymentRepository paymentRepository;
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentRepository = mock(PaymentRepository.class);
        paymentService = new PaymentService(paymentRepository);
    }

    @Test
    void testCreatePayment_Success() {
        Payment payment = new Payment("123456", "654321", BigDecimal.valueOf(100.00));
        when(paymentRepository.existsById(anyString())).thenReturn(false);
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment saved = paymentService.createPayment(payment);

        assertNotNull(saved);
        assertEquals("123456", saved.getSourceAccount());
        assertEquals(BigDecimal.valueOf(100.00), saved.getAmount());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testGetPaymentById_Found() {
        Payment existing = new Payment("111111", "222222", BigDecimal.valueOf(250.00));
        when(paymentRepository.findById("p1")).thenReturn(Optional.of(existing));

        Optional<Payment> result = paymentService.getPaymentById("p1");

        assertTrue(result.isPresent());
        assertEquals("222222", result.get().getDestinationAccount());
    }

    @Test
    void testGetPaymentById_NotFound() {
        when(paymentRepository.findById("not-found")).thenReturn(Optional.empty());

        Optional<Payment> result = paymentService.getPaymentById("not-found");

        assertFalse(result.isPresent());
    }
}
