package com.yassine.lafryhi.jee.seance9.security.services;

import com.yassine.lafryhi.jee.seance9.security.entities.AppRole;
import com.yassine.lafryhi.jee.seance9.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String verifyPassword);

    AppRole saveNewRole(String roleName, String description);

    void addRoleToUser(String username, String roleName);

    void removeRoleFromUser(String username, String roleName);

    AppUser loadUserByUsername(String username);
}
