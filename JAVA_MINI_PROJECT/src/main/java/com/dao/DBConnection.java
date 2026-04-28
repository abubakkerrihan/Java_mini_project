package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection utility class.
 * Centralizes JDBC connection management.
 */
public class DBConnection {

    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String URL      = "jdbc:mysql://localhost:3306/MarkDB?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";  // Change as per your MySQL setup

    // Private constructor – utility class, no instantiation
    private DBConnection() {}

    /**
     * Returns a new JDBC Connection.
     * Caller is responsible for closing it.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}