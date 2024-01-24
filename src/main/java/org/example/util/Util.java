package org.example.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getJDBCConnection() {
        Connection connection;

        try {
           connection =  DriverManager.getConnection(URL , USER_NAME ,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Соединение не установлено.");
            throw new RuntimeException(e);

        }
        return connection;
    }
}