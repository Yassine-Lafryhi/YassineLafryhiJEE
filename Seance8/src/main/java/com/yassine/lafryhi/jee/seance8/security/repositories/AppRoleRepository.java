package com.yassine.lafryhi.jee.seance8.security.repositories;
import com.yassine.lafryhi.jee.seance8.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
