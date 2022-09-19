package com.example.demo.dao;

import com.example.demo.models.Role;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRole(Role role) {
        if (entityManager.find(Role.class, role.getRole_id()) == null) {
            entityManager.persist(role);
        }
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }

    public List<String> getRoles() {
        List<String> list=entityManager.createQuery("select  r from Role r", Role.class).getResultList()
                .stream().map(Role::getRole).toList();
        return list;
    }
}
