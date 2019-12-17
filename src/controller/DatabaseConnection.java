/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tuananh
 */
public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/evn";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Done");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    

}