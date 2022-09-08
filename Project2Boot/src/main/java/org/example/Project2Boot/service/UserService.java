package org.example.Project2Boot.service;


import org.example.Project2Boot.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getListUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

}
