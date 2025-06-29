package pe.edu.upc.mecanichub.Workshop.application;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.mecanichub.Workshop.domain.model.aggregates.Workshop;
import pe.edu.upc.mecanichub.Workshop.infrastructure.persistence.jpa.repositories.WorkshopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService {

    private final WorkshopRepository workshopRepository;

    @Autowired
    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    public Optional<Workshop> getWorkshopById(Long id) {
        return workshopRepository.findById(id);
    }

    @Transactional
    public Workshop createWorkshop(Workshop workshop) {
        if (workshop.getId() != null && workshopRepository.existsById(workshop.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The workshop already exists.");
        }
        return workshopRepository.save(workshop);
    }

    @Transactional
    public Optional<Workshop> updateWorkshop(Long id, Workshop updatedWorkshop) {
        return workshopRepository.findById(id).map(existingWorkshop -> {
            existingWorkshop.updateInfo(updatedWorkshop.getName(), updatedWorkshop.getAddress());
            if (updatedWorkshop.isAvailable()) {
                existingWorkshop.markAsAvailable();
            } else {
                existingWorkshop.markAsUnavailable();
            }
            return workshopRepository.save(existingWorkshop);
        });
    }

    @Transactional
    public void deleteWorkshop(Long id) {
        if (!workshopRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Workshop not found.");
        }
        workshopRepository.deleteById(id);
    }
}
