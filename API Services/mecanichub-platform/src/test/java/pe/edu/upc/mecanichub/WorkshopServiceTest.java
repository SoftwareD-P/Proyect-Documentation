package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pe.edu.upc.mecanichub.Workshop.application.WorkshopService;
import pe.edu.upc.mecanichub.Workshop.domain.model.aggregates.Workshop;
import pe.edu.upc.mecanichub.Workshop.infrastructure.persistence.jpa.repositories.WorkshopRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorkshopServiceTest {

    private WorkshopRepository workshopRepository;
    private WorkshopService workshopService;

    @BeforeEach
    void setUp() {
        workshopRepository = mock(WorkshopRepository.class);
        workshopService = new WorkshopService(workshopRepository);
    }

    @Test
    void testCreateWorkshop_Success() {

        Workshop newWorkshop = new Workshop("Taller El Rápido", "Av. Central 123", true);
        when(workshopRepository.save(any(Workshop.class))).thenReturn(newWorkshop);


        Workshop saved = workshopService.createWorkshop(newWorkshop);


        assertNotNull(saved);
        assertEquals("Taller El Rápido", saved.getName());
        verify(workshopRepository, times(1)).save(newWorkshop);
    }

    @Test
    void testGetWorkshopById_Found() {

        Workshop existing = new Workshop("Taller Perú", "Calle Lima 456", true);
        when(workshopRepository.findById(1L)).thenReturn(Optional.of(existing));


        Optional<Workshop> result = workshopService.getWorkshopById(1L);


        assertTrue(result.isPresent());
        assertEquals("Taller Perú", result.get().getName());
    }

    @Test
    void testGetWorkshopById_NotFound() {
        when(workshopRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Workshop> result = workshopService.getWorkshopById(99L);

        assertFalse(result.isPresent());
    }
}
