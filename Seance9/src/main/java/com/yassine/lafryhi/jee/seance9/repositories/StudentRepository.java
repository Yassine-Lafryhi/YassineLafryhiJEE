package com.yassine.lafryhi.jee.seance9.repositories;

import com.yassine.lafryhi.jee.seance9.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByFirstNameContains(String keyword, Pageable pageable);

}
