package org.example;

import org.example.model.Empleado;
import org.example.model.Empleados;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

;

public class Main {

    private static String path = "./src/main/java/org/example/empleados.xml";                   // Ruta del fichero xml

    private static List<String[]> empArrays = new ArrayList<>();                               //Aqui guardaremos los empleados que saquemos del xml para luego guardarlos en la bbdd

    public static void main(String[] args) {

        try {
            Connection conn = DBConnection.getConnection();                                       // Creamos la conexion
            PlantillaDAO plantilla = new PlantillaDAO(conn);                                      // Instanciamos la clase
            readXML();                                                                            // Leemos el fichero y volcamos los datos en el ArrayList

            for (String[] array : empArrays) {                                                    // Sacamos los datos de ArrayList y los enviamos al DAO
                if (array.length >= 4) {
                    plantilla.altaEmpleado(array[0], array[1], array[2], array[3]);
                }
            }

            System.out.println("La cantidad de empleados es: " + PlantillaDAO.getIdEmpleados());
            conn.close();                                                                          // Cerramos la conexion

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Leemos el fichero y pasamos los datos a un ArrayList
    private static void readXML() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Empleados.class);
            Unmarshaller um = ctx.createUnmarshaller();

            File fileEmpleados = new File(path);
            Empleados empleados = (Empleados) um.unmarshal(fileEmpleados);

            for (Empleado empleado : empleados.getEmpleados()) {
                // Pasamos los datos a un array
                String[] empArray = {empleado.getNombre(), empleado.getApellido(), empleado.getDni(), empleado.getDepto()};
                empArrays.add(empArray);            // Guardamos cada array en un ArrayList

            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}


