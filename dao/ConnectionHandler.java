package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            FileInputStream file = new FileInputStream("src/connection.properties");
            Properties prop = new Properties();
            prop.load(file);
            String driver = (String) prop.get("driver");
            String connUrl = (String) prop.get("connection-url");
            String uname = (String) prop.get("user");
            String pswd = (String) prop.get("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(connUrl, uname, pswd);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
}
