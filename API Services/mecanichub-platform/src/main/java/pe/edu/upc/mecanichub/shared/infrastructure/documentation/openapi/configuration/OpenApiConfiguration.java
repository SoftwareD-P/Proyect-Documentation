package pe.edu.upc.mecanichub.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Value("${application.name:MecanicHub Platform}")
    String applicationName;

    @Value("${application.description:API documentation for the MecanicHub system}")
    String applicationDescription;

    @Value("${application.version:1.0.0}")
    String applicationVersion;

    @Bean
    public OpenAPI mecanicHubOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(applicationName)
                        .description(applicationDescription)
                        .version(applicationVersion)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("MecanicHub Platform API Documentation")
                        .url("https://github.com/your-org/mecanichub-platform-docs")); // Puedes poner la URL real de tu repo/docs
    }
}
