package pe.edu.upc.mecanichub.Monitoring.application;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Monitoring.domain.model.aggregates.Monitoring;
import pe.edu.upc.mecanichub.Monitoring.infrastructure.persistence.jpa.repositories.MonitoringRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoringService {

    private final MonitoringRepository monitoringRepository;

    @Autowired
    public MonitoringService(MonitoringRepository monitoringRepository) {
        this.monitoringRepository = monitoringRepository;
    }

    public List<Monitoring> getAllMonitorings() {
        return monitoringRepository.findAll();
    }

    public Optional<Monitoring> getMonitoringById(Long id) {
        return monitoringRepository.findById(id);
    }

    @Transactional
    public Monitoring createMonitoring(Monitoring monitoring) {
        if (monitoring.getId() != null && monitoringRepository.existsById(monitoring.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Monitoring ID already exists.");
        }
        return monitoringRepository.save(monitoring);
    }

    @Transactional
    public void deleteMonitoring(Long id) {
        if (!monitoringRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Monitoring not found.");
        }
        monitoringRepository.deleteById(id);
    }
}
