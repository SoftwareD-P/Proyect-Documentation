package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.edu.upc.mecanichub.Appointment.application.AppointmentService;
import pe.edu.upc.mecanichub.Appointment.domain.model.aggregates.Appointment;
import pe.edu.upc.mecanichub.Appointment.infrastructure.persistence.jpa.repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppointmentServiceTest {

    private AppointmentRepository appointmentRepository;
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentRepository = mock(AppointmentRepository.class);
        appointmentService = new AppointmentService(appointmentRepository);
    }

    @Test
    void testCreateAppointment_Success() {
        Appointment appointment = new Appointment(
                "Carlos Mamani",
                "Cambio de aceite",
                "Taller El Rápido",
                LocalDateTime.now().plusDays(1)
        );

        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment saved = appointmentService.createAppointment(appointment);

        assertNotNull(saved);
        assertEquals("Cambio de aceite", saved.getService());
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void testGetAppointmentById_Found() {
        Appointment existing = new Appointment(
                "Maria Pérez",
                "Revisión técnica",
                "Taller Pro",
                LocalDateTime.now().plusDays(2)
        );

        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(existing));

        Optional<Appointment> result = appointmentService.getAppointmentById(1L);

        assertTrue(result.isPresent());
        assertEquals("Revisión técnica", result.get().getService());
    }

    @Test
    void testGetAppointmentById_NotFound() {
        when(appointmentRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Appointment> result = appointmentService.getAppointmentById(999L);

        assertFalse(result.isPresent());
    }
}
