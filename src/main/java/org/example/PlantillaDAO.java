package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantillaDAO {


    private Connection connection;

    private static int idEmpleados;

    public PlantillaDAO(Connection connection) {
        this.connection = connection;
    }

    //Metodo para agregar los empleados a la bbdd

    public void altaEmpleado(String name, String apellido, String dni, String depto) {

        String insertQuery = "INSERT INTO empleados (nombre, apellido, dni, depto) VALUES (?, ?, ?, ?) RETURNING id;";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, name);
            statement.setString(2, apellido);
            statement.setString(3, dni);
            statement.setString(4, depto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {                                 // Aqui guardamos los id para luego saber cuantos empleados tenemos
                idEmpleados = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int getIdEmpleados() {
        return idEmpleados;
    }

}
