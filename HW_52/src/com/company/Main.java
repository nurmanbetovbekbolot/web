package com.company;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class Main {
    static DBCar dbCar = new DBCar();

    public static void main(String[] args) throws SQLException {
        HashMap<Integer, Car> cars = new HashMap<>();
        List<Car> cars1 =dbCar.getAll();
        for(Car c: cars1) {
            cars.put(c.getId(), c);
        }
      System.out.println(cars);
    }
}