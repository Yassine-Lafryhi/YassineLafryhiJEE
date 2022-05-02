package com.yassine.lafryhi.jee.seance5.services;

import com.yassine.lafryhi.jee.seance5.entities.Role;

public interface RoleService {
    Role addRole(Role role);

    Role findRoleByRoleName(String roleName);
}
