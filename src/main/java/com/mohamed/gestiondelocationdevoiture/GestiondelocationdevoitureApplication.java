package com.mohamed.gestiondelocationdevoiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestiondelocationdevoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestiondelocationdevoitureApplication.class, args);
    }

}
