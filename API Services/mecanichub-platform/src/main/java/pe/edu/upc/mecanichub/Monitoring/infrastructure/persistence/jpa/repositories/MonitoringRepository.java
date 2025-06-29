package pe.edu.upc.mecanichub.Monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.mecanichub.Monitoring.domain.model.aggregates.Monitoring;

import java.util.List;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {

    List<Monitoring> findByAppointmentId(Long appointmentId);

    List<Monitoring> findByWorkshopId(Long workshopId);

    List<Monitoring> findByStatus(String status);
}
