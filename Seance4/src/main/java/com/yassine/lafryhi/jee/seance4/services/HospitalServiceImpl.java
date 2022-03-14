package com.yassine.lafryhi.jee.seance4.services;

import com.yassine.lafryhi.jee.seance4.entities.*;
import com.yassine.lafryhi.jee.seance4.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        appointment.setId(UUID.randomUUID().toString());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
