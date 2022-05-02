package com.yassine.lafryhi.jee.seance5.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.yassine.lafryhi.jee.seance5.entities.Role;
import com.yassine.lafryhi.jee.seance5.entities.User;
import com.yassine.lafryhi.jee.seance5.repositories.UserRepository;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void assignRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = roleService.findRoleByRoleName(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new RuntimeException("Bad credentials");
        else if (passwordEncoder.matches(password, user.getPassword()))
            return user;
        else throw new RuntimeException("Bad credentials");
    }

}
