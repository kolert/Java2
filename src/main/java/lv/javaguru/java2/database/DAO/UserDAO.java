package lv.javaguru.java2.database.DAO;

import lv.javaguru.java2.database.JDBCDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO extends JDBCDatabase
                                 implements UserDatabase {

    @Override
    public void add(UserModel user) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into USERS(id, login, password, created, name, surname, email, role) " +
                    "values(default, ?, ?, NOW(), ?, ?, ?, ?)";
            PreparedStatement ps =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4,user.getSurname());
            ps.setString(5,user.getEmail());
            ps.setString(6,"U");

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<UserModel> findByLogin(String login) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from USERS where LOGIN = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserModel user = null;
            if (resultSet.next()) {
                user = mapUserModel(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<UserModel> findByName(String name) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from USERS where NAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserModel user = null;
            if (resultSet.next()) {
                user = mapUserModel(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByName()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<UserModel> findBySurname(String surname) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from USERS where SURNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserModel user = null;
            if (resultSet.next()) {
                user = mapUserModel(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getBySurname()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void remove(UserModel user) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "UPDATE USERS SET STATUS='D' WHERE ID=? and login=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from USERS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel user = mapUserModel(resultSet);
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

    private UserModel mapUserModel(ResultSet resultSet) throws SQLException{
        UserModel user = new UserModel();
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setCreated(resultSet.getDate("created"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }

}
