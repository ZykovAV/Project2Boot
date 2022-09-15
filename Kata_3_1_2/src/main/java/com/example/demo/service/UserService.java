package com.example.demo.service;


import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getListUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

}
