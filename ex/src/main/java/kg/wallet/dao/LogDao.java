package kg.wallet.dao;

import kg.wallet.model.Log;
import kg.wallet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LogDao {

    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        String SQL = "select * from logs ";
        try (Connection conn = DB.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(SQL)) {
            while (rs.next()) {
                logs.add(Log.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .gender(rs.getString("GENDER"))
                        .yearOfBirth(rs.getInt("DATE_OF_BIRTH"))
                        .date(rs.getDate("CREATED_DATE"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public User createLog(User log) {
        String SQL = "insert into logs(name, gender, date_of_birth,created_date) values (?, ?, ?,now())";
        try (Connection conn = DB.connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, log.getName());
            statement.setString(2, log.getGender());
            statement.setInt(3, log.getYearOfBirth());
            statement.executeUpdate();
            return log;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteLogById(int id) {
        String SQL = "delete from logs where id = ?";
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