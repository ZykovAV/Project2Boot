package com.example.demo.dao;

import com.example.demo.models.Role;

import java.util.List;

public interface RoleDao {

    public void addRole(Role role);

    public Role getRoleById(int id);

    public List<String> getRoles();

}
