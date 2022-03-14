package com.yassine.lafryhi.jee.seance4.repositories;

import com.yassine.lafryhi.jee.seance4.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
}
