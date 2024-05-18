package org.taba.java.jdbc.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    static Dotenv dotenv = Dotenv.load();
    private static String url = "jdbc:mysql://localhost:3306/" + Dotenv.load().get("DB_NAME") + "?serverTimezone=UTC";
    private static String user = dotenv.get("DB_USER");
    private static String password = dotenv.get("DB_PASSWORD");
    private static Connection connection = null;

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
