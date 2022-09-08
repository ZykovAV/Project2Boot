package org.example.Project2Boot.dao;



import org.example.Project2Boot.models.User;

import java.util.List;

public interface UserDao {

    User getUser(int id);
    List<User> getListUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);
}
