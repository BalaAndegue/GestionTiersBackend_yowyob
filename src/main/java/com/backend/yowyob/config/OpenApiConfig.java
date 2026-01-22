package com.backend.yowyob.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        //serveur de devellopement
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Serveur de développement");

        // Serveur production
        Server prodServer = new Server();
        prodServer.setUrl("https://gestiontiersbackend-yowyob.onrender.com");
        prodServer.setDescription("Serveur de production");



        Contact contact = new Contact();
        contact.setName("Support Yowyob");
        contact.setEmail("support@yowyob.com");
        contact.setUrl("https://frontend-gestion-tiers-yowyob.vercel.app");

        Info info = new Info()
                .title("Yowyob Tiers API")
                .version("1.0.0")
                .description("API complète pour la gestion des tiers (clients, fournisseurs, commerciaux, prospects)")
                .contact(contact)
                .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"));

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer,prodServer));
    }
}