package com.sunny.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesService {
    private final String addCity = "INSERT INTO cities VALUES ('%s', '%s')";
    private final String getAllCities = "SELECT * FROM cities";
    private final String getCitiesByFirstChar = "SELECT name FROM cities WHERE name LIKE ";
    static final String DB_URL = "jdbc:sqlite:C:/sqlite/homeworks.db";


    private Connection createConnection(){
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCity(City city) {
        Connection connection = createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = String.format(addCity, city.getId(), city.getName());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<City> getCities(String key) {
        List<City> citiesList = new ArrayList<>();
        Connection connection = createConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getCitiesByFirstChar + "'" + key + "%'");

            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
//                String id  = rs.getString("id");
                String name = rs.getString("name");

                City city = new City(name);
                citiesList.add(city);
            }
            //Clean-up environment
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citiesList;
    }

}
