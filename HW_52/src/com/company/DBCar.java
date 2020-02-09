package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCar {


    public Car getCarById(int id) {
        String query = "select * from car where id=?";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setManufactureYear(resultSet.getInt("manufacture_year"));
                    car.setModel(resultSet.getString("model"));
                    car.setModel(resultSet.getString("model"));
                    car.setPrice(resultSet.getInt("price"));
                    car.setColor(resultSet.getString("color"));
                    return car;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> getAll() throws SQLException {
        String SQL = "SELECT * FROM car";
        List<Car> carList = new ArrayList<>();
        try (Connection connection=DB.connect();
        Statement statement = connection.createStatement();
             ResultSet resultSet =statement.executeQuery(SQL)){
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setManufactureYear(resultSet.getInt("manufacture_year"));
                car.setModel(resultSet.getString("model"));
                car.setModel(resultSet.getString("model"));
                car.setPrice(resultSet.getInt("price"));
                car.setColor(resultSet.getString("color"));
                carList.add(car);
            }
            }
        catch (Exception e){
            e.printStackTrace();
        }
        return carList;
    }
}
