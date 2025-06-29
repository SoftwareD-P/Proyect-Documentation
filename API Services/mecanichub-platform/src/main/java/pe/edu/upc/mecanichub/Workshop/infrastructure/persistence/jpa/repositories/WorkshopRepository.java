package pe.edu.upc.mecanichub.Workshop.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.mecanichub.Workshop.domain.model.aggregates.Workshop;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
