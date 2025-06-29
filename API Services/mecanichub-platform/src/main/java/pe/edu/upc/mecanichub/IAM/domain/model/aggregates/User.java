package pe.edu.upc.mecanichub.IAM.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id; // UUID o algún identificador único

    private String fullName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        CLIENT, TECHNICIAN, ADMIN
    }

    public boolean isPasswordMatch(String rawPassword) {
        // Aquí normalmente se usa BCrypt o similar
        return this.password.equals(rawPassword);
    }
}
