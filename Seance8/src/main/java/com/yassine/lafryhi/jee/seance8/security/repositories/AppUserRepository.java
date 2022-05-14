package com.yassine.lafryhi.jee.seance8.security.repositories;

import com.yassine.lafryhi.jee.seance8.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
