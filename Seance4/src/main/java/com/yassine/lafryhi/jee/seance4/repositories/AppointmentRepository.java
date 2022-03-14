package com.yassine.lafryhi.jee.seance4.repositories;

import com.yassine.lafryhi.jee.seance4.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {
}
