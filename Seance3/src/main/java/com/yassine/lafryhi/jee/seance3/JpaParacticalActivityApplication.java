package com.yassine.lafryhi.jee.seance3;

import com.yassine.lafryhi.jee.seance3.entities.Patient;
import com.yassine.lafryhi.jee.seance3.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaParacticalActivityApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaParacticalActivityApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hassan",
                new Date(), false, 56));
        patientRepository.save(new Patient(null, "Mohamed",
                new Date(), true, 56));
        patientRepository.save(new Patient(null, "Imane",
                new Date(), false, 56));
        patientRepository.findAll().forEach(p -> {

        });
        for (Patient patient : patientRepository.findAll()) {
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
            System.out.println("=========");
        }
        System.out.println("=========");

        Patient patient = patientRepository.findById(new Long(2L)).orElse(null);
        if (patient != null) {
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
        }

        System.out.println("=========");

        patient.setScore(870);
        //patientRepository.save(patient);

        //patientRepository.deleteById(1L);


        for (int i = 0; i < 100; i++) {
            patientRepository.save(new Patient(null, "Hassan",
                    new Date(), false, 56));
        }

        for (Patient patient1 : patientRepository.findAll(PageRequest.of(0, 5))) {
            System.out.println(patient1.getId());
            System.out.println(patient1.getNom());
            System.out.println(patient1.getScore());
            System.out.println(patient1.getDateNaissance());
            System.out.println(patient1.isMalade());
            System.out.println("=========");
        }

        Page<Patient> pages = patientRepository.findAll(PageRequest.of(0, 5));
        pages.getTotalElements();
        pages.getTotalPages();
        pages.getNumber();
        List<Patient> patientList = pages.getContent();


        List<Patient> list = patientRepository.findByMalade(false);

        Page<Patient> list2 = patientRepository.findByMalade(false, PageRequest.of(0, 5));

    }
}
