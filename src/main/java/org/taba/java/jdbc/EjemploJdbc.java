package org.taba.java.jdbc;

import org.taba.java.jdbc.models.Producto;
import org.taba.java.jdbc.repository.ProductoRepositorioImpl;
import org.taba.java.jdbc.repository.Repositorio;
import org.taba.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {

    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porId(1L));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
