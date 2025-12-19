package org.kniit.lab11.task24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:users.db";

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.err.println("Драйвер SQLite не найден! Добавьте jar-файл в проект.");
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
}
