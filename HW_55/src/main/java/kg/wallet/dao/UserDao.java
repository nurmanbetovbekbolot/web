package kg.wallet.dao;

import kg.wallet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserDao {
    private static HashMap<Integer, User> users = new HashMap<>();

//    static {
//        User user1 = new User();
//        User user2 = new User();
//        user1.setId(1);
//        user1.setName("User1");
//        user1.setPassword("123");
//        user1.setCreatedDate(new Date());
//
//        user2.setId(2);
//        user2.setName("User2");
//        user2.setPassword("321");
//        user2.setCreatedDate(new Date());
//        users.put(1, user1);
//        users.put(2, user2);
//    }

//    public List<User> getUsers() {
//        return new ArrayList<>(users.values());
//    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "select * from users ";
        try (Connection conn = DB.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(SQL)) {
            while (rs.next()) {
                users.add(User.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .password(rs.getString("PASSWORD"))
                        .createdDate(rs.getTimestamp("CREATED_DATE"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int id) {
        String SQL = "select * from users where id = ? ";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return User.builder()
                            .id(rs.getInt("ID"))
                            .name(rs.getString("NAME"))
                            .password(rs.getString("PASSWORD"))
                            .createdDate(rs.getTimestamp("CREATED_DATE"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User updateUser(User user) {
        String SQL = "update users set name=?, password=? where id = ?";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser(User user) {
        String SQL = "insert into users(name, password, created_date) values (?, ?, now())";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
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