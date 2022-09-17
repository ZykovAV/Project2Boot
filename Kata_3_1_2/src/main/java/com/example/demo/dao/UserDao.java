package com.example.demo.dao;



import com.example.demo.models.User;

import java.util.List;

public interface UserDao {

    User getUser(int id);
    List<User> getListUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User findByUsername(String username);
}
