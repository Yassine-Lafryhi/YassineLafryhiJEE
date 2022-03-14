package com.yassine.lafryhi.jee.seance4.services;

import com.yassine.lafryhi.jee.seance4.entities.*;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Doctor saveDoctor(Doctor doctor);
    Appointment saveAppointment(Appointment appointment);
    Consultation saveConsultation(Consultation consultation);
}
