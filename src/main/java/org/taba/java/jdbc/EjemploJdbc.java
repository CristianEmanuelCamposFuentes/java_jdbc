package org.taba.java.jdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {
        // Cargar las variables de entorno
        Dotenv dotenv = Dotenv.load();

        String url = "jdbc:mysql://localhost:3306/" + dotenv.get("DB_NAME") + "?serverTimezone=UTC";
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

            while (resultado.next()) {
                System.out.print("ID: " + resultado.getInt("id") + " Nombre: " + resultado.getString("nombre"));
                System.out.print(" | Precio: " + resultado.getDouble("precio"));
                System.out.println(" | Fecha: " + resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
