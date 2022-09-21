package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImp(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;

    }

    @Override
    public User getUser(int index) {
        return userDao.getUser(index);
    }

    @Override
    public List<User> getListUser() {
        return userDao.getListUser();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        System.out.println("adduserstart");
        acceptUserRoles(user);
        System.out.println("adduservtoroy");
        userDao.addUser(user);
        System.out.println("addusertretiy");
    }

    @Override
    @Transactional
    public void editUser(User user) {
        acceptUserRoles(user);
        userDao.editUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' не найден", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.getAuthorities());
    }

    void acceptUserRoles(User user) {
        Set<Role> templist = new HashSet<>();
        if (user.getRoles() == null) {
            System.out.println("if NULL");
            return;
        }
        for (Role role : user.getRoles()){
            templist.add(roleService.getRoleByName(role.getRole()));
        }
        user.setRoles(templist);
    }

//    v addUser() prihodit user u nego nado schitat roli, probegayu po userskim rolyam u prishedshego ob'ekta
//    dlya kajdoy roli kotoraya est u usera ushesh ee v bd cherez roleservice, tipa getRoleByName(roleName)
//    i prishedshuyu rol' berem, sozdaem noviy set v nego pihaem ves prishedshiy set roley. i eto prisvaivaem user.
}
