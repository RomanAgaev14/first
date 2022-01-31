package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection conn = Util.getConnection();
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try(Statement stm = conn.createStatement()){
            String sqlSelectAllPersons = "CREATE TABLE IF NOT EXISTS usersss" +
                    "(id mediumint not null auto_increment," +
                    " name VARCHAR(100), " +
                    "lastname VARCHAR(100), " +
                    "age int, " +
                    "PRIMARY KEY (id))";
            stm.executeUpdate(sqlSelectAllPersons);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try(Statement stm = conn.createStatement()) {
            stm.executeUpdate("DROP TABLE [IF EXISTS]");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String stm = "INSERT INTO usersss (name, lastName, age) Values (?, ?, ?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(stm)){
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setByte(3, age);
        preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM usersss where id");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Statement stm = conn.createStatement()){
            ResultSet resultSet = stm.executeQuery("SELECT id, name, lastName, age from usersss");
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try(Statement stm = conn.createStatement()){
            stm.executeUpdate("DELETE FROM usersss");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
