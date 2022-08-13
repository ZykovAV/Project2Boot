package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/db_mytest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    static Connection connection;

    public static Connection openConnection() {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.err.println("Неудалось загрузить драйвер!");
        }
        return connection;
    }
}

// реализуйте настройку соеденения с БД

