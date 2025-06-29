package pe.edu.upc.mecanichub.Workshop.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workshops")
@Getter
@NoArgsConstructor // Necesario para JPA y Jackson
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private boolean available;

    public Workshop(String name, String address, boolean available) {
        this.name = name;
        this.address = address;
        this.available = available;
    }

    public void markAsUnavailable() {
        this.available = false;
    }

    public void markAsAvailable() {
        this.available = true;
    }

    public void updateInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
