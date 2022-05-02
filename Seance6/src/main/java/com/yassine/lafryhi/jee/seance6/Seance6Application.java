package com.yassine.lafryhi.jee.seance6;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yassine.lafryhi.jee.seance6.entities.Patient;
import com.yassine.lafryhi.jee.seance6.repositories.PatientRepository;

@SpringBootApplication
public class Seance6Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance6Application.class, args);
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
