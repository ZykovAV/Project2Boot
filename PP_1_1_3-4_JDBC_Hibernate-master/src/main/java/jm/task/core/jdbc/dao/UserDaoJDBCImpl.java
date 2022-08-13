package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.openConnection();
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS `db_mytest`.`table` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastname` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT(3) NULL,\n" +
                    "   PRIMARY KEY (`id`))\n" +
                    "   ENGINE = InnoDB\n" +
                    "   DEFAULT CHARACTER SET = utf8;");
            System.out.println("Sozdanie vipolneno!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXIST `db_mytest`.`table`");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastname, byte age) {
        try (PreparedStatement preparedStatement = connection.
                prepareStatement("INSERT INTO db_mytest.table (name, lastname, age) VALUES (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception in method saveuser(in UserDao)");
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM table WHERE id=?")){
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception in removeUserbyId");
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        System.out.println("method getAllUsers");
        List<User> listUser = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from `db_mytest`.`table`")) {
            System.out.println("try in getAllUsers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int a = 1;
//                int b = 2;
//                int c = 3;
//                int d = 4;
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                System.out.println("while in getalluser");
                System.out.println(user);
                listUser.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from table");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
