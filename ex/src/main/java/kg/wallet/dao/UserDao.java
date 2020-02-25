package kg.wallet.dao;

import kg.wallet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "select * from user2 ";
        try (Connection conn = DB.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(SQL)) {
            while (rs.next()) {
                users.add(User.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .gender(rs.getString("GENDER"))
                        .yearOfBirth(rs.getInt("DATE_OF_BIRTH"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int id) {
        String SQL = "select * from user2 where id = ? ";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return User.builder()
                            .id(rs.getInt("ID"))
                            .name(rs.getString("NAME"))
                            .gender(rs.getString("GENDER"))
                            .yearOfBirth(rs.getInt("DATE_OF_BIRTH"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User updateUser(User user) {
        String SQL = "update user2 set name=?, gender=?,date_of_birth=? where id = ?";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getGender());
            statement.setInt(3, user.getYearOfBirth());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser(User user) {
        String SQL = "insert into user2(name, gender, date_of_birth) values (?, ?, ?)";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getGender());
            statement.setInt(3, user.getYearOfBirth());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUserById(int id) {
        String SQL = "delete from users where id = ?";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}