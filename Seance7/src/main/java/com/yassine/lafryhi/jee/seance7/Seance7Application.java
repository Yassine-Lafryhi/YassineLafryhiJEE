package com.yassine.lafryhi.jee.seance7;

import com.github.javafaker.Faker;
import com.yassine.lafryhi.jee.seance7.entities.Patient;
import com.yassine.lafryhi.jee.seance7.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Seance7Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance7Application.class, args);
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
}
