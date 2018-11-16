package com.example.springproject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

@SpringBootApplication
public class Application {
	

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(utilisateurRepository repository) {
		return (args) -> {
			// save a couple of utilisateur
			repository.save(new utilisateur("Jack", "Bauer"));
			repository.save(new utilisateur("Chloe", "O'Brian"));
			repository.save(new utilisateur("Kim", "Bauer"));
			repository.save(new utilisateur("David", "Palmer"));
			repository.save(new utilisateur("Michelle", "Dessler"));

			// fetch all utilisateur
			log.info("utilisateur found with findAll():");
			log.info("-------------------------------");
			for (utilisateur utilisateur : repository.findAll()) {
				log.info(utilisateur.toString());
			}
			log.info("");

			// fetch an individual utilisateur by ID
			repository.findById(1L)
				.ifPresent(utilisateur -> {
					log.info("utilisateur found with findById(1L):");
					log.info("--------------------------------");
					log.info(utilisateur.toString());
					log.info("");
				});

			// fetch utilisateur by last name
			log.info("utilisateur found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (utilisateur bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}