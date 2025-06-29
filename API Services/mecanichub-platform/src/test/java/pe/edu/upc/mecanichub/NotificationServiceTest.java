package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pe.edu.upc.mecanichub.Notification.application.NotificationService;
import pe.edu.upc.mecanichub.Notification.domain.model.aggregates.Notification;
import pe.edu.upc.mecanichub.Notification.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    private NotificationService notificationService;
    private NotificationRepository notificationRepository;

    @BeforeEach
    public void setup() {
        notificationRepository = Mockito.mock(NotificationRepository.class);
        notificationService = new NotificationService(notificationRepository);
    }

    @Test
    public void testGetAllNotifications() {
        when(notificationRepository.findAll()).thenReturn(List.of(new Notification()));
        assertEquals(1, notificationService.getAllNotifications().size());
    }

    @Test
    public void testGetNotificationById() {
        Notification notification = new Notification();
        when(notificationRepository.findById(234L)).thenReturn(Optional.of(notification));
        assertTrue(notificationService.getNotificationById(234L).isPresent());
    }

    @Test
    public void testCreateNotification() {
        Notification notification = new Notification();
        when(notificationRepository.existsById(234L)).thenReturn(false);
        when(notificationRepository.save(notification)).thenReturn(notification);
        assertNotNull(notificationService.createNotification(notification));
    }

    @Test
    public void testDeleteNotification() {
        when(notificationRepository.existsById(234L)).thenReturn(true);
        notificationService.deleteNotification(234L);
        verify(notificationRepository).deleteById(234L);
    }
}
