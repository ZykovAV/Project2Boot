package com.example.demo.service;

import com.example.demo.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public void addRole(Role role);

    public Role getRoleById(int id);

    public List<Role> getRoles();

    public Role getRoleByName(String role);
}
