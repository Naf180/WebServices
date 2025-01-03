package com.dev.gestion_matieres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.dev.gestion_matieres.config.WebserviceConfig;

@SpringBootApplication
@Import(WebserviceConfig.class)
public class GestionMatieresApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionMatieresApplication.class, args);
	}

}
