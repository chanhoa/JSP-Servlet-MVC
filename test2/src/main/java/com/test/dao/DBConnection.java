package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String DB_URL = "jdbc:mysql://localhost:3306/starbucks";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    private static Connection conn = null;

    private static   DBConnection intance;

    public static DBConnection getInstance(){
        if(intance==null){
            intance = new DBConnection();
        }
        return intance;
    }

    public  Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}
