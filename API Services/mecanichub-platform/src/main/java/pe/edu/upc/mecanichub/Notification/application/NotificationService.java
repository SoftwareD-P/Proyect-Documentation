package pe.edu.upc.mecanichub.Notification.application;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Notification.domain.model.aggregates.Notification;
import pe.edu.upc.mecanichub.Notification.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Transactional
    public Notification createNotification(Notification notification) {
        if (notificationRepository.existsById(notification.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Notification ID already exists.");
        }
        return notificationRepository.save(notification);
    }

    @Transactional
    public void deleteNotification(Long id) {
        if (!notificationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found.");
        }
        notificationRepository.deleteById(id);
    }
}
