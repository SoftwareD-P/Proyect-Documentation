package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pe.edu.upc.mecanichub.Monitoring.application.MonitoringService;
import pe.edu.upc.mecanichub.Monitoring.domain.model.aggregates.Monitoring;
import pe.edu.upc.mecanichub.Monitoring.infrastructure.persistence.jpa.repositories.MonitoringRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MonitoringServiceTest {

    private MonitoringService monitoringService;
    private MonitoringRepository monitoringRepository;

    @BeforeEach
    public void setup() {
        monitoringRepository = Mockito.mock(MonitoringRepository.class);
        monitoringService = new MonitoringService(monitoringRepository);
    }



    @Test
    public void testGetMonitoringById() {
        Monitoring monitoring = new Monitoring();
        when(monitoringRepository.findById(234L)).thenReturn(Optional.of(monitoring));
        assertTrue(monitoringService.getMonitoringById(234L).isPresent());
    }

    @Test
    public void testCreateMonitoring() {
        Monitoring monitoring = new Monitoring();
        when(monitoringRepository.existsById(234L)).thenReturn(false);
        when(monitoringRepository.save(monitoring)).thenReturn(monitoring);
        assertNotNull(monitoringService.createMonitoring(monitoring));
    }

    @Test
    public void testDeleteMonitoring() {
        when(monitoringRepository.existsById(234L)).thenReturn(true);
        monitoringService.deleteMonitoring(234L);
        verify(monitoringRepository).deleteById(234L);
    }
}
