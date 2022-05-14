package com.yassine.lafryhi.jee.seance8;

import com.github.javafaker.Faker;
import com.yassine.lafryhi.jee.seance8.entities.Patient;
import com.yassine.lafryhi.jee.seance8.repositories.PatientRepository;
import com.yassine.lafryhi.jee.seance8.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Seance8Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance8Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            Faker faker = new Faker();
            for (int i : new int[80]) {
                patientRepository.save(new Patient(null, faker.name().firstName() + " " + faker.name().lastName(),
                        faker.date().birthday(), faker.bool().bool(), faker.number().numberBetween(10, 999)));
            }
            patientRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("yassine", "12345", "12345");
            securityService.saveNewUser("admin", "12345", "12345");
            securityService.saveNewUser("user", "12345", "12345");

            securityService.saveNewRole("ROLE_USER", "user");
            securityService.saveNewRole("ROLE_ADMIN", "admin");

            securityService.addRoleToUser("yassine", "ROLE_ADMIN");
            securityService.addRoleToUser("admin", "ROLE_ADMIN");
            securityService.addRoleToUser("user", "ROLE_USER");
        };
    }
}
