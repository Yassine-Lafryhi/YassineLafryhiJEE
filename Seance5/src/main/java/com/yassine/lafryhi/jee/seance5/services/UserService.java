package com.yassine.lafryhi.jee.seance5.services;

import com.yassine.lafryhi.jee.seance5.entities.User;

public interface UserService {
    User addNewUser(User user);

    User findUserByUsername(String username);

    void assignRoleToUser(String username, String roleName);

    User authenticate(String username, String password);
}
