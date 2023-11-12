package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgresql";

    // Creamos la conexion
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            // Creamos la tabla en caso de que no exista.

            String createTableMarcas = "CREATE TABLE IF NOT EXISTS empleados (id SERIAL , nombre VARCHAR(255), apellido VARCHAR(255), dni VARCHAR(10) PRIMARY KEY, depto VARCHAR(255));";
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableMarcas);
            System.out.println("Tabla 'empleados' creada correctamente.");

            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}