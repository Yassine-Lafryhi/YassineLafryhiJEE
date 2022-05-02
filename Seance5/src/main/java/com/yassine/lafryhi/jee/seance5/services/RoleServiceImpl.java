package com.yassine.lafryhi.jee.seance5.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import com.yassine.lafryhi.jee.seance5.entities.Role;
import com.yassine.lafryhi.jee.seance5.repositories.RoleRepository;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

}
