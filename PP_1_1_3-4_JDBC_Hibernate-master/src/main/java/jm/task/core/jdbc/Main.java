package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService US = new UserServiceImpl();
//        US.dropUsersTable();
//        US.createUsersTable();
//        US.cleanUsersTable();
//        US.saveUser("Petr", "Kovshov", (byte) 27);
//        US.saveUser("Brett", "Hull", (byte) 58);
//        US.removeUserById(4);
//        List<User> list = US.getAllUsers();
//        System.out.println(list);

        // реализуйте алгоритм здесь
    }
}
