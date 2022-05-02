package com.yassine.lafryhi.jee.seance5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yassine.lafryhi.jee.seance5.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
