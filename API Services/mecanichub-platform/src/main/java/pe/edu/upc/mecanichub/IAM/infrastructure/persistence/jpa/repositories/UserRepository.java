package pe.edu.upc.mecanichub.IAM.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.mecanichub.IAM.domain.model.aggregates.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByEmail(String email);


    boolean existsByEmail(String email);
}
