package pe.edu.upc.mecanichub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MecanichubPruebasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MecanichubPruebasApplication.class, args);
    }

}
