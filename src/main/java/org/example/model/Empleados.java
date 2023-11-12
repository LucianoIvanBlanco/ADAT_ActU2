package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "empleados")
public class Empleados {

    private List<Empleado> empleados;


    public List<Empleado> getEmpleados() {
        return empleados;
    }

    @XmlElement(name = "empleado")
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
