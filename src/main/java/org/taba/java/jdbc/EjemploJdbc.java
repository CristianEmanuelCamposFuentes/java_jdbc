package org.taba.java.jdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {
        // Cargar las variables de entorno
        Dotenv dotenv = Dotenv.load();

        String url = "jdbc:mysql://localhost:3306/" + dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            // Devuelve un cursor con todos los registros de la tabla
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id") + " Nombre: " + resultado.getString("nombre"));
            }
            resultado.close();
            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
