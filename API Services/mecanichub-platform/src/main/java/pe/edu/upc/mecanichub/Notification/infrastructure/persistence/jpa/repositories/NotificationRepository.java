package pe.edu.upc.mecanichub.Notification.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.mecanichub.Notification.domain.model.aggregates.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
