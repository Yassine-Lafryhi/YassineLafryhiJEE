package com.yassine.lafryhi.jee.seance4.repositories;

import com.yassine.lafryhi.jee.seance4.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByName(String name);
}
