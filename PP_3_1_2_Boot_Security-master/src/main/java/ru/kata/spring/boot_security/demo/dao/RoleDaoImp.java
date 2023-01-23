package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class RoleDaoImp implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void removeRoleById(int id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public List<Role> getAllRole() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
    @Override
    public Role getRoleByRole(Role role) {
        return entityManager.find(Role.class, role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }
}
