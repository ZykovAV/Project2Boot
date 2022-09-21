package com.example.demo.dao;

import com.example.demo.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRole(Role role) {
        if (entityManager.find(Role.class, role.getId()) == null) {
            entityManager.persist(role);
        }
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }

    public List<Role> getRoles() {
        List<Role> list=entityManager.createQuery("select  r from Role r", Role.class).getResultList();

        return list;
    }

    @Override
    public Role getRoleByName(String role) {
        Query query = entityManager.createQuery("SELECT r FROM Role r where r.role=:role", Role.class);
        query.setParameter("role", role);
        return (Role) query.getSingleResult();
    }
}
