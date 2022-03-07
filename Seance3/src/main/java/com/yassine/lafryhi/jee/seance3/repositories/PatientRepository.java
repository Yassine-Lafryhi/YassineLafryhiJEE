package com.yassine.lafryhi.jee.seance3.repositories;

import com.yassine.lafryhi.jee.seance3.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade(boolean malade);

    public Page<Patient> findByMalade(boolean malade, Pageable pageable);

    public List<Patient> findByMaladeAndScoreLessThan(boolean malade, int score);

    public List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);

    public List<Patient> findByDateNaissanceBetween(Date date1, Date date2);

    public List<Patient> findByDateNaissanceBetweenAndMaladeIsFalseOrNomLike(Date date1, Date date2, String keyword);

    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatient(@Param("x") Date date1,
                                  @Param("y") Date date2, @Param("z") String keyword);
}
