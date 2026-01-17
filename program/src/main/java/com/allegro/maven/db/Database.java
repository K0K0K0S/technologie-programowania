package com.allegro.maven.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{

    private static final String URL =
        "jdbc:mysql://hopper.proxy.rlwy.net:29959/railway";

    private static final String USER = "root";
    private static final String PASSWORD = "oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK";

    private Database() 
    {
        // blokada tworzenia obiektów
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}