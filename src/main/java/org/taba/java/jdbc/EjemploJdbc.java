package org.taba.java.jdbc;

import io.github.cdimascio.dotenv.Dotenv;
import org.taba.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance();
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
