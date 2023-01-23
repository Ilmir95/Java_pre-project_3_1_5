package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {
    void saveRole(Role role);

    void removeRoleById(int id);

    List<Role> getAllRole();

    Role getRoleById(int id);
    Role getRoleByRole(Role role);
    void updateRole(Role role);
}
