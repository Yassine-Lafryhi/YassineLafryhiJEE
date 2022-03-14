package com.yassine.lafryhi.jee.seance4;

import com.yassine.lafryhi.jee.seance4.entities.*;
import com.yassine.lafryhi.jee.seance4.repositories.*;
import com.yassine.lafryhi.jee.seance4.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Seance4Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance4Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository
            , DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {

        return args -> {
            Stream.of("Taha", "Samir", "Ayman", "Mounir").forEach(name -> {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setSick(false);
                patient.setBirthDate(new Date());
                hospitalService.savePatient(patient);
            });

            Stream.of("Imran", "Hafsa", "Assiya").forEach(name -> {
                Doctor doctor = new Doctor();
                doctor.setName(name);
                doctor.setEmail(name.concat("@gmail.com"));
                doctor.setSpeciality(Math.random() > 0.5 ? "Cardiologist" : "Dentist");
                hospitalService.saveDoctor(doctor);
            });

            Patient patient = patientRepository.findByName("Mounir");

            Doctor doctor = doctorRepository.findByName("Hafsa");

            Appointment firstAppointment = new Appointment();
            firstAppointment.setAppointmentDate(new Date());
            firstAppointment.setStatus(AppointmentStatus.DONE);
            firstAppointment.setPatient(patient);
            firstAppointment.setDoctor(doctor);
            hospitalService.saveAppointment(firstAppointment);

            Appointment secondAppointment = appointmentRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setConsultationDate(secondAppointment.getAppointmentDate());
            consultation.setAppointment(firstAppointment);
            hospitalService.saveConsultation(consultation);

        };
    }
}
