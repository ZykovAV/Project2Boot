package com.example.demo.service;


import com.example.demo.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;
import java.util.List;

public interface UserService extends UserDetailsService{
    User getUser(int id);
    List<User> getListUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User findByUsername(String username);


}
